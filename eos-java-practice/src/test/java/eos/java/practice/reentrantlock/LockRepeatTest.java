package eos.java.practice.reentrantlock;

import org.junit.Test;

import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by yanyuyu on 2017/2/3.
 */
public class LockRepeatTest {
    /**
     * 重入锁： 即可以重复锁定的锁
     */
    private static ReentrantLock lock = new ReentrantLock();

    @Test
    public void test() {
        try {
            System.out.println("getHoldCount : " + lock.getHoldCount());

            Thread.sleep(1000L);

            System.out.println("isLocked : " + lock.isLocked());

            Thread.sleep(1000L);

            lock.lock();

            System.out.println("getHoldCount : " + lock.getHoldCount());

            Thread.sleep(1000L);

            System.out.println("isLocked : " + lock.isLocked());

            Thread.sleep(1000L);

            System.out.println("get lock first");

            Thread.sleep(1000L);

            lock.lock();

            Thread.sleep(1000L);

            System.out.println("getHoldCount : " + lock.getHoldCount());

            Thread.sleep(1000L);

            System.out.println("isLocked : " + lock.isLocked());

            Thread.sleep(1000L);

            System.out.println("get lock secondly");

            lock.unlock();

            Thread.sleep(1000L);

            System.out.println("getHoldCount : " + lock.getHoldCount());

            Thread.sleep(1000L);

            System.out.println("isLocked : " + lock.isLocked());

            Thread.sleep(1000L);

            lock.unlock();

            Thread.sleep(1000L);

            System.out.println("getHoldCount : " + lock.getHoldCount());

            Thread.sleep(1000L);

            System.out.println("isLocked : " + lock.isLocked());
        } catch (Exception e) {
            e.printStackTrace();
        }


    }
}
