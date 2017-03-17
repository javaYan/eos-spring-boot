package eos.java.practice.thread;

import lombok.Getter;
import lombok.Setter;

/**
 * Created by yanyuyu on 2017/3/17.
 */
public class SynchronizedObject1 {

    private static byte[] lockByte = new byte[1];

    public void sleep() throws InterruptedException {
        synchronized (lockByte) {
            System.out.println(Thread.currentThread().getName() + " sleep");
            Thread.sleep(2000);
            System.out.println(Thread.currentThread().getName() + " quit sleep");
        }
    }

    public void wake() throws InterruptedException {
        synchronized (lockByte) {
            System.out.println(Thread.currentThread().getName() + " wake");
            Thread.sleep(2000);
            System.out.println(Thread.currentThread().getName() + " quit wake");
        }
    }


    static class  SleepThread implements Runnable {
        @Getter @Setter
        private SynchronizedObject1 synchronizedObject;
        @Override
        public void run() {
            try {
                synchronizedObject.sleep();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    static class WakeThread implements Runnable {
        @Getter @Setter
        private SynchronizedObject1 synchronizedObject;
        @Override
        public void run() {
            try {
                synchronizedObject.wake();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }


    public static void main(String [] args) {
        SynchronizedObject1 obj = new SynchronizedObject1();
        SleepThread sleepThread = new SleepThread();
        WakeThread wakeThread = new WakeThread();
        sleepThread.setSynchronizedObject(obj);
        wakeThread.setSynchronizedObject(obj);

        Thread thread1 = new Thread(sleepThread);
        Thread thread2 = new Thread(wakeThread);
        thread1.start();
        thread2.start();

        //输出结果 说明一个线程访问某个对象的某个synchronized方法时 其他线程不能访问此对象的其他synchronized方法
        /**
         * Thread-0 sleep
         * Thread-0 quit sleep
         * Thread-1 wake
         * Thread-1 quit wake
         */
    }

}
