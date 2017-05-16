package eos.java.practice.oj.xiaomi;

/**
 *
 数数有几个岛
 序号：#55 难度：非常难  时间限制：1000ms  内存限制：10M
 描述

 有一个二维的网格地图，其中1代表陆地0代表水，并且该网格的四周全部由水包围。我们对岛屿的定义是四面环水，由相邻的陆地水平或垂直连接形成，现在需要统计岛屿的数量。

 举例：
 有一个二维地图如下：
 11110
 11010
 11000
 00000
 其中的岛屿数量为1。

 提示：是时候祭出 B/DFS（广/深度优先）来一发了！
 输入

 使用空格分隔二维地图的每一行，使用逗号分隔每一项。
 输出

 岛屿的数量。
 输入样例

 1,1,1,1,0 1,1,0,1,0 1,1,0,0,0 0,0,0,0,0

 1,1,0,0,0 1,1,0,0,0 0,0,1,0,0 0,0,0,1,1
 输出样例

 1

 3
 */
public class oj055 {
    private static String solution(String line) {
        String [] rows = line.split(" ");
        String [] cols = rows[0].split(",");
        //组装map
        String [][] maps = new String[rows.length][cols.length];
        for (int i = 0; i < rows.length; i ++) {
            cols = rows[i].split(",");
            for(int j = 0; j < cols.length; j ++) {
                maps[i][j] = cols[j];
            }
        }

        //思路 从[0][0]出发 找出所有的相连接的值为1的位置，count++ 同时修改以上符合条件的位置为0
        //对剩下的为1的位置，类似上述过程 直到全部为0截止
        //输出count

        //TODO
        return "";
    }

    public static void main(String[] args) {
        System.out.println(solution("1,1,1,1,0 1,1,0,1,0 1,1,0,0,0 0,0,0,0,0"));
    }
}
