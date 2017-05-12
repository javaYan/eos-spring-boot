package eos.java.practice.oj.xiaomi;

/**
 构建短字符串
 描述

 给定任意一个较短的子串，和另一个较长的字符串，判断短的字符串是否能够由长字符串中的字符构建出来，且长串中的每个字符只能用一次。
 输入

 一行数据包括一个较短的字符串和一个较长的字符串，用一个空格分隔，如：
 ab aab
 bb abc
 aa cccc
 输出

 如果短的字符串可以由长字符串中的字符构建出来，返回字符串 “true”，否则返回字符串 "false"，注意返回字符串类型而不是布尔型。
 输入样例

 a b

 aa ab

 aa aab
 输出样例

 false

 false

 true
 */
public class oj011 {
    private static String solution(String line) {
        String [] strs = line.split(" ");
        String shortstr = strs[0];
        String longstr  = strs[1];
        for(int i =0; i < shortstr.length(); i ++) {
            int index = longstr.indexOf(shortstr.charAt(i));
            if(index >= 0) {
                longstr = longstr.substring(0,index) + longstr.substring(index+1, longstr.length());
            } else {
                return "false";
            }
        }
        return "true";
    }

    public static void main(String[] args) {
        System.out.println(solution("aa ab"));
    }
}
