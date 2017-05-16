package eos.java.practice.oj.xiaomi;

/**
 重排数组求最大和
 描述

 假设有一个n元素的数组（数组的元素索引从1开始），针对这个数组有q个查询请求，每个请求由一对整数li，ri组成，表示数组上一个合法索引区间（1≤li≤ri≤n）。我们可以根据查询的索引来计算出范围内的所有数组元素的一个总和，计算时也需要包含li和ri位置的元素。
 通过重新排序数组元素，可以使得这些查询的总和最大。求问我们可以计算的最大总和值是多少。

 举例：
 有一个数列：2 0 1 0 3 4 5 6，针对这个数列，我们有两组查询：5 7与3 5。将数组重排成0 0 2 3 6 4 5 1，然后取第5~7与3~5位置的全部元素和，可得到最大的总和为(6+4+5) + (2+3+6) = 26
 输入

 使用分号(";")分隔数据。
 第1组为一个整数n（1≤n≤200000），表示数组中的元素数量。
 第2组为一个整数q（1≤q≤200000），表示查询数量。
 第3组为一个数组，包含n个整数ai（0≤ai≤200000）数组元素 ，元素之间使用空格分隔。
 第4～(4+q)组，为q组查询，每一组包含两个空格分隔的整数li和ri（1≤li≤ri≤n）。
 输出

 整数，表示数组元素重新排序后，全部查询得到的最大总和。
 输入样例

 8;2;2 0 1 0 3 4 5 6;5 7;3 5

 11;1;10 11 10 6 1 7 11 11 5 2 6;3 3

 3;2;4 2 1;1 1;2 2
 输出样例

 26

 11

 6
 */
public class oj034 {
    private static String solution(String line) {
        // TODO
        return null;
    }

    public static void main(String[] args) {
        System.out.println(solution("abc,badc"));
    }
}
