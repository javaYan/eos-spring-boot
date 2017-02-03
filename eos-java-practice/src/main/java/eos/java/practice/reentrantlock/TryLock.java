package eos.java.practice.reentrantlock;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by yanyuyu on 2017/2/3.
 */
public class TryLock implements Runnable{

    private static Lock lock = new ReentrantLock();

    @Override
    public void run() {
        try {
            if(lock.tryLock()) {
                System.out.println("---获取锁");
                Thread.sleep(10L);
                lock.unlock();
            } else {
                System.out.println("---未获取锁");
                if(lock.tryLock(1, TimeUnit.SECONDS)) {
                    System.out.println("---tryLock 1秒获取锁");
                    Thread.sleep(100L);
                    lock.unlock();
                } else {
                    System.out.println("---tryLock 1秒未获取锁");
                }

            }
        } catch ( InterruptedException ie ) {
            ie.printStackTrace();
        }
    }

}
