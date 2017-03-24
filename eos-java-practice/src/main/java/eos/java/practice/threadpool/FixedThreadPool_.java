package eos.java.practice.threadpool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by yanyuyu on 2017/1/12.
 */
public class FixedThreadPool_ {

    public static void main(String [] args) {

        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                try {
                    System.out.println("---------------"+Thread.currentThread().getName());
                    Thread.sleep(2000);
                    System.out.println("+++++++++++++++"+Thread.currentThread().getName());
                } catch (Exception e) {

                }
            }
        };

        ExecutorService executor = Executors.newFixedThreadPool(5); //固定线程池
        //new ThreadPoolExecutor(nThreads, nThreads,0L, TimeUnit.MILLISECONDS, new LinkedBlockingQueue<Runnable>())


        for(int i = 0; i < 10; i ++) {
            executor.execute(runnable);
        }

        executor.shutdown();
    }
}
