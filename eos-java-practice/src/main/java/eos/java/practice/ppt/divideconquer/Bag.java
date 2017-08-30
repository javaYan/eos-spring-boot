package eos.java.practice.ppt.divideconquer;

/**
 * 0-1背包问题
 */
public class Bag{

    /**
     * @param weights 重量
     * @param values　价值
     * @param load　　背包承重
     */
    public static int doBest(int [] weights, int [] values, int load) {
        int limit = weights.length;
        int[][] bestValue = new int [limit][load+1];//m和C的值加1的目的是避免单独处理i-0和j=0的情况
        for(int i = 0; i < limit; i++){
            for(int j = 0; j <= load; j++){
                if(i == 0 || j == 0) {
                    bestValue[i][j] = 0;
                } else if(j>=weights[i]) {
                    bestValue[i][j] = Math.max(bestValue[i-1][j-weights[i]]+values[i], bestValue[i-1][j]);
                } else {
                    bestValue[i][j] = bestValue[i-1][j];
                }
                System.out.println("bestValue["+i+"]["+j+"] = " + bestValue[i][j]);
            }
        }
        return bestValue[limit-1][load];//返回m个物体，容量为C时的最大价值
    }
    
    public static void main(String args[]) {
        int [] weights = {30,30,60,50,40,10,25};
        int [] values =  {10,45,30,50,35,40,30};
        int best = Bag.doBest(weights,values,150);
        System.out.println(best);
    }
}
