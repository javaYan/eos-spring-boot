package eos.java.practice.string_test;

import org.junit.Test;

import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

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

    @Test
    public void testGBK_UTF8() throws UnsupportedEncodingException {
        System.out.println("--------------------------\n");
        String originalStr = "woai我家1314";
        String utf8Str = new String(originalStr.getBytes("utf-8"), "gbk");
        System.out.println(utf8Str);
        String gbkStr = new String(utf8Str.getBytes("gbk"), "utf-8");
        System.out.println(gbkStr);
        System.out.println("--------------------------\n");

        System.out.println("--------------------------\n");
        String originalStr1 = "hello中国人";
        String utf8Str1 = new String(originalStr1.getBytes("utf-8"), "gbk");
        System.out.println(utf8Str1);
        String gbkStr1 = new String(utf8Str1.getBytes("gbk"), "utf-8");
        System.out.println(gbkStr1);
        System.out.println("--------------------------\n");

        //woai我家1314可以由UTF8 转为GBK 再转为UTF8  输出没毛病
        //hello中国人 由UTF8 转为GBK 再转为UTF8  输出会有乱码
        //说明字符并不是可以由编码任意转换的
        //GBK转UTF-8时，奇数个中文会乱码，偶数个中文不会乱码。
    }

    @Test
    public void testGBKSub() throws UnsupportedEncodingException {
        System.out.println("--------------------------\n");
        String str = new String("woai我家1314".getBytes(), StandardCharsets.UTF_8);
        System.out.println(str);
        System.out.println(str.substring(0,4));
        System.out.println(str.substring(0,5));
        System.out.println(str.substring(0,6));
        System.out.println("--------------------------\n");

        String str1 = new String("woai我家1314".getBytes(),StandardCharsets.ISO_8859_1);
        System.out.println(str1);
        System.out.println(str1.substring(0,4));
        System.out.println(str1.substring(0,5));
        System.out.println(str1.substring(0,6));
        System.out.println("--------------------------\n");

        String str2 = new String("woai我家1314".getBytes(), "GBK");
        System.out.println(str2);
        System.out.println(str2.substring(0,4));
        System.out.println(str2.substring(0,5));
        System.out.println(str2.substring(0,6));
        System.out.println("--------------------------\n");

        String str3 = new String("woai我家1314".getBytes(), "GBK");
        System.out.println(str3);
        System.out.println(str3.substring(4,5));
        System.out.println(str3.substring(4,6));
        System.out.println(str3.substring(4,7));
        System.out.println("--------------------------\n");
    }

    /**
     * String的hashCode计算方式：
     * s[0]*31^(n-1) + s[1]*31^(n-2) + ... + s[n-1]
     * 主要是因为31是一个奇质数，所以31*i=32*i-i=(i<<5)-i，这种位移与减法结合的计算相比一般的运算快很多
     */
    @Test
    public void testHashCode() {
        System.out.println("a".hashCode());
        System.out.println("b".hashCode());
        System.out.println("c".hashCode());
        System.out.println("d".hashCode());
        System.out.println("e".hashCode());
        System.out.println("f".hashCode());
        System.out.println("ab".hashCode());
        System.out.println(97*31 + 98);

    }
}