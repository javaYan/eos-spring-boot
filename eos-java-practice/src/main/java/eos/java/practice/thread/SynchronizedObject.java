package eos.java.practice.thread;

import lombok.Getter;
import lombok.Setter;

/**
 * Created by yanyuyu on 2017/3/17.
 */
public class SynchronizedObject {

    public synchronized void sleep() throws InterruptedException {
        System.out.println(Thread.currentThread().getName() + " sleep");
        Thread.sleep(2000);
        System.out.println(Thread.currentThread().getName() + " quit sleep");
    }

    public synchronized void wake() throws InterruptedException {
        System.out.println(Thread.currentThread().getName() + " wake");
        Thread.sleep(2000);
        System.out.println(Thread.currentThread().getName() + " quit wake");
    }


    static class  SleepThread implements Runnable {
        @Getter @Setter
        private SynchronizedObject synchronizedObject;
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
        private SynchronizedObject synchronizedObject;
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
        SynchronizedObject obj = new SynchronizedObject();
        SleepThread sleepThread = new SleepThread();
        WakeThread wakeThread = new WakeThread();
        sleepThread.setSynchronizedObject(obj);
        wakeThread.setSynchronizedObject(obj);

        Thread thread1 = new Thread(sleepThread);
        Thread thread2 = new Thread(wakeThread);
        thread1.start();
        thread2.start();

        //输出结果 说明一个对象的一个synchonized方法只能由一个线程访问
        /**
         * Thread-0 sleep
         * Thread-0 quit sleep
         * Thread-1 wake
         * Thread-1 quit wake
         */
    }

}
