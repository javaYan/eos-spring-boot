package eos.oj.test;

import java.util.Random;

/**
 * Title: Test
 * Author: yanyuyu
 * Date: 2017-04-19 16:42
 */
public class Test {
    @org.junit.Test
    public void testRandom() {
        for(int i = 0; i < 100; i ++) {
            System.out.print(new Random().nextInt(10)+ ",");
        }
    }
}
