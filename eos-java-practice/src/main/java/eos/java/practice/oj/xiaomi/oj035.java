package eos.java.practice.oj.xiaomi;

/**
 分糖果
 描述

 将 M 个同样的糖果放在 N 个同样的篮子里，允许有的篮子空着不放，共有多少种不同的分法？
 比如，把 7 个糖果放在 3 个篮子里，共有 8 种分法（每个数表示篮子中放的糖果数，数的个数为篮子数）：
 1 1 5
 1 2 4
 1 3 3
 2 2 3
 2 5 0
 3 4 0
 6 1 0
 7 0 0

 注意：相同的分布，顺序不同也只算作一种分法，如 7 0 0、0 7 0 和 0 0 7 只算作一种。
 输入

 输入包含二个正整数 M 和 N，以(,)分开，M 表示有几个同样的糖果，N 表示有几个同样的篮子
 M与N范围：1 <= M，N <= 100。
 输出

 输出一个正整数 K，表示有多少种分法。
 输入样例

 7,3
 输出样例

 8
 */
public class oj035 {
    private static String solution(String line) {
        // TODO
        return null;
    }

    public static void main(String[] args) {
        System.out.println(solution("abc,badc"));
    }
}
