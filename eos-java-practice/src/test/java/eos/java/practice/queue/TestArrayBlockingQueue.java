package eos.java.practice.queue;

import org.junit.Test;

import java.util.concurrent.ArrayBlockingQueue;

/**
 * Created by yanyuyu on 2017/3/22.
 */
public class TestArrayBlockingQueue {
    @Test
    public void testBoundary() {
        ArrayBlockingQueue<Integer> queue = new ArrayBlockingQueue<Integer>(5);
        for(int i = 0; i < 10; i ++) {  //报错
            queue.add(i);
        }
    }

    @Test
    public void testBoundary2() {
        ArrayBlockingQueue<Integer> queue = new ArrayBlockingQueue<Integer>(5);
        for(int i = 0; i < 10; i ++) {  //报错
            if(queue.size() >= 5) {
                Integer poll = queue.poll(); //poll取出  peek只是查看
                System.out.println("取出元素: " + poll);
            }
            queue.add(i);
        }
    }
}
