package eos.java.practice.oj.xiaomi;

/**
 * 寻找归一数字
 描述

 有一类正整数我们叫做归一数字，对于任意一个归一数字 N，满足以下特性：

 N 的每一位的平方和组成一个数，新数字的平方和再组成一个新数字，如此往复运算，直到最终结果为 1。

 若一个数字能最终归一成 1，则该数字为归一数字，否则不是归一数字。

 举例：
 82可以分解为8^2 + 2^2 = 68，68继续分解为6^2 + 8^2 = 100，100可以分解为1^2 + 0^2 + 0^2 = 1。所以82可以归一。
 输入

 一个正整数 N（0 < N < 100000000）
 输出

 输出N 是否为归一数的判断结果，若是则返回 'true'，否则返回 'false'（均为字符串）。
 输入样例

 1

 82

 50
 输出样例

 true

 true

 false
 */
public class oj043 {
    private static String solution(String line) {
        char [] numbers = line.toCharArray();
        while(true) {
            int sum = 0;
            for(int i=0, length = numbers.length; i < length; i ++) {
                sum += Math.pow(numbers[i]-48,2);
            }
            if(sum == 1) {
                return "true";
            } else if(sum < 10) {
                return "false";
            }
            numbers = String.valueOf(sum).toCharArray();
        }
    }

    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
        System.out.println(solution("25683245"));
        System.out.println((System.currentTimeMillis()-startTime) + " ms");
    }
}
