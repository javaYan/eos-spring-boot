package eos.java.practice.map.auxiliary;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by yanyuyu on 2017/1/18.
 */
public class HashMapThread implements  Runnable{
    public static final Map<Long,Integer> map = new HashMap<Long,Integer>();

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + " start...");
        for(int i = 0; i < 1000000; i++) {
            map.put(Long.valueOf(i), i);
        }
        System.out.println(Thread.currentThread().getName() + " end...");
    }
}
