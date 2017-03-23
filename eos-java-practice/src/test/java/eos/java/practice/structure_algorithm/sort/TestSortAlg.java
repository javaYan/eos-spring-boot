package eos.java.practice.structure_algorithm.sort;

import org.junit.Test;

/**
 * Created by yanyuyu on 2017/3/23.
 */
public class TestSortAlg {
    @Test
    public void test() {
        Integer[] a = {99,88,12,78,66,244,9,8,7,6,5,4,3,2321,244,12};
		/*
		ShellSort.sort(a);
		*/
		/*
		SelectionSort.sort(a);
		*/
        InsertionSort.sort(a);
        for(int i = 0; i < a.length; i ++) {
            System.out.println(a[i]);
        }
    }
}
