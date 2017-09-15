package eos.java.practice.ppt;

/**
 * 归并排序
 * 将两个顺序序列合并成一个顺序序列
 * 稳定   时间复杂度：O(nlgn)  空间复杂度O(n)
 * 归并排序是稳定的排序.即相等的元素的顺序不会改变，一般用于对总体无序，但是各子项相对有序的数列。
 */
public class MergeSort {
	
	@SuppressWarnings("rawtypes")
	public static void sort(Comparable[] compare) {
		int n = compare.length;
		Comparable[] temp = new Comparable[n];
		mergesort(compare, 0, n-1, temp);
		temp = null;
	}

	// 将有二个有序数列a[first...mid]和a[mid...last]合并
	@SuppressWarnings("rawtypes")
	public static void mergesort(Comparable[] a, int first, int last, Comparable[] temp) {
		if (first < last) {
			int mid = (first + last) / 2;
			mergesort(a, first, mid, temp); // 左边有序
			mergesort(a, mid + 1, last, temp); // 右边有序
			mergearray(a, first, mid, last, temp); // 再将二个有序数列合并
		}
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static void mergearray(Comparable[] a, int first, int mid, int last, Comparable[] temp) {
		int i = first, j = mid + 1;
		int m = mid, n = last;
		int k = 0;

		while (i <= m && j <= n) {
			if (a[i].compareTo(a[j]) <= 0)
				temp[k++] = a[i++];
			else
				temp[k++] = a[j++];
		}

		while (i <= m) {
			temp[k++] = a[i++];
		}

		while (j <= n) {
			temp[k++] = a[j++];
		}

		for (i = 0; i < k; i++) {
			a[first + i] = temp[i];
		}
	}
	
	public static void main(String args[]) {
		Integer [] array = {12,42,21,1,2,3,4};
		MergeSort.sort(array);
		for(int sub : array) {
			System.out.print(sub + " ");
		}
	}
}