package eos.java.practice.oj.xiaomi;

/**
 * 找数字对
 描述

 有一串可能含重复数字的列表，例如 N = {4,13,5,6,35,85,3}，对于任意 A ∈ N，B ∈ N, 使  A+B = 10 或 |A-B| = 10；
 即两数之合为 10 或两数之差的绝对值为 10。

 找出所有满足条件的数字对 {A,B} 的个数。(A, B的顺序与原始数组保持一致)
 输入

 一行文本由英文逗号分隔，如 6,4,16
 输出

 2
 输入样例

 4,13,5,6,35,85,3

 13,3,6,8,12,4,45,56,66,16

 6,4,16
 输出样例

 2

 4

 2
 */
public class oj048 {
    private static String solution(String line) {
        // 在此处理单行数据
        int count = 0;
        String[] strArray = line.split(",");
        int length = strArray.length;
        int  []  intArray = new int[length];
        for(int i = length-1; i >=0; i --) {
            intArray[i] = Integer.parseInt(strArray[i]);
        }
        for(int i = length-1; i >= 0; i --) {
            for(int j = i-1; j >= 0; j --) {
                if(intArray[i] + intArray[j] == 10 || Math.abs(intArray[i]-intArray[j]) == 10)  {
                    count ++;
                }
            }
        }
        return String.valueOf(count);
    }

    public static void main(String[] args) {
        System.out.println(solution("6,4,16"));
    }
}
