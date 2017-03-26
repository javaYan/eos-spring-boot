package eos.java.practice.structure_algorithm.search;

/**
 * 二分查找
 * Created by Mr_yyy on 2017/3/25.
 */
public class BinarySearch {


    /**
     * @param number 待查找的数 - 非递归方式
     * @param searchArray 查找数组
     * @return 匹配值的下标索引
     */
    public static int search1 (int number, int [] searchArray ) {
        if(searchArray == null || searchArray.length < 1) {
            return -1;
        }
        int count = 0;
        int length = searchArray.length -1;
        int low = 0;
        int high = searchArray.length-1;
        while( low <= high ) {
            count ++;
            int mid = (high + low) >> 1;
            if(searchArray[mid] < number) {
                low = mid + 1;
            } else if(searchArray[mid] == number) {
                System.out.println("共匹配次数：" + count);
                return mid;
            } else  {
                high = mid - 1;
            }
        }
        System.out.println("共匹配次数：" + count);
        return -1;
    }

    /**
     * @param number 待查找的数 - 递归方式（别忘记每个递归入口都要return ）
     * @param searchArray 查找数组
     * @return 匹配值的下标索引
     */
    public static int search2 (int number, int [] searchArray,int low, int high ) {
        if(low > high) {
            return -1;
        }
        int mid = (low + high) / 2;
        if(searchArray[mid] > number) {
            return search2(number, searchArray, low, mid-1);
        } else if(searchArray[mid] == number) {
            return mid;
        } else {
            return search2(number, searchArray, mid+1, high);
        }
    }
}
