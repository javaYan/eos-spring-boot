package eos.java.practice.oj.xiaomi;

/**
 四则运算
 描述

 实现一个算法，可以进行任意非负整数的加减乘除组合四则运算。
 请注意运算符的优先级。
 输入

 请输入一行算式，使用空格分隔数字与运算符。
 数字为任意非负整数，运算符为+ - * /，不考虑括号。
 输出

 输出算式的运算结果。如果是小数，请向下取整（包含中间步骤结果）。
 如果出现“除0异常”，输出err。
 输入样例

 3 + 5

 12 + 45 / 9

 1 / 2

 1 / 0

 12 + 34 * 56 - 78
 输出样例

 8

 17

 0

 err

 1838
 */
public class oj016 {
    private static String solution(String line) {
        String[] arithmetics = line.split(" ");
        String[] tempArithmetics = {};
        final String _plus = "+";
        final String _sub = "-";
        final String _multi = "*";
        final String _div = "/";
        boolean multi_div_flag = true;
        while(multi_div_flag) {
            int length = arithmetics.length;
            if(length == 1) {
                break;
            }
            for(int i=1; i<length;i=i+2) {
                if(_div.equals(arithmetics[i]) || _multi.equals(arithmetics[i])) {
                    int tempResult = 0;
                    if(_div.equals(arithmetics[i])) {
                        if(arithmetics[i+1].equals("0")) {
                            return "err";
                        }
                        tempResult = Integer.parseInt(arithmetics[i-1])/Integer.parseInt(arithmetics[i+1]);
                    } else {
                        tempResult = Integer.parseInt(arithmetics[i-1])*Integer.parseInt(arithmetics[i+1]);
                    }

                    //复制
                    tempArithmetics = new String[length-2];
                    for(int j = 0; j < length-2; j ++) {
                        if(j < i - 1) {
                            tempArithmetics[j] = arithmetics[j];
                        } else if(j > i-1){
                            tempArithmetics[j] = arithmetics[j+2];
                        } else {
                            tempArithmetics[j] = String.valueOf(tempResult);
                        }
                    }
                    arithmetics = tempArithmetics;
                    break;
                }
                if(i == length-2) {
                    multi_div_flag = false;
                }
            }
        }
        int finalResult = Integer.parseInt(arithmetics[0]);
        for(int i = 1; i < arithmetics.length; i=i+2) {
            if(_plus.equals(arithmetics[i])) {
                finalResult += Integer.parseInt(arithmetics[i+1]);
            } else {
                finalResult -= Integer.parseInt(arithmetics[i+1]);
            }
        }
        return String.valueOf(finalResult);
    }

    public static void main(String[] args) {
        System.out.println(solution("455 - 144 / 18 + 156"));
    }
}
