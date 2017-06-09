package eos.java.practice.oj.xiaomi;

/**
 有多少个等差数列？
 描述

 等差数列是常见数列的一种，如果一个数列从第二项起，每一项与它的前一项的差等于同一个常数，这个数列就叫做等差数列，而这个常数叫做等差数列的公差，公差常用字母d表示。即对于数列S，它满足了(S[i]-S[i-1]) = d (i>1)。
 显然，一个数字无法构成等差数列，而任意两个数字可以形成一个等差数列。
 这里给出了一个长度为N的数字序列，每个位置有一个整数，需要找到这个数字序列里包含多少个等差数列，序列顺序固定，无需排序。
 输入数据格式：S[0] S[1] S[2] …S[N]（以半角空格符分隔，N > 1）
 输出数据格式：等差数列数量M；
 其中数列S的项为整数

 请注意时间复杂度的限制。
 输入

 输入一个数列[ 2 7 4 5 6 ]，该数列包含等差数列：
 [ 2 7 ]
 [ 2 4 ]
 [ 2 5 ]
 [ 2 6 ]
 [ 7 4 ]
 [ 7 5 ]
 [ 7 6 ]
 [ 4 5 ]
 [ 4 6 ]
 [ 5 6 ]
 [ 2 4 6 ]
 [ 4 5 6 ]
 输出

 上例共包含12组等差数列，故应输出12
 输入样例

 2 7 4 5 6

 3 3 3 3
 输出样例

 12

 11
 */
public class oj020 {
    private static String solution(String line) {
        //TODO
        String[] strs = line.split(" ");
        int length = strs.length;
        int[] numbers = new int[length];
        int count = 0;
        int currentLength = 3;
        if(length >= 3) {
            count = (length-1)*length/2;
        }
        while(currentLength <= length) {
            for(int i = 0 ; i < length; i ++) {

            }
        }
        
        return null;
    }

    public static void main(String[] args) {
        System.out.println(solution("2 7 4 5 6"));
    }
}
