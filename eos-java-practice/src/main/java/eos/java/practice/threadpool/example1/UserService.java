package eos.java.practice.threadpool.example1;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.*;

/**
 * Created by Mr_yyy on 2017/2/20.
 */
@Service("userService")
public class UserService {

    private final static int BATCH_USERS_PER_THEAD = 50;

    public Map<Long,UserVo> batchExecute(List<Long> userIds) {
        long startTime = System.currentTimeMillis();
        ThreadPoolExecutor executor = new ThreadPoolExecutor(10, 10, 1000, TimeUnit.SECONDS, new ArrayBlockingQueue(3000));

        final ConcurrentHashMap<Long, UserVo> usersMap = new ConcurrentHashMap<Long,UserVo>();
        int size = userIds.size();
        int batchs = size/BATCH_USERS_PER_THEAD;
        if(size % BATCH_USERS_PER_THEAD != 0) {
            batchs ++;
        }
        final CountDownLatch countDownLatch = new CountDownLatch(batchs);

        for(int i=0; i < size; i+=BATCH_USERS_PER_THEAD ) {
            int fromIndex = i;
            int toIndex = (i+BATCH_USERS_PER_THEAD) >= size? size:(i+BATCH_USERS_PER_THEAD);
            final List<Long> splitUserIds = userIds.subList(fromIndex,toIndex);
            executor.execute(new Runnable() {
                @Override
                public void run() {
                    try {
                        System.out.println("splitUserIds --- " + splitUserIds.toString());
                        Thread.sleep(3000);
                        usersMap.putAll(loadUsers(splitUserIds));
                    } catch (InterruptedException ie) {
                        ie.printStackTrace();
                    } finally {
                        countDownLatch.countDown();
                    }

                }
            });
        }

        try {
            countDownLatch.await();
            System.out.println("所有线程执行完毕！");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        long endTime = System.currentTimeMillis();
        System.out.println(usersMap.keySet().toString());
        System.out.println("cost " + (endTime - startTime ) / 1000 + " s");
        return usersMap;
    }

    private Map<Long,UserVo> loadUsers(List<Long> userIds) {
        Map<Long,UserVo> usersMap = new HashMap<Long,UserVo>();
        int size = userIds.size();
        for(int i=0; i<size; i++) {
            UserVo vo = new UserVo();
            vo.setId(userIds.get(i));
            vo.setIcon("http://"+userIds.get(i)+".jpg");
            vo.setNickname("kick_"+String.format("%3d",userIds.get(i)));
            usersMap.put(userIds.get(i), vo);
        }
        return usersMap;
    }
}
