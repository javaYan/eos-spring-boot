package eos.java.practice.oj.xiaomi;

/**
 * Title: A+B
 * Author: yanyuyu
 * Date: 2017-04-11 18:58
 *  输入
 *  一行数据包含两个正整数， a 和 b，空格分开。(a 和 b 保证小于 2^32)
 *  输出
 *  你的输出是对一行数据处理的结果，也即 a+b 的结果。
 */
public class oj001 {
    private static String solution(String line) {
        String [] strings = line.split(" ");
        return String.valueOf(Integer.parseInt(strings[0]) + Integer.parseInt(strings[1]));
    }

    public static void main(String[] args) {
        System.out.println(solution("12 13"));
    }
}
