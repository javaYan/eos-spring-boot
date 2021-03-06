package eos.java.practice.oj.xiaomi;

/**
 大数的加法运算与大小判断
 描述

 对于给定的算术表达式，按规则输出计算结果，仅包含加法和大小判断。
 输入

 一行字符串，为加号、大于、小于( + < > ) 连接的两个不限大小的非负整数。
 输出

 当符号为 + 时, 计算两个数相加的和, 并以字符串格式返回；
 当符号为 < 时, 如果左数小于右数, 返回大写字母字符 Y, 否则返回大写字母字符 N；
 当符号为 > 时, 如果左数大于右数, 返回大写字母字符 Y, 否则返回大写字母字符 N。

 !!!请同学们尽量使用算法来解决这个问题
 输入样例

 972919822976663297>74058

 875098336507333719633571722631534917759993913379786689>53558270653237768027942884431075534537929401567824882097903948774409200

 7625022925148127196027859399571498914361+790786706794530
 输出样例

 Y

 N

 7625022925148127196027860190358205708891
 */
public class oj019 {
    private static String solution(String line) {
        String str1 = null;
        String str2 = null;
        String flag = null;
        int flagIndex = 0;
        if((flagIndex = line.indexOf(">")) != -1) {
            flag = ">";
        } else if((flagIndex = line.indexOf("<")) != -1) {
            flag = "<";
        } else {
            flagIndex = line.indexOf("+");
            flag = "+";
        }
        str1 = line.substring(0,flagIndex);
        str2 = line.substring(flagIndex+1);

        char[] chars1 = str1.toCharArray();
        char[] chars2 = str2.toCharArray();
        if(flag.equals(">") || flag.equals("<")) {
            //两字串位数不同
            if(chars1.length != chars2.length) {
                if(flag.equals(">")) {
                    return chars1.length > chars2.length ? "Y" : "N";
                } else {
                    return chars1.length < chars2.length ? "Y" : "N";
                }
            }
            //位数相同，逐位比较
            int length = chars1.length;
            if(flag.equals(">")) {
                for(int i = 0; i < length; i++) {
                    if(chars1[i] > chars2[i]) {
                        return "Y";
                    } else if(chars1[i] < chars2[i]){
                        return "N";
                    }
                }
                return "N";

            } else {
                for(int i = 0; i < length; i++) {
                    if(chars1[i] < chars2[i]) {
                        return "Y";
                    } else if(chars1[i] > chars2[i]){
                        return "N";
                    }
                }
                return "N";
            }
        } else { //大数加法
            int length1 = chars1.length;
            int length2 = chars2.length;
            StringBuffer buffer = new StringBuffer();
            int leftValue = 0;
            if(length1 >= length2) {
                int diff = length1 - length2;
                for(int i = length2-1; i >= 0; i --) {
                    int result = chars1[i+diff] + chars2[i] - 96 + leftValue;
                    leftValue = 0; //初始化进位值
                    if(result > 9) {
                        buffer.append(result%10);
                        leftValue ++;
                    } else {
                        buffer.append(result);
                    }
                }
                for(int i = diff-1; i >= 0; i --) {
                    if(leftValue > 0) {
                        int result = chars1[i] - 48 + leftValue;
                        leftValue = 0;
                        if(result > 9) {
                            buffer.append(result%10);
                            leftValue ++;
                        } else {
                            buffer.append(result);
                        }
                    } else {
                        buffer.append(chars1[i] - 48);
                    }
                }
                if(leftValue > 0) {
                    buffer.append("1");
                }
            } else {
                int diff = length2 - length1;
                for(int i = length1-1; i >= 0; i --) {
                    int result = chars2[i+diff] + chars1[i] - 96 + leftValue;
                    leftValue = 0; //初始化进位值
                    if(result > 9) {
                        buffer.append(result%10);
                        leftValue ++;
                    } else {
                        buffer.append(result);
                    }
                }
                for(int i = diff-1; i >= 0; i --) {
                    if(leftValue > 0) {
                        int result = chars2[i] - 48 + leftValue;
                        leftValue = 0;
                        if(result > 9) {
                            buffer.append(result%10);
                            leftValue ++;
                        } else {
                            buffer.append(result);
                        }
                    } else {
                        buffer.append(chars2[i] - 48);
                    }
                }
                if(leftValue > 0) {
                    buffer.append("1");
                }
            }
            return buffer.reverse().toString();
        }
    }

    public static void main(String[] args) {
        System.out.println(solution("91605925589308617120639+44791376625729389745455"));
    }

}
