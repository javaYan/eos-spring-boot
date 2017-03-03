package eos.java.practice.threadlocal;

/**
 * Created by yanyuyu on 2017/3/3.
 *
 * ThreadLocal本质是一个线程局部对象操作的工具
 * 在每个线程内部，存放一个ThreadLocalMap对象，用于存放属于线程自己的局部变量
 * ThreadLocal的set和get 实质是根据当前线程为Key，去查找线程内部的ThreadLocalMap 存储的值
 */
public class MyThread extends Thread{

    private static ThreadLocal ownerValuesUtil = new ThreadLocal();
    @Override
    public void run() {
        int i = 1;
        while(i < 6) {
            Object value = ownerValuesUtil.get();
            if (value == null) {
                System.out.println(Thread.currentThread().getName() + "," + Thread.currentThread().hashCode() + " ---- init");
                ownerValuesUtil.set(Thread.currentThread().getName() + "," + Thread.currentThread().hashCode());
            } else {
                System.out.println(value + " ---- get it !");
                ownerValuesUtil.set(Thread.currentThread().getName() + "," + Thread.currentThread().hashCode() + i);
            }
            i ++;
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String []args) throws InterruptedException {
        MyThread thread1 = new MyThread();
        MyThread thread2 = new MyThread();
        MyThread thread3 = new MyThread();
        MyThread thread4 = new MyThread();
        MyThread thread5 = new MyThread();
        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();
        thread5.start();
    }
}
