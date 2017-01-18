package eos.java.practice.map.auxiliary;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by yanyuyu on 2017/1/18.
 */
public class ConcurrentHashMapThread implements  Runnable{
    public static final Map<Long,Integer> map = new ConcurrentHashMap<Long,Integer>();

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + " start...");
        for(int i = 0; i < 1000000; i++) {
            map.put(Long.valueOf(i),i);
        }
        System.out.println(Thread.currentThread().getName() + " end...");
    }
}
