package eos.java.practice.oj.xiaomi;

/**
 第一个缺失正数
 描述

 给出一个无序的数列，找出其中缺失的第一个正数，要求复杂度为 O(n)
 如：[1,2,0]，第一个缺失为3。
 如：[3,4,-1,1]，第一个缺失为2。
 输入

 1,2,0
 输出

 3
 输入样例

 1,2,0

 3,4,-1,1

 -1,-3,-5

 1,2,3

 -1,-10,0
 输出样例

 3

 2

 1

 4

 1
 */
public class oj007 {
    private static String solution(String line) {
        String[] strs = line.split(",");
        int length = strs.length;
        int [] numbers = new int[length];
        for(int i = 0; i < length; i ++) {
            numbers[i] = Integer.parseInt(strs[i]);
        }
        java.util.Arrays.sort(numbers);
        if(numbers[0] > 0 && numbers[0] != 1)  {
            return "1";
        }
        for(int i = 1; i < length; i ++) {
            if(numbers[i] > 0) {
                if(numbers[i-1]<=0) {
                    if(numbers[i] != 1) {
                        return "1";
                    }
                    continue;
                } else {
                    if(numbers[i-1] != numbers[i]-1) {
                        return String.valueOf(numbers[i-1]+1);
                    }
                    continue;
                }
            }
        }
        int result = numbers[length-1]+1 != 0 ? numbers[length-1]+1 : 1;
        return String.valueOf(result);
    }

    public static void main(String[] args) {
        System.out.println(solution("-1,-3,-5"));
    }
}
