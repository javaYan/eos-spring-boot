package eos.java.practice.semaphore;

import org.junit.Test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by yanyuyu on 2017/2/3.
 */
public class SemaphoreTest {

    @Test
    public void testNormal() {

        ExecutorService es = Executors.newFixedThreadPool(20);
        for(int i=0; i<20; i++) {
            es.submit(new Normal());
        }

        try {
            Thread.sleep(20000L);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
