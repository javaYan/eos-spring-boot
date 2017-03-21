package eos.java.practice.sort;

/**
 * 冒泡排序
 * 它重复地走访过要排序的数列，一次比较两个元素，如果他们的顺序错误就把他们交换过来。走访数列的工作是重复地进行直到没有再需要交换，也就是说该数列已经排序完成。
 * 稳定   时间复杂度：O(n2)  空间复杂度O(1)
 */
public class BubbleSort {
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static void sort(Comparable[] compare) {
		Comparable temp = null;
		for (int i = compare.length - 1; i > 0; i--) {
			for (int j = 0; j < i; j++) {
				if (compare[j].compareTo(compare[j + 1]) == 1) {
					temp = compare[j];
					compare[j] = compare[j + 1];
					compare[j + 1] = temp;
				}
			}
		}
	}
	
}
