package eos.java.practice.string_test;

import org.junit.Test;

/**
 * Created by yanyuyu on 2017/3/9.
 */
public class TestString {

    private final String s11 = "a";
    private final String s12 = "b";

    @Test
    public void testEqual() {
        String s1 = "ab";
        String s2 = "ab";
        System.out.println(s1 == s2);       //true

        String s3 = new String("ab");
        String s4 = new String("ab");
        System.out.println(s3 == s4);      //false

        String s5 = "a";
        String s6 = "b";
        System.out.println(s1 == (s5 + s6)); //false

        final String s7 = "a";
        final String s8 = "b";
        System.out.println(s1 == (s7 + s8)); //true

        final String s9;
        s9 = "a";
        final String s10;
        s10 = "b";
        System.out.println(s1 == (s9 + s10)); //false

        System.out.println(s1 == (s11 + s12)); //false

        //在运算中比如字符串相加 如果是声明ji即赋值，则字符串比较结果是true  如果先声明后赋值，则false
    }
}