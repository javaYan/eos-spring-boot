package eos.java.practice.cyclicbarrier;

import java.util.concurrent.CyclicBarrier;

/**
 * Created by yanyuyu on 2017/2/4.
 */
public class CycleMission {

    /**
     *  CyclicBarrier 为循环线程锁
     *  CyclicBarrier初始化时规定一个数目，然后计算调用了CyclicBarrier.await()进入等待的线程数。当线程数达到了这个数目时，所有进入等待状态的线程被唤醒并继续。
     *  CyclicBarrier就象它名字的意思一样，可看成是个障碍， 所有的线程必须到齐后才能一起通过这个障碍。
     *  CyclicBarrier初始时还可带一个Runnable的参数， 此Runnable任务在CyclicBarrier的数目达到后，所有其它线程被唤醒前被执行
     *  Mission1中第一个await执行条件是有N个线程await
     *  开始执行Mission2
     *  Mission1中第二个await执行条件是有N个线程await
     *  开始执行Mission2
     */

    public static class Mission1 implements Runnable {

        private CyclicBarrier cyclicBarrier;

        private String worker;

        public Mission1(CyclicBarrier cyclicBarrier, String worker) {
            this.cyclicBarrier = cyclicBarrier;
            this.worker = worker;
        }

        @Override
        public void run() {
            try {
                System.out.println("worker -" + worker + " 等待人数满足");
                cyclicBarrier.await();

                Thread.sleep(1000L);
                System.out.println("worker -" + worker + " 任务完成");

                cyclicBarrier.await();

            } catch (Exception e) {
                e.printStackTrace();
            }

        }
    }

    public static class Mission2 implements Runnable {

        private boolean flag;

        private int N;

        public Mission2(boolean flag, int N) {
            this.flag = flag;
            this.N = N;
        }

        @Override
        public void run() {
            if(flag) {
                System.out.println("---Mission2 全部工人工作完成");
            } else {
                System.out.println("---Mission1 就绪，工人开始工作");
                flag = true;
            }
        }
    }

    public static void main(String[] args) {
        boolean flag = false;
        int N = 5;
        Thread [] workers = new Thread[N];
        CyclicBarrier cycle = new CyclicBarrier(N, new Mission2(flag, N));

        System.out.println("开始任务");
        for(int i=0; i<5; i++) {
            System.out.println("任务"+i+"准备开始");
            workers[i] = new Thread(new Mission1(cycle, "工人"+i));
            workers[i].start();
        }

    }


}
