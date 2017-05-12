package eos.java.practice.oj.xiaomi;

/**
 交叉队列
 描述

 给出三个队列 s1，s2，s3 ，判断 s3 是否是由 s1 和 s2 交叉得来。
 如：s1 为 aabcc ， s2 为 dbbca。
 当 s3 为 aadbbcbcac 时，返回 true（即将 s1 拆成三部分： aa，bc，c 分别插入 s2 对应位置）
 否则返回 false。
 输入

 aabcc,dbbca,aadbbcbcac
 输出

 true
 输入样例

 aabcc,dbbca,aadbbcbcac

 aabcc,dbbca,aadbbbaccc

 a,b,ab

 a,b,ba

 a,b,ac

 abc,bca,bcaabc

 abc,bca,aabbcc
 输出样例

 true

 false

 true

 true

 false

 true

 false
 */
public class oj006 {
    private static String solution(String line) {
        //如果单纯的一个字符一个字符的拆分匹配 会有问题，如aabcc,dbbca,aadbbcbcac 到最后 s1:c s2:ca s3:cac 会false 其实应该是true
        //因为这种判断默认先取s1 所以解决方法是当s1取到最后一个时，判断一下s2是否也匹配
        String[] strs = line.split(",");

        byte[] s1 = strs[0].getBytes();
        byte[] s2 = strs[1].getBytes();
        byte[] s3 = strs[2].getBytes();
        int length1 = s1.length;
        int length2 = s2.length;
        int length3 = s3.length;
        if(length3 != length1 + length2) {
            return "false";
        }

        int index1 = 0;
        int index2 = 0;
        int index3 = 0;
        while (index3 < length3) {
            if(index1 < length1 && s1[index1] == s3[index3]) {
                if(index1 == length1 - 1) { //如果s1匹配到最后一个 则拓展判断一次
                    if(index2 < length2 && s2[index2] == s3[index3]) { //如果s2也匹配，优先匹配s2
                        index2 ++;
                        index3 ++;
                        continue;
                    }
                }
                index1 ++;
                index3 ++;
                continue;
            }
            if(index2 < length2 && s2[index2] == s3[index3]) {
                index2 ++;
                index3 ++;
                continue;
            }
            return "false";
        }
        return "true";
    }
    //aabcc,dbbca,aadbbcbcac
    public static void main(String[] args) {
        System.out.println(solution("aabcc,dbbca,aadbbcbcac"));
    }
}
