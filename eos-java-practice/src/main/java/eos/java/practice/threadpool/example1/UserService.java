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

    private final static int THREAD_POOL_SIZE = 10;

    public Map<Long,UserVo> batchExecute(List<Long> userIds) {
        long startTime = System.currentTimeMillis();
        Executor executor = Executors.newFixedThreadPool(THREAD_POOL_SIZE);
        final ConcurrentHashMap<Long, UserVo> usersMap = new ConcurrentHashMap<Long,UserVo>();
        int size = userIds.size();
        int batches = size/BATCH_USERS_PER_THEAD;
        if(size % BATCH_USERS_PER_THEAD != 0) {
            batches ++;
        }
        final CountDownLatch countDownLatch = new CountDownLatch(batches);

        for(int i=0; i < size; i+=BATCH_USERS_PER_THEAD ) {
            int fromIndex = i;
            int toIndex = (i+BATCH_USERS_PER_THEAD) >= size? size:(i+BATCH_USERS_PER_THEAD);
            final List<Long> splitUserIds = userIds.subList(fromIndex,toIndex);
            executor.execute(new Runnable() {
                @Override
                public void run() {
                    try {
                        System.out.println("splitUserIds --- " + splitUserIds.toString());
                        Thread.sleep(10);
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
        System.out.println("total " + usersMap.keySet().size() +":"+ usersMap.keySet().toString());
        System.out.println("cost " + (endTime - startTime ) / 1000 + " s");
        return usersMap;
    }

    private Map<Long,UserVo> loadUsers(List<Long> userIds) {
        Map<Long,UserVo> usersMap = new HashMap<Long,UserVo>();
        int size = userIds.size();
        for(int i=0; i<size; i++) {
            UserVo vo = new UserVo();
            vo.setId(userIds.get(i));
            vo.setIcon("http://"+String.format("%06d",userIds.get(i))+".jpg");
            vo.setNickname("kick_"+String.format("%06d",userIds.get(i)));
            usersMap.put(userIds.get(i), vo);
        }
        return usersMap;
    }
}
