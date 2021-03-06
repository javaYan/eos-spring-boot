package eos.java.practice.oj.xiaomi;

/**
 *
 村村通计划
 序号：#51 难度：非常难  时间限制：1000ms  内存限制：10M
 描述

 乡政府设立了一项村村通计划，准备修建一个公路网，以覆盖乡里所有村落。不要求每个村落都直接连通，只要有路到达即可（例如A->B,B->C,那么 A->C也连通）。但是因为财政压力过大，要求尽量节省开支。
 经过调研和评估，政府已经评估出了每两个村之间修筑一条路所需要的成本，请问实现村村通计划，所需要的最低成本是多少？
 输入

 第一个数字n表示村庄的个数，村庄编号为1~n
 之后有n*(n-1)/2组元素，每组有a,b,c三个数字,a,b是村庄编号，c是两个村庄之间修路的成本。

 例如3;1,2,3;1,3,4;2,3,5
 表示一共3个村庄，1,2之间修路需要花费3，2,3之间修路需要花费5，1,3之间修路需要花费4。
 输出

 一个整数，表示最少需要花费的成本。
 输入样例

 3;1,2,3;1,3,4;2,3,5
 输出样例

 7
 */
public class oj051 {
    private static String solution(String line) {
        //TODO
        //假设Fn表示n个村庄已经达成最优，则Fn+1=Fn + 第n+1个村庄与前n个村庄的最优
        //使用递归
        return null;
    }

    public static void main(String[] args) {
        System.out.println(solution("2,4,5,4,2"));
    }
}
