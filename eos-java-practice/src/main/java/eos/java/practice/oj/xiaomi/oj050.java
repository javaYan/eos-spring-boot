package eos.java.practice.oj.xiaomi;

/*

找出面积最大的矩形
序号：#50 难度：有挑战  时间限制：1000ms  内存限制：10M
描述

在一个平面图上，有多个宽度固定为1，高度不同的矩形并列排着，在这些矩形所组成的图形中，能够切割出的最大矩形的面积是多少？
数据范围：0 < 高度 < 100

举例：高度为2,3,2的三个矩形所组成的图形，能够切割出的最大的矩形面积为6。见下图。

图片位于/resources/oj/50.png
输入

一组正整数，分别用逗号隔开，表示每个矩形的高度
输出

一个整数，表示组合成的最大的矩形面积
输入样例

2,3,2

5,6,7,8,3
输出样例

6

20
 */
public class oj050 {
    private static String solution(String line) {
        String [] strings = line.split(",");
        int length = strings.length;
        int[] numbers = new int[length];
        for(int i = 0; i < length; i ++) {
            numbers[i] = Integer.parseInt(strings[i]);
        }

        int maxArea = 0;
        int tempArea = 0;
        int tempLength = 1;

        for(int i = 0; i < length; i ++) {
            tempArea = 0;
            tempLength = 1;
            for(int j = i+1; j < length; j ++) {
                if(numbers[i] <= numbers[j]) {
                    tempLength ++;
                    if(j == length-1) {
                        tempArea = numbers[i] * tempLength;
                        maxArea = Math.max(maxArea, tempArea);
                    }
                } else {
                    tempArea = numbers[i] * tempLength;
                    maxArea = Math.max(maxArea, tempArea);
                    break;
                }
            }
        }

        return String.valueOf(maxArea);
    }

    public static void main(String[] args) {
        System.out.println(solution("2,4,5,4,2"));
    }
}
