package eos.java.practice.oj.xiaomi;

/**
 最少交换次数
 描述

 给出一个无序数列，每次只能交换相邻两个元素，求将原数列变成递增数列的最少交换次数。
 如：数列：2,3,1，交换3和1后变成：2,1,3；交换1和2之后变成：1,2,3。总共交换2次。
 输入

 逗号隔开的正整数数列
 输出

 正整数
 输入样例

 2,3,1
 输出样例

 2
 */
public class oj008 {
    private static String solution(String line) {
        //每次找最大的数 移动到末位
        String[] strs = line.split(",");
        int length = strs.length;
        int [] numbers = new int[length];
        int [] sortedNumbers = new int[length];
        for(int i = 0; i < length; i++) {
            numbers[i] = sortedNumbers[i] = Integer.parseInt(strs[i]);
        }

        java.util.Arrays.sort(sortedNumbers);

        int totalSwapCount = 0;
        int temp;
        for(int sortedIndex = length-1; sortedIndex >= 0; sortedIndex --) {
            for(int index = 0; index < length; index ++) {
                if(sortedNumbers[sortedIndex] == numbers[index]) { //找到最大的数在原数组中的位置
                    for(int startIndex = index; startIndex < sortedIndex; startIndex ++) {
                        temp = numbers[startIndex+1];
                        numbers[startIndex+1] = numbers[startIndex];
                        numbers[startIndex] = temp;
                        totalSwapCount ++;
                    }
                    break;
                }
            }
        }

        return String.valueOf(totalSwapCount);
    }

    public static void main(String[] args) {
        System.out.println(solution("64,7,2,3,1"));
    }
}
