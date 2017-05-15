package eos.java.practice.oj.xiaomi;

import java.util.HashSet;

/**
 合为零的三元组
 描述

 给出一个正整数数组, 数组中是否存在任意 3 个数 a, b, c 满足 a + b + c = 0?
 找出数组中所有满足以上条件的三元组，最后输出这些三元组的个数（包含相同元素的三元组只计算一次）。
 输入

 一个包含多个正整数的字符串，每个正整数之间用逗号（,）分隔，如：-1,0,1,2,-1,-4。
 输出

 输入满足加合结果正好等于 0 的三元组的个数，如对于 -1,0,1,2,-1,-4 有 [-1, 0, 1] 和 [-1, -1, 2]，所以输出 2
 输入样例

 -1,0,1,2,-1,-4
 输出样例

 2
 */
public class oj015 {
    private static String solution(String line) {
        String[] strs = line.split(",");
        int length = strs.length;
        int[] numbers = new int[length];
        for(int i =0; i < length; i ++) {
            numbers[i] = Integer.parseInt(strs[i]);
        }

        //开始查数
        HashSet<String> set = new HashSet<String>();//符合条件的存放
        for(int i = 0; i < length; i ++) {
            for(int j = i+1; j < length; j ++) {
                for(int k = j+1; k < length; k ++) {
                    if(numbers[i]+numbers[j]+numbers[k] == 0) {
                        int max, middle, min;
                        max = Math.max(Math.max(numbers[i], numbers[j]), numbers[k]);
                        min = Math.min(Math.min(numbers[i], numbers[j]), numbers[k]);
                        middle = 0 - max - min;
                        set.add(max +","+ middle +"," + min);
                    }
                }
            }
        }
        return String.valueOf(set.size());
    }

    public static void main(String[] args) {
        System.out.println(solution("-1,0,1,2,-1,-4"));
    }
}
