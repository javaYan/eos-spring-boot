package eos.java.practice.threadpool;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

/**
 * Created by yanyuyu on 2017/1/12.
 */
public class CacheThreadPool_ {

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

        Executor executor = Executors.newCachedThreadPool(); //无界线程池
        // new ThreadPoolExecutor(0, Integer.MAX_VALUE,60L, TimeUnit.SECONDS,new SynchronousQueue<Runnable>())

        for(int i = 0; i < 1000; i ++) {
            executor.execute(runnable);
        }
    }
}
