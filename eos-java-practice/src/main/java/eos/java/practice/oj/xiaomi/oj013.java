package eos.java.practice.oj.xiaomi;

/**
 出现频率最高的前 K 个元素
 描述

 有一个不为空且仅包含正整数的数组，找出其中出现频率最高的前 K 个数，时间复杂度必须在 O(n log n) 以内。
 输入

 一行数据包括两部分，一个正整数数组（数字间 ',' 分隔）和一个正整数 K （1 ≤ K ≤ 数组长度），数组和 K 之间有一个空格。
 输出

 输出包含前 K 个出现频率最高的数，用 ', ' 分隔，保证升序排列。
 输入样例

 1,1,1,2,2,3 2
 输出样例

 1,2
 */
public class oj013 {
    private static String solution(String line) {
        class MyNumber {
            public int number;
            public int count;
        }
        String[] lines = line.split(" ");
        String str1 = lines[0];
        String[] strings = str1.split(",");
        int length = strings.length;
        int K = Integer.parseInt(lines[1]);
        int [] numbers = new int [length];
        MyNumber [] tempNumbers = new MyNumber[length];
        for(int i = 0; i < length; i ++) {
            numbers[i] = Integer.parseInt(strings[i]);
            tempNumbers[i] = 0;
        }

        java.util.Arrays.sort(numbers);

        for(int i = 0; i < length; ) {
            int currentIndex = i;
            tempNumbers[i] = 1;
            while((++i < length) && numbers[currentIndex] == numbers[i]) {
                tempNumbers[currentIndex] ++;
            }
        }

        for(int i = 0; i < length; i ++) {
            if(tempNumbers[i] != 0)
                System.out.println(numbers[i] + "出现过" + tempNumbers[i] + "次");
        }

        if(K == length) {

        }
        return null;
    }

    public static void main(String[] args) {
        System.out.println(solution("1,1,1,2,2,3 2"));
    }
}
