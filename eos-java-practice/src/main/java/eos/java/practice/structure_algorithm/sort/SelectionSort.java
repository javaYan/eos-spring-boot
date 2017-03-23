package eos.java.practice.structure_algorithm.sort;

/**
 * 直接选择排序
 * 每一次从待排序的数据元素中选出最小（或最大）的一个元素，存放在序列的起始位置，直到全部待排序的数据元素排完。
 * 不稳定   时间复杂度：O(n2)  空间复杂度O(1)
 */
public class SelectionSort {

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static void sort(Comparable[] compare) {
		int length = compare.length;
		int maxIndex = 0;
		for (int i = 0; i < length; i++) {
			maxIndex = i;
			for (int j = i + 1; j < length; j++) {
				maxIndex = compare[maxIndex].compareTo(compare[j]) == -1 ? maxIndex : j;
			}
			if (maxIndex != i) {
				Comparable temp = compare[maxIndex];
				compare[maxIndex] = compare[i];
				compare[i] = temp;
			}
		}
	}
	
}
