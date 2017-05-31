package eos.java.practice.oj.xiaomi;

/**
 * 需要多少个立方数
 描述

 给出一个数字 N（0<N<1000000），将 N 写成立方数和的形式，求出需要的最少的立方数个数。

 举例：
 假设 N=17，可得 1+8+8 = 17，最少需要 3 个立方数，则输出 3
 假设 N= 28，可得 1+1+1+1+8+8+8 = 28，需要 7 个立方数，又得 1+27=28，需要 2 个立方数，所以最少立方数为 2，则输出 2
 输入

 一个正整数 N（0<N<1000000）
 输出

 需要的最少的立方数个数（整型）
 输入样例

 1

 17

 28
 输出样例

 1

 3

 2
 */
public class oj044 {
    private static String solution(String line) {
        int count = 0;
        int sum = Integer.parseInt(line);
        while(true) {
            for(int i = sum; i >= 1; i --) {
                int sqrt = (int)Math.pow(i, 1.0/3);
                if(sqrt*sqrt*sqrt == i) { //找到最大的立方数
                    int size = sum / i;
                    sum = sum - i * size;
                    count = count + size;
                    if(sum == 0) {
                        return String.valueOf(count);
                    }
                    break;
                }
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(solution("1"));
    }
}
