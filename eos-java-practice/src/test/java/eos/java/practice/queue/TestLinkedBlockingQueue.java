package eos.java.practice.queue;

import org.junit.Test;

import java.util.concurrent.LinkedBlockingQueue;

/**
 * Created by yanyuyu on 2017/3/6.
 */
public class TestLinkedBlockingQueue {
    @Test
    public void testSize() {
        LinkedBlockingQueue<Runnable> linkedBlockingQueue = new LinkedBlockingQueue<Runnable>();
        try {
            Runnable run = new Runnable() {
                @Override
                public void run() {
                    System.out.println("haha" + System.currentTimeMillis());
                }
            };
            linkedBlockingQueue.put(run);
            System.out.println(linkedBlockingQueue.size());
            Thread.sleep(1000L);
            linkedBlockingQueue.put(run);
            System.out.println(linkedBlockingQueue.size());
            Thread.sleep(1000L);
            linkedBlockingQueue.put(run);
            System.out.println(linkedBlockingQueue.size());
            Thread.sleep(1000L);
            linkedBlockingQueue.put(run);
            System.out.println(linkedBlockingQueue.size());
            Thread.sleep(1000L);
            linkedBlockingQueue.put(run);
            System.out.println(linkedBlockingQueue.size());
            Thread.sleep(1000L);
            linkedBlockingQueue.put(run);
            System.out.println(linkedBlockingQueue.size());
            Thread.sleep(1000L);
            linkedBlockingQueue.take();
            System.out.println(linkedBlockingQueue.size());
            Thread.sleep(1000L);
            linkedBlockingQueue.take();
            System.out.println(linkedBlockingQueue.size());
            Thread.sleep(1000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
