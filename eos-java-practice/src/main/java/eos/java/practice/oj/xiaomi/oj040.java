package eos.java.practice.oj.xiaomi;

/**
 找小“3”
 序号：#40 难度：困难  时间限制：1000ms  内存限制：10M
 描述

 给定一个奇数n，可得到一个由从1到n的所有奇数所组成的数列，求这一数列中数字3所出现的总次数。例如当n=3时，可得到奇数列：1,3，其中有一个数字3，故可得1
 输入

 一个奇数。表示n。
 输出

 一个整数，表示从1到n的奇数列中，数字3出现的次数。
 输入样例

 1

 3

 35
 输出样例

 0

 1

 7
 *
 */
public class oj040 {
    private static String solution(String line) {
        //TODO 时间限制1秒 需要优化
        long endNumber = Long.parseLong(line);
        long count = 0;
        for(int i = 3; i <= endNumber; i+=2) {
            int temp = i;
            while(temp > 0) {
                if(temp % 10 == 3) {
                    count ++;
                }
                temp = temp / 10;
            }
        }
        return String.valueOf(count);
    }

    public static void main(String[] args) {
        System.out.println(solution("30"));
    }
}
