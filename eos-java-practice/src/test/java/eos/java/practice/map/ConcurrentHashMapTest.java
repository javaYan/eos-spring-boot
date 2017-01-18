package eos.java.practice.map;

import eos.java.practice.map.auxiliary.ConcurrentHashMapThread;
import eos.java.practice.map.auxiliary.HashMapThread;
import org.junit.Test;

/**
 * Created by yanyuyu on 2017/1/4.
 */
public class ConcurrentHashMapTest {

    /**
     * 测试多线程下concurrentHashMap的线程安全
     * 可以和hashMap作对比
     */
    @Test
    public void testMultiThread() {

        try {
            ConcurrentHashMapThread mapThread1 = new ConcurrentHashMapThread();
            ConcurrentHashMapThread mapThread2 = new ConcurrentHashMapThread();

            Thread thread1 = new Thread(mapThread1);
            Thread thread2 = new Thread(mapThread2);

            thread1.start();
            thread2.start();
            thread1.join();
            thread2.join();

            //下述这种方式不是多线程  是thread1执行完成继续下述的thread2
            /*thread1.start();
            thread1.join();
            thread2.start();
            thread2.join();*/
        } catch (Exception e) {

        }

        System.out.println(ConcurrentHashMapThread.map.size());
        //1000000
    }
}
