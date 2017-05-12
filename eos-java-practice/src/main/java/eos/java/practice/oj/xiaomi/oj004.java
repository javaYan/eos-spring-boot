package eos.java.practice.oj.xiaomi;

/**
 最长连续数列
 描述

 输入一个乱序的连续数列，输出其中最长连续数列长度，要求算法复杂度为  O(n)  。
 输入

 54,55,300,12,56
 输出

 3
 输入样例

 100,4,200,1,3,2

 54,55,300,12

 1

 5,4,3,2,1

 1,2,3,4,5,6
 输出样例

 4

 2

 1

 5

 6
 */
public class oj004 {
    private static String solution(String line) {
        //题目求什么：求一组数列中 有没有多个连续的数字，此处的连续不是指递增或递减
        //题目核心：排序 按照大小排序 即可见答案
        //题目要求：o(n) 则要求排序算法o(n)
        String[] numbers = line.split(",");
        int length = numbers.length;
        int [] intArray = new int[length];
        for(int i = 0; i < length; i ++) {
            intArray[i] = Integer.parseInt(numbers[i]);
        }
        java.util.Arrays.sort(intArray);
        int maxCount = 1;
        int tempCount = 1;
        for(int i = 0; i < length-1; i ++) {
            if(intArray[i+1] == intArray[i]+1) {
                tempCount ++;
            } else {
                maxCount = tempCount > maxCount ? tempCount : maxCount;
            }
        }
        maxCount = tempCount > maxCount ? tempCount : maxCount;
        return String.valueOf(maxCount);
    }

    public static void main(String[] args) {
        System.out.println(solution("1,2,3,4,5,6"));
    }
}
