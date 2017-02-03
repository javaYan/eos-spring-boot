package eos.java.practice.semaphore;

import java.util.concurrent.Semaphore;

/**
 * Created by yanyuyu on 2017/2/3.
 */
public class    Normal implements Runnable{
    /**
     * 信号量
     * 允许多个线程同时进入临界区的锁
     */
    private static final Semaphore semaphore = new Semaphore(5);

    @Override
    public void run() {
        try {
            semaphore.acquire();
            System.out.println(Thread.currentThread().getName() + "获取锁");
            Thread.sleep(5000L);
            semaphore.release();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
