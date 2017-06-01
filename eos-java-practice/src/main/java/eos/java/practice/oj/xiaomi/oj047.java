package eos.java.practice.oj.xiaomi;

/**
 * 硬币比赛
 描述

 有 n 个不同价值的硬币排成一条线。有 A 与 B 两个玩家，指定由 A 开始轮流（A 先手，然后 B，然后再 A..）从左边依次拿走 1 或 2 个硬币（不能不拿，也不能拿其他个数），直到没有硬币为止。最后计算 A 与 B 分别拿到的硬币总价值，价值高的人获胜。

 请依据硬币的排列情况来判定，先手的玩家 A 能否找到必胜策略？
 输入

 使用逗号(,)分隔的一个正整数数组，表示这排硬币的排列情况与对应价值
 输出

 true 或 false（字符类型），表示玩家 A 能否找到必胜策略
 输入样例

 1,2,2

 1,2,4
 输出样例

 true

 false
 */
public class oj047 {
    private static String solution(String line) {
        // TODO

        String [] strings = line.split(",");
        String s1 = strings[0];
        String s2 = strings[1];
        //优先插入或删除使位数一致
        return "";
    }

    public static void main(String[] args) {
        System.out.println(solution("abc,badc"));
    }
}
