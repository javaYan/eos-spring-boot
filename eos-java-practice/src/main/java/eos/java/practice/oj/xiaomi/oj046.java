package eos.java.practice.oj.xiaomi;


/**
 * 数组差
 描述

 给定一个整数数组，找出两个不重叠的子数组A和B，使两个子数组元素和的差的绝对值 |SUM(A) - SUM(B)| 最大。 返回这个最大的差值。
 例如：
 有一个数组{1, 2, -3, 1}，可以从中找出两个子数组A = {1, 2}与B = {-3}，这两个子数组的元素和分别为 SUM(A) = 3，SUM(B) = -3，因此可以求得差的最大值 |SUM(A) - SUM(B)| = 6。
 输入

 使用逗号(,)分隔的一个整数数组
 输出

 一个整数，表示两个子数组元素和的差的最大值
 输入样例

 1,2,-3,1
 输出样例

 6
 */
public class oj046 {
    private static String solution(String line) {
        String[] strs = line.split(",");
        int length = strs.length;
        int [] numbers = new int[length];
        for(int currentIndex = 0; currentIndex < length; currentIndex++) {
            int insertNumber = Integer.parseInt(strs[currentIndex]);
            boolean exist = false;
            for(int index = 0; index < currentIndex; index ++) {
                if(numbers[index] == insertNumber) {
                    numbers[currentIndex] = 0;
                    exist = true;
                    break;
                }
            }
            if(!exist) {
                numbers[currentIndex] = insertNumber;
            }
        }
        
        long sum = 0;
        for(int i = 0; i < length; i ++) {
            if(numbers[i] < 0) {
                sum -= numbers[i];
            } else {
                sum += numbers[i];
            }
        }
        return String.valueOf(sum);
    }

    public static void main(String[] args) {
        System.out.println(solution("1,2,-3,1"));
    }
}
