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

        return null;
    }

    public static void main(String[] args) {
        System.out.println(solution("abc,badc"));
    }
}
