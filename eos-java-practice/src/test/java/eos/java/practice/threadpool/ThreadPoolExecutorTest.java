package eos.java.practice.threadpool;

import org.junit.Test;
import org.junit.internal.runners.statements.RunAfters;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * Created by yanyuyu on 2017/3/7.
 */
public class ThreadPoolExecutorTest {
    @Test
    public void testRejectedExecutionHandler() {
        int corePoolSize = 10;
        int maximumPoolSize = 15;
        long keepAliveTime = 1000;
        TimeUnit unit = TimeUnit.MILLISECONDS;
        BlockingQueue<Runnable> workQueue = new ArrayBlockingQueue<Runnable>(5, false);
        //CallerRunsPolicy 拒绝策略，队列满时阻塞主线程的执行
        ThreadPoolExecutor executor = new ThreadPoolExecutor(corePoolSize, maximumPoolSize, keepAliveTime, unit, workQueue, new ThreadPoolExecutor.CallerRunsPolicy());
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(1000L);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };

        for(int i = 0; i < 1000; i ++) {
            System.out.println("调用执行..." + System.currentTimeMillis());
            executor.execute(runnable);
        }

        try {
            Thread.sleep(10000000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
