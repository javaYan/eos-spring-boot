package eos.java.practice.oj.xiaomi;

/**
 移除 K 位得到最小值
 描述

 有一行由正数组成的数字字符串，移除其中的 K 个数，使剩下的数字是所有可能中最小的。

 假设：
 * 字符串的长度一定大于等于 K
 * 字符串不会以 0 开头
 输入

 一行由正整数组成的数字字符串，和一个正整数 K，两个数据由英文逗号隔开，如：1432219,3。
 输出

 移除 K 位后可能的最小的数字字符串。
 如 1432219 移除 4, 3, 2 这 3 个数字后得到 1219，为所有可能中的最小值。
 输入样例

 1432219,3

 10200,1
 输出样例

 1219

 200
 */
public class oj009 {
    private static String solution(String line) {
        // TODO
        int length = line.length();

        return null;
    }

    public static void main(String[] args) {
        System.out.println(solution("abc,badc"));
    }
}
