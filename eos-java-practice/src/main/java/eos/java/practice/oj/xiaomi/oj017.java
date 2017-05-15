package eos.java.practice.oj.xiaomi;

/**
 小写数字转大写数字
 描述

 实现一个算法，可以将小写数字转换成大写数字。
 输入

 输入一个整数。范围在0～450亿之间。
 输出

 输出对应的大写数字，以“元整”结尾。
 大写数字要符合汉语读写习惯。
 输入样例

 0

 5

 233

 1001

 40607

 8900000000
 输出样例

 零元整

 伍元整

 贰佰叁拾叁元整

 壹仟零壹元整

 肆万零陆佰零柒元整

 捌拾玖亿元整
 */
public class oj017 {
    private static String solution(String line) {
        final String[] SUFFIX_1 = {"","拾","佰","仟","万","拾","佰","仟","亿","拾","佰"};
        int SUFFIX1_LENGTH = SUFFIX_1.length;
        final String[] COMPLEX_FONT = {"","壹","贰","叁","肆","伍","陆","柒","捌","玖"};
        char[] strs = line.toCharArray();
        int length = strs.length;
        StringBuffer buffer = new StringBuffer();
        for(int i = 0; i < length; i ++) {
            String suffix = SUFFIX_1[length-i-1];
            if(strs[i] != 48) {
                buffer.append(COMPLEX_FONT[strs[i]-48]).append(suffix);
            } else {
                if((suffix.equals("万") || suffix.equals("亿"))) { //如果后缀恰巧是"亿"或是"万"的修饰
                    for(int m = 3; m > 0; m --) {
                        if(i-m >=0 && strs[i-m]!= 48) {
                            buffer.append(suffix);
                            break;
                        }
                    }
                    continue;
                }
                if(length == 1 || (i != length-1 && strs[i+1] != 48)) { //只有一位且是0 或者 非最后一位且此位后一位不为0
                    buffer.append("零");
                    continue;
                }
            }
        }
        buffer.append("元整");
        return buffer.toString();
    }

    public static void main(String[] args) {
        System.out.println(solution("38004109937"));
    }
}
//叁佰捌拾肆亿玖仟柒佰叁拾万玖仟玖佰叁拾柒元整
//叁佰捌拾肆亿玖仟柒佰叁拾万玖仟玖佰叁拾柒元整
//叁佰捌拾肆亿玖仟柒佰叁拾万玖仟玖佰叁拾柒元整