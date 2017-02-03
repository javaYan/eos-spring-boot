package eos.java.practice.reentrantlock;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by yanyuyu on 2017/2/3.
 */
public class AwaitSignal implements Runnable{

    //说明：此处使用public是为了方便测试类中使用，在真实代码中尽量避免声明锁相关的变量为public类型
    public static Lock lock = new ReentrantLock();

    /**
     * 可以唤醒或阻塞相关线程
     * await会使当前持有锁的线程释放所有权
     * 使用await/signal时必须保证当前线程持有锁，否则抛异常
     */
    public static Condition condition = lock.newCondition();

    @Override
    public void run() {
        try {
            System.out.println(Thread.currentThread().getName() + " is running ...");
            lock.lock();
            System.out.println(Thread.currentThread().getName() + " get lock ...");
            System.out.println(Thread.currentThread().getName() + " await ...");
            condition.await();
        } catch (InterruptedException ie) {
            ie.printStackTrace();
        } finally {
            System.out.println(Thread.currentThread().getName() + " signal ...");
            lock.unlock();
        }

    }
}
