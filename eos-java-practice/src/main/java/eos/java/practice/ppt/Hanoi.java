package eos.java.practice.ppt;

/**
 * 汉诺塔：始终保证小圆盘上不能放大圆盘，一次只能移动一个圆盘
 */
public class Hanoi {
    private static int count = 1 ;
    //有 A B C三个容器　　A上放入N个圆盘
    //目标是借助B容器，将A容器上的所有圆盘移动到C容器上
    //每次取A中最大的圆盘，移到C中
    public static void moveDisc(int n, char a, char b, char c) {
        if( n == 1) {
            System.out.println("第" + (count++) + "步 :" + "将  盘子 1 从  " + a + " 移动到  " + c);
        } else {
            moveDisc(n - 1, a, c, b);
            System.out.println("第" + (count++) + "步 :" + "将  盘子 "+ n + " 从  " + a + " 移动到  " + c);
            moveDisc(n - 1, b, a, c);
        }
    }


    public static void main(String args[]) {
        Hanoi.moveDisc(4, 'A', 'B', 'C');
    }
}
