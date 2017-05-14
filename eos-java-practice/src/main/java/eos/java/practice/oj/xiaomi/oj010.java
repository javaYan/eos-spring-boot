package eos.java.practice.oj.xiaomi;

/**
 爬楼梯
 描述

 在你面前有一个n阶的楼梯，你一步只能上1阶或2阶。
 请问计算出你可以采用多少种不同的方式爬完这个楼梯。
 输入

 一个正整数，表示这个楼梯一共有多少阶
 输出

 一个正整数，表示有多少种不同的方式爬完这个楼梯
 输入样例

 5

 10
 输出样例

 8

 89
 */
public class oj010 {
    private static String solution(String line) {
        // 此题就是计算
        // 若n为偶数 则总共有n/2 ~ n步的可能，每一步都只对应一种方案，但是会有不同的排列
        // 若n为奇数 则总共有n/2+1 ~ n步的可能，每一步都只对应一种方案，但是会有不同的排列
        // 如n=10 则有5、6、7、8、9、10步的可能性
        // 其中5步和10步只有一种可能，6步=2+2+2+2+1+1 这些数排列组合
        // 如n=9  则有5、6、7、8、9步的可能性
        // 其中9步只有一种可能，其余的每步的排列组合
        // 由此可见是区分奇偶数的
        return null;
    }

    public static void main(String[] args) {
        System.out.println(solution("abc,badc"));
    }
}
