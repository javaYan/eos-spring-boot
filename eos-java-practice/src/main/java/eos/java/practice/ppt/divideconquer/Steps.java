package eos.java.practice.ppt.divideconquer;


public class Steps {

    //直接递归
    public int doStepsF1(int n) {
        if( n == 1) {
            return 1;
        }
        if(n == 2) {
            return 2;
        }
        return doStepsF1(n-1)+doStepsF1(n-2);
    }

    private int[] temp;
    //存储每步递归结果
    public int doStepsF2(int n) {
        if( n == 1) {
            return 1;
        }
        if(n == 2) {
            return 2;
        }
        if(temp[n] > 0) {
            System.out.println("命中辅助存储器"+n);
            return temp[n];
        }
        temp[n] = doStepsF2(n-1) + doStepsF2(n-2) ;
        return temp[n];
    }

    //正序思考结果
    public int doStepsF3(int n) {
        int count = 0;
        int before1 = 2;
        int before2 = 1;
        if( n == 1) {
            return 1;
        }
        if(n == 2) {
            return 2;
        }
        for(int i = 3; i <= n; i ++) {
            count = before1 + before2;
            before2 = before1;
            before1 = count;
        }
        return count;
    }


    public static void main(String args[]) {
        Steps steps = new Steps();

        System.out.println("爬楼方法：" + steps.doStepsF1(12));


        steps.temp = new int[12+1];
        System.out.println("爬楼方法：" + steps.doStepsF2(12));

        System.out.println("爬楼方法：" + steps.doStepsF3(12));
    }

}
