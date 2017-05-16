package eos.java.practice.oj.xiaomi;

import java.util.Arrays;

/**
 扑克游戏
 描述

 两个人玩扑克比大小的游戏，规则是每个人抽五张手牌，然后按以下牌形比大小，比较规则是 ：
 顺子 > 4条 > 葫芦 > 3条 > 2对 > 1对 > 单张。
 这副牌已经去掉了两张joker，在比较时不考虑花色，最小2，最大A。
 请写出一段程序来比较两个人手牌的大小。

 说明：不考虑出老千的情况，即两个人的手牌共出现了五张或以上相同的点数。
 输入

 使用逗号(,)分隔的两组数据。
 每组数据为使用空格分隔的字符，表示两个人的手牌点数。点数可能是数字2 ~ 10，也可能是J Q K A。
 点数的分布是无序的。
 输出

 一个字符串，表示第一个人的输赢。
 第一人赢返回 'win' ，输返回'lose'， 平返回'draw'。
 输入样例

 10 10 10 10 8,J J J J 9
 输出样例

 lose
 */
public class oj029 {
    private static String solution(String line) {
        String[] strs = line.split(",");
        char[] xiaoMing = strs[0].toCharArray();
        char[] laoWang = strs[1].toCharArray();
        java.util.Arrays.sort(xiaoMing);
        java.util.Arrays.sort(laoWang);

        int xiaoMingType = 0; //小明的牌的类型
        int[] xiaoMingMax = new int[2]; //小明的最大牌特征
        int laoWangType = 0;  //老王的牌的类型
        int[] laoWangMax = new int[2];  //老王的最大牌特征
        for(int i = 0; i < 5; i ++) {

        }
        return null;
    }

    public static void main(String[] args) {
        System.out.println(solution("abc,badc"));
    }
}
