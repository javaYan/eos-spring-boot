package eos.java.practice.math;

import org.junit.Test;

/**
 * Created by yanyuyu on 2017/4/5.
 */
public class TestMath {

    @Test
    public void testSqrt() {
        System.out.println(Math.sqrt(16));
    }

    @Test
    public void testPow() {
        System.out.println(Math.pow(4,0));
    }

    /**
     * 计算是否是完全平方数
     */
    @Test
    public void testWanQuanPingFang() {
        int num1 = 16;
        System.out.println(Math.pow((int)Math.sqrt(num1), 2) == num1);
        int num2 = 17;
        System.out.println(Math.pow((int)Math.sqrt(num2), 2) == num2);
        int num3 = 25;
        System.out.println(Math.pow((int)Math.sqrt(num3), 2) == num3);
        int num4 = 37;
        System.out.println(Math.pow((int)Math.sqrt(num4), 2) == num4);
        int num5 = 125;
        System.out.println(Math.pow((int)Math.sqrt(num5), 2) == num5);
    }
}
