package eos.java.practice.oj.xiaomi;

/**
 反向位整数
 描述

 输入32位无符号整数，输出它的反向位。
 例，输入4626149（以二进制表示为00000000010001101001011011100101），返回2808701440（以二进制表示为10100111011010010110001000000000）。
 输入

 一个无符号32位整数字符串
 输出

 一个无符号32位整数，为输入整数的反向位
 输入样例

 4626149
 输出样例

 2808701440

 */
public class oj030 {
    private static String solution(String line) {
        long number = Long.parseLong(line);
        int[] bits = new int[32];
        for(int i = 31; i >= 0; i --) {
            if(number > 0) {
                bits[i] = (int)(number%2);
                number = number/2;
            } else {
                bits[i] = 0;
            }
        }
        long reverseNumber = 0L;
        for(int i = 0; i < 32; i ++) {
            if(bits[i] != 0) {
                reverseNumber += Math.pow(2, i);
            }
        }
        return String.valueOf(reverseNumber);
    }

    public static void main(String[] args) {
        System.out.println(solution("4626149"));
    }
}
