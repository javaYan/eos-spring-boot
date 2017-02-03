package eos.java.practice.reentrantlock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by yanyuyu on 2017/2/3.
 */
public class Normal implements Runnable{

    /**
     * 重入锁
     * 可选构造方法 ReentrantLock(boolean fair);  表示是否按申请锁的顺序进行公平分配
     */
    private static Lock lock = new ReentrantLock();
    @Override
    public void run() {
        try {
            System.out.println(Thread.currentThread().getName() + " is running!");
            lock.lock();
            Thread.sleep(1000L);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            System.out.println(Thread.currentThread().getName() + " is died!");
            lock.unlock();
        }
    }
}
