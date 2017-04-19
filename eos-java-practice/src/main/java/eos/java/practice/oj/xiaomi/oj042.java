package eos.java.practice.oj.xiaomi;

/**
 * Title: 字符串替换
 * Author: yanyuyu
 * Date: 2017-04-11 18:58
 *  描述
 *  给出两个字符串S1、S2，对S1进行插入、删除、替换的操作，每次只能操作一个字符，最少操作多少步，使其等于S2。
 *  输入
 *  两个字符串S1、S2，以逗号（,）分开，操作S1使其等于S2
 *  输出
 *  一个整数，表示最少操作步数
 *  输入样例
 *  abc,badc
 *  abedc,ace
 *  输出样例
 *  2
 *  3
 */
public class oj042 {
    private static String solution(String line) {
        String [] strings = line.split(",");
        String s1 = strings[0];
        String s2 = strings[1];

        //优先插入或删除使位数一致
        return "";
    }

    public static void main(String[] args) {
        System.out.println(solution("abc,badc"));
    }
}
