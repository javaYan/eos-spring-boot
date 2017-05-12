package eos.java.practice.oj.xiaomi;

/**
 找出旋转有序数列的中间值
 *描述

 给出一个有序数列随机旋转之后的数列，如原有序数列为：[0,1,2,4,5,6,7] ，旋转之后为[4,5,6,7,0,1,2]。
 假定数列中无重复元素，且数列长度为奇数。
 求出旋转数列的中间值。如数列[4,5,6,7,0,1,2]的中间值为4。
 输入

 4,5,6,7,0,1,2
 输出

 4
 输入样例

 1

 1,2,3

 4,5,6,7,0,1,2

 12,13,14,5,6,7,8,9,10
 输出样例

 1

 2

 4

 9
 */
public class oj005 {
    private static String solution(String line) {
        //先排序 再求中间值 TODO排序可以优化 因为其实是两个有序数列的组合数列
        String[] strs = line.split(",");
        int length = strs.length;
        int[] numbers = new int[length];
        for(int i = 0; i < length; i ++) {
            numbers[i] = Integer.parseInt(strs[i]);
        }
        java.util.Arrays.sort(numbers);
        return String.valueOf(numbers[length/2]);
    }

    public static void main(String[] args) {
        System.out.println(solution("12,13,14,5,6,7,8,9,10"));
    }
}
