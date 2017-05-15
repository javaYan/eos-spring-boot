package eos.java.practice.string_test;

import org.apache.commons.lang.ArrayUtils;
import org.junit.Test;
import org.springframework.util.StringUtils;

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

    //注意！！！ String.split() 不能将一个字符串作为分隔符  如想要分割abcdeabefeg中的ab为分割 这样实现不了
    //而org.springframework.util.StringUtils.split 这个可以，但是只能分割第一个出现的，不支持全部分割
    @Test
    public void testSplit() {
        String SPLIT_ADDR = "[-addr-]";
        StringBuffer addressBuilder = new StringBuffer();
        String s = "NEW DELHI[-addr-]1912 B, 2nd floor, gali no. 19, Govindpuri Extension, Kalkaji[-addr-] ";
        String[] subAddress = org.springframework.util.StringUtils.split(s, SPLIT_ADDR);
        String[] subAddress2 = org.springframework.util.StringUtils.split(subAddress[1], SPLIT_ADDR);
        addressBuilder.append(subAddress2[0]);
        if(subAddress2.length > 1 && subAddress2[1].length() > 0) {
            addressBuilder.append(" ").append(subAddress2[1]);
        }
        addressBuilder.append(", ").append(subAddress[0]);
        System.out.println(addressBuilder.toString());
    }


    /**
     * 测试字符串按字节截取 保证截取之后的字符串不会非法（汉字不会被截断）
     * @throws UnsupportedEncodingException
     */
    @Test
    public void testAscii1() throws UnsupportedEncodingException {
        //String bytesString = new String("第20个字节是可以截取的");
        String bytesString = new String("第020个字节是不可以截取的");
        byte[] bytes = bytesString.getBytes("GB18030");
        //现在要截数组：截取索引是20
        int cutIndex = 20;
        byte[] subarray = null;
        String temp = null;
        for(int i = 0; i < 4; i ++) {
            subarray = ArrayUtils.subarray(bytes, 0, cutIndex - i);
            temp = new String(subarray, "GB18030");
            if((int) temp.charAt(temp.length() - 1) != 65533) {
                System.out.println("找到截取的索引:" + (cutIndex - i));
                break;
            }
        }
    }

}