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
        //先按number大小进行排序
        //计算出number对应的count数
        class MyNumber {
            public int number; //存储的数
            public int count;  //出现的次数
            public MyNumber(int number, int count) {
                this.number = number;
                this.count = count;
            }
        }
        String[] lines = line.split(" ");
        String str1 = lines[0];
        String[] strings = str1.split(",");
        int length = strings.length;
        int K = Integer.parseInt(lines[1]);
        MyNumber [] myNumbers = new MyNumber[length];
        for(int i = 0; i < length; i ++) {
            MyNumber myNumber = new MyNumber(Integer.parseInt(strings[i]), 1);
            myNumbers[i] = myNumber;
        }

        java.util.Collections.sort(java.util.Arrays.asList(myNumbers), new java.util.Comparator<MyNumber>() {
            @Override
            public int compare(MyNumber o1, MyNumber o2) {
                if(o1.number > o2.number) {
                    return 1;
                } else if(o1.number == o2.number){
                    return 0;
                } else {
                    return -1;
                }
            }
        });

        for(int i = 0; i < length; ) {
            int currentIndex = i;
            while((++i < length) && myNumbers[currentIndex].number == myNumbers[i].number) {
                myNumbers[currentIndex].count++;
                myNumbers[i] = null;
            }
        }

        StringBuffer sb = new StringBuffer();
        for(int i = 0; i < length && K > 0; i++) {
            if( myNumbers[i]!= null) {
                sb.append(myNumbers[i].number).append(",");
                K --;
            }
        }
        String result = sb.toString();
        return result.substring(0,result.length()-1);
    }

    public static void main(String[] args) {
        System.out.println(solution("1 1"));
    }
}
