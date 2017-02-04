package eos.java.practice.countdownlatch;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by yanyuyu on 2017/2/4.
 */
public class Mission implements Runnable{

    /**
     * 倒计时器：多线程控制工具类
     * 允许一个线程一直等待 直到其他前置线程或者任务执行完成（即倒计时器的值为0），此等待线程才开始执行后续操作
     * 用await方法阻塞等待前置任务完成才可以执行的任务或线程
     */
    public static final CountDownLatch countDownLatch = new CountDownLatch(5);

    private static final ReentrantLock lock = new ReentrantLock();


    @Override
    public void run() {
        try {
            lock.lock();
            System.out.println("1个任务完成...");
            Thread.sleep(2000L);
            countDownLatch.countDown();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public static void main(String [] args) {
        for(int i=0; i<10; i++) {
            Thread thread = new Thread(new Mission());
            thread.start();
        }

        try {
            countDownLatch.await();
            System.out.println("前置任务都完成了，允许我运行了");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        //结果：输出6个 “1个任务完成...” 后，输出了“前置任务都完成了，允许我运行了”
    }
}
