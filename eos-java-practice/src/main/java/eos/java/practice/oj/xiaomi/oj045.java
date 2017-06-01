package eos.java.practice.oj.xiaomi;

import java.util.Arrays;
import java.util.HashSet;

/**
 * 德州扑克
 描述

 德州扑克是风靡全球的一种扑克游戏。扑克有四种花色，分别为黑桃（S）、红桃（H）、梅花（C）、方片（D）。每种花色有13张牌，从小到大分别为2、3、4、5、6、7、8、9、10、J、Q、K、A。

 考虑德州扑克中的如下三种牌形：
 同花顺（Straight Flush）：同一花色，并且连续的五张牌。
 例如：{SK SQ SJ S10 S9}
 对于连续的五张牌，有一个特例，即 {A、2、3、4、5} 也算作连续的五张牌。但 {K、A、2、3、4}，{Q、K、A、2、3}，{J、Q、K、A、2} 不算作连续的五张牌。

 同花（Flush）：同一花色但不连续的五张牌。
 例如：{H10 H7 H4 H3 H2}

 顺子（Straight）：连续但不是同一花色的五张牌。
 例如：{SA H2 D3 C4 D5}

 这三种牌形的大小关系是：顺子 < 同花 < 同花顺。 现在，我们为了游戏的趣味性，在扑克中加入了5张魔术牌（用M表示），你可以将每张魔术牌变成你想要的任何一张牌。 你从牌堆里随机抽了五张牌，请你给出最大可能的牌形。如果三种牌形都无法组成，请输出GG。
 输入

 一行字符串，表示使用分号(;)分隔的五张牌，每张牌由花色与点数组成(或使用M来表示魔术牌)。
 输出

 一行字符串，表示能够组成的最大牌形。
 只有Flush、Straight、Straight Flush、GG四种结果。
 输入样例

 H10;H7;H4;H3;H2

 M;SA;H2;D3;C4

 M;M;M;M;D4

 S8;HJ;DA;H8;H5
 输出样例

 Flush

 Straight

 Straight Flush

 GG
 */
public class oj045 {
    private static String solution(String line) {
        //TODO
        String[] pukes = line.split(";");
        //如果有两种及以上花色 则排除同花顺和同花
        //如果没有魔术牌，且不连续，则排除顺子
        //如果有魔术牌，这判断魔术牌是否可以补足不连续的牌
        int speciesSize = 0; 
        int magicCount = 0;  //魔术牌的个数
        HashSet<String> speciesSet = new HashSet<String>();
        String [] points = new String[5];
        int pointsCount = 0;
        for(int i = 0; i < 5; i ++) {
            if(!"M".equals(pukes[i])) {
                String[] puke = pukes[i].split("");
                speciesSet.add(puke[0]);
                points[pointsCount++] = puke[1]; 
            } else {
                magicCount ++;
            }
        }
        
        speciesSize = speciesSet.size();
        if(magicCount == 0) {
            if(speciesSize > 1) {
                
            } else {
                
            }
        } else {
            if(speciesSize > 1) {
                
            } else {
                
            }
        }
        
        return "";
    }

    public static void main(String[] args) {
        System.out.println(solution("abc,badc"));
    }
}