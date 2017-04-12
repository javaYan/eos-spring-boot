package eos.java.practice.oj.xiaomi;

import java.util.HashSet;

/**
 * Title: oj001
 * Author: yanyuyu
 * Date: 2017-04-11 18:58
 *  描述
 *  给出N个数字。其中仅有一个数字出现过一次，其他数字均出现过两次，找出这个出现且只出现过一次的数字。要求时间和空间复杂度最小。
 *  输入
 *  输入多个数字，每个数字以空格分开，回车结束    10 10 11 12  12  11 16
 *  输出
 *  输出内容为只出现过唯一一次的数字             16
 */
public class oj002 {
    private static String solution(String line) {
        String [] strings = line.split(" ");
        int[] numbers = new int[strings.length];
        for(int i=strings.length-1; i>=0; i--) {
            numbers[i] = Integer.parseInt(strings[i]);
        }

        HashSet<Integer> set = new HashSet<Integer>();




        return String.valueOf(Integer.parseInt(strings[0]) + Integer.parseInt(strings[1]));
    }

    public static void main(String[] args) {
        System.out.println(solution("12 13"));
    }
}
