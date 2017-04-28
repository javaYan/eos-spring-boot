package eos.java.practice.oj.xiaomi;

/**
 按序组合成最大的数
 描述

 给定两个数组，由数字 0-9 组成的，长度分别为 a 和 b，需要用 a、b 两个数组中的数字组合得到长度为 k （k <= a+b）的正整数，输出所有可能的组合中数值最大的一个（原同一数组中的数字顺序不能改变）
 输入

 a、b 数组中的数字间用 , 隔开，两个数组以及 k 之间用空格隔开，如：1,3,4,5,1,2 8,9,1 5，其中 a = [1,3,4,5,1,2]，b = [8,9,1]，k = 5
 输出

 长度为 k 的所有组合中数值最大的整数，如：95121

 * 从 a 或 b 中取数的时候需保证 a，b 内部的顺序不变，如第一个数取到 b 中的 9，那么 b 中只有 1 可以后续取用；第二个数取到 a 中的 5，则 a 中还剩下 1,2 可以后续取用。
 输入样例

 6,3,8,9,4,6,0 3,5,7 6

 2,6,8,4,3 6,9,2,5 3

 3,7,2 7,9,5,1 7
 输出样例

 963570

 985

 7953721
 */
public class oj021 {
    private static String solution(String line) {

        return null;
    }

    public static void main(String[] args) {
        System.out.println(solution("abc,badc"));
    }
}