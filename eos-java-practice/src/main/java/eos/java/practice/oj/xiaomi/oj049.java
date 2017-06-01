package eos.java.practice.oj.xiaomi;

/**
 * 搬砖在总参
 描述

 总参食堂装修，有一堆砖块放在 3 层，因为电梯坏了，现需要程序员们帮忙人力将砖块搬至 B2 层。
 假设程序员们的起点为 3 层，一个程序员一次只能搬 1 公斤的砖，下一个楼层和上一个楼层都需要 1 分钟,连续工作 18 分钟需要原地休息 5 分钟。
 输入

 砖块的总重量和人数用英文逗号隔开，如 2,1。
 表示有 2 公斤的砖块需要 1 个程序员来搬，砖块重量和人数均大于 0。
 输出

 搬完所有砖块需要的时长（分钟），如：12。
 输入样例

 11,2

 2,1

 6,7
 输出样例

 54

 12

 4

 */
public class oj049 {
    private static String solution(String line) {
        String [] strArray = line.split(",");
        int weight = Integer.parseInt(strArray[0]);
        int worker = Integer.parseInt(strArray[1]);

        if(weight <= worker) {
            return "4";
        }

        int time = 0;
        int energy = 0;
        boolean over = false;
        while( !over ) {
            if(weight - worker > 0) {
                if((energy + 8) >= 18) {
                    time+=13;
                    energy = energy -10;
                } else {
                    time+=8;
                    energy += 8;
                }
                weight -= worker;
            } else {
                if((energy + 4) > 18) {
                    time+=9;
                } else {
                    time += 4;
                }
                over = true;
            }
        }

        return time + "";
    }

    public static void main(String[] args) {
        System.out.println(solution("6,7"));
    }
}
