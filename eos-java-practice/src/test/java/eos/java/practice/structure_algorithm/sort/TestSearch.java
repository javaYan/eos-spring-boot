package eos.java.practice.structure_algorithm.sort;

import eos.java.practice.structure_algorithm.search.BinarySearch;
import org.junit.Test;

/**
 * Created by Mr_yyy on 2017/3/25.
 */
public class TestSearch {
    @Test
    public void testBinarySearch() {
        int[] array = {1,5,8,9,12,33,44,45,100,200,201};
        int number = 4;
        System.out.println("search1()匹配索引：" + BinarySearch.search1(number,array));
        System.out.println("search1()匹配索引：" + BinarySearch.search2(number,array,0, array.length-1));

    }
}
