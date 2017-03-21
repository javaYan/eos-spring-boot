package eos.java.practice.sort;

/**
 * 插入排序
 * 将一组无须的数据依次插入到已经排好序的有序数据中，从而得到一个新的有序数据
 * 稳定   时间复杂度：O(n2)  空间复杂度O(1)
 */
public class InsertionSort {
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static void sort(Comparable[] compare) {
		Comparable temp = null;
		for (int i = 1; i < compare.length; i++) {
			int j = i;
			while(j > 0 && compare[j].compareTo(compare[j-1]) < 0) {
				temp = compare[j];
				compare[j] = compare[j-1];
				compare[j-1] = temp;
				j--;
			}
		}
	}
}
