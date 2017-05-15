package eos.java.practice.oj.xiaomi;

/**
 在一个有序的经过旋转的数组里查找一个数
 描述

 假设一个有序的数组，经过未知次数的旋转（例如0 1 2 4 5 6 7 被旋转成 4 5 6 7 0 1 2），从中查找一个目标值，如果存在，返回其下标，不存在，返回-1。注：假设数组无重复数字
 输入

 输入一个有序经过旋转的数组和要查找的目标数字，数组中各数字用“逗号”分隔，数组和目标数字用“空格”分隔
 输出

 一个整数，表示该目标数字的下标（不存在返回-1）
 输入样例

 4,5,6,7,0,1,2 6
 输出样例

 2
 */
public class oj014 {
    private static String solution(String line) {
        String[] strs = line.split(" ");
        String[] strNumbers = strs[0].split(",");
        String aimNumber = strs[1];
        int length = strNumbers.length;
        for(int i =0; i < length; i ++) {
            if(aimNumber.equals(strNumbers[i])) {
                return String.valueOf(i);
            }
        }
        return "-1";
    }

    public static void main(String[] args) {
        System.out.println(solution("4,5,6,7,0,1,2 6"));
    }
}
