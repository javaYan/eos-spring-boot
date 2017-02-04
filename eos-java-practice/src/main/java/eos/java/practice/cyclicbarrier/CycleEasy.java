package eos.java.practice.cyclicbarrier;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * Created by yanyuyu on 2017/2/4.
 */
public class CycleEasy {

    /**
     *  CyclicBarrier 为循环线程锁
     *  CyclicBarrier初始化时规定一个数目，然后计算调用了CyclicBarrier.await()进入等待的线程数。当线程数达到了这个数目时，所有进入等待状态的线程被唤醒并继续。
     *  CyclicBarrier就象它名字的意思一样，可看成是个障碍， 所有的线程必须到齐后才能一起通过这个障碍。
     *  CyclicBarrier初始时还可带一个Runnable的参数， 此Runnable任务在CyclicBarrier的数目达到后，所有其它线程被唤醒前被执行
     */
    private static final CyclicBarrier cycle = new CyclicBarrier(3, new Runnable() {
        @Override
        public void run() {
            System.out.println("await申请的线程数已经满足条件值了，我开始执行");
        }
    });

    public static void main(String[] args) {
        try {
            for(int i = 0; i < 20; i ++) {
                new Thread(new MoNiThread()).start();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static class MoNiThread implements Runnable {

        @Override
        public void run() {
            try {
                System.out.println("模拟线程"+Thread.currentThread().getName()+"申请执行");
                cycle.await();
                System.out.println("模拟线程"+Thread.currentThread().getName()+"允许执行");
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (BrokenBarrierException e) {
                e.printStackTrace();
            }
        }
    }

}
