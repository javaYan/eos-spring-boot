package eos.java.practice.oj.xiaomi;

/**
 * Title: 大数相减
 * Author: yanyuyu
 * Date: 2017-04-11 18:58
 *  描述
 *  两个长度超出常规整形变量上限的大数相减
 *  输入
 *  有 N 行测试数据，每一行有两个代表整数的字符串 a 和 b，长度超过百位。规定 a>=b，a, b > 0。
 *  输出
 *  返回表示结果整数的字符串。
 *  输入样例
 *  1231231237812739878951331231231237812739878951331231231237812739878951331231231237812739878951331231231237812739878951331231231237812739870 - 89513312312312378127398789513312312312378127398789513312312312378127398789513
 *  1231231237812739878951331231231237812739878951331231231237812739878951331230000000000000000000000001 - 331231231237812739878951331231231
 *  输出样例
 *  1231231237812739878951331231231237812739878951331231231237812650365639018918853110413950365639018918853110413950365639018918853110413950357
 *  1231231237812739878951331231231237812739878951331231231237812739878620099998762187260121048668768770
 */
public class oj003 {
    private static String solution(String line) {
        line = line.replaceAll(" +","");//去除多余的空格
        String [] strings = line.split("-");
        int[] a = new int[strings[0].length()];
        int[] b = new int[strings[1].length()];
        for(int i = strings[0].length()-1; i >= 0; i --) {
            a[i] = Integer.parseInt(String.valueOf(strings[0].charAt(i)));
        }
        for(int i = strings[1].length()-1; i >= 0; i --) {
            b[i] = Integer.parseInt(String.valueOf(strings[1].charAt(i)));
        }
        int[] result = new int[a.length];
        int digitsDifference = a.length-b.length;
        for(int indexa=a.length-1; indexa>=0; indexa--) {
            int indexb = indexa - digitsDifference;
            if(indexb >= 0) {
                if(a[indexa] >= b[indexb]) {
                    result[indexa] = a[indexa] - b[indexb];
                } else {
                    int preIndexa = indexa-1;
                    while(a[preIndexa] == 0) { //向上借位
                        a[preIndexa] = 9;
                        preIndexa = preIndexa - 1;
                    }
                    a[preIndexa] = a[preIndexa] - 1;
                    result[indexa] = a[indexa] + 10 - b[indexb];
                }
            } else {
                result[indexa] = a[indexa];
            }
        }

        StringBuffer sb = new StringBuffer();
        int startIndex = 0;
        for(int i = 0; i < result.length; i ++) { //去除0开头的位
            if(result[i] != 0) {
                startIndex = i;
                break;
            }
        }
        for(int i = startIndex; i < result.length; i ++) {
            sb.append(result[i]);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(solution("1231231237812739878951331231231237812739878951331231231237812739878951331230000000000000000000000001 - 331231231237812739878951331231231"));
    }
}
