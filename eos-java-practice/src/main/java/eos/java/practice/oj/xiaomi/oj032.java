package eos.java.practice.oj.xiaomi;

/**
 判断是否为连乘数字串
 描述

 给出一个字符串S，判断S是否为连乘字符串。
 连乘字符串定义为：
 字符串拆分成若干数字，后面的数字（从第三个数字开始）为前面2个数字的乘积。
 例如：
 122，可以拆成{1|2|2}，有1*2=2
 1122242，可以拆成{11|22|242}，有11*22=242
 1224832256，可以拆成{1|2|2|4|8|32|256}，有1*2=2，2*2=4，2*4=8，4*8=32，8*32=256。

 若是连乘字符串，则输出true，否则输出false。(PS:不考虑乘以0)
 输入

 一个正整数字符串
 输出

 字符串true或者false，表示是否可以拆成连乘数字。
 输入样例

 122

 113

 1122242
 输出样例

 true

 false

 true
 */
public class oj032 {
    private static String solution(String line) {
        // TODO
        return null;
    }

    public static void main(String[] args) {
        System.out.println(solution("abc,badc"));
    }
}
