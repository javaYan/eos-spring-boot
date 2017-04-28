package eos.java.practice.oj.xiaomi;

/**
 寻找最大主对角线的和
 序号：#39 难度：一般  时间限制：1000ms  内存限制：10M
 描述

 任意给一个m*n矩阵(m>=2, n>=2)，元素均为非负数，请找出其中主对角线和最大的二阶子矩阵，求出主对角线和。（主对角线：一个n维矩阵的主对角线为所有第k行第k列元素的全体，k=1, 2, 3… n，即从左上到右下的一条斜线）

 举例：
 有一个3*5的矩阵如下：
 3 3 1 3 4
 5 5 7 10 1
 2 9 5 3 3
 其中，主对角线和最大的二阶子矩阵是:
 5 5
 2 9
 可得出其主对角线和为14
 输入

 输入一行m*n个正整数，每m个数用分号;分隔，表示矩阵行，每行内元素间用逗号,分隔。
 例如：3,3,1,3,4;5,5,7,10,1;2,9,5,3,3，表示矩阵：
 3 3 1 3 4
 5 5 7 10 1
 2 9 5 3 3
 输出

 一个整数，表示最大的主对角线和
 输入样例

 3,3,1,3,4;5,5,7,10,1;2,9,5,3,3
 输出样例

 14
 *
 */
public class oj039 {
    private static String solution(String line) {

        return null;
    }

    public static void main(String[] args) {
        System.out.println(solution("abc,badc"));
    }
}