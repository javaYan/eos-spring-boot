package eos.java.practice.structure_algorithm.random;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Random;
import java.util.Set;

/**
 * 输出随机数
 * Created by yanyuyu on 2017/3/23.
 */
public class RandomNumber {

    /**
     * 获取介于[limitMinNumber~limitMaxNumber)的随机数
     * @param limitMinNumber
     * @param limitMaxNumber
     */
    public static int outputRandom(int limitMinNumber, int limitMaxNumber) {
        Random r = new Random();
        return r.nextInt(limitMaxNumber - limitMinNumber) + limitMinNumber;
    }

    /**
     * 获取介于[limitMinNumber~limitMaxNumber)的不重复的随机数
     * @param limitMinNumber
     * @param limitMaxNumber
     * @param repeatTimes
     */
    public static void outputNorepeatRandom(int limitMinNumber, int limitMaxNumber, int repeatTimes) {
        if(repeatTimes > (limitMaxNumber-limitMinNumber)) {
            repeatTimes = limitMaxNumber-limitMinNumber;
        }

        if(repeatTimes*10 < (limitMaxNumber-limitMinNumber)) { //如果重复次数少 但给的范围很大


        } else { //如果次数多 则直接在set输出
            Set<Integer> randomSet = new HashSet<Integer>();
            int digital = limitMinNumber;
            while(digital++ < limitMaxNumber) {
                randomSet.add(digital);
            }

            Iterator<Integer> iterator = randomSet.iterator();
            StringBuilder builder = new StringBuilder();
            while(repeatTimes-- > 0) {
                builder.append(iterator.next()).append(",");
            }
            System.out.println(builder.toString());
        }
    }

    public static void main(String args[]) {
        /*
        StringBuilder builder = new StringBuilder();
        for(int i = 0; i < 10000; i ++) {
            builder.append(RandomNumber.outputRandom(100,200)).append(",");
        }
        System.out.println(builder.toString());
        */


        RandomNumber.outputNorepeatRandom(10,20,4);
    }
}
