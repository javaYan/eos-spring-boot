package eos.java.practice.structure_algorithm.sort;

/**
 * 希尔排序  实际是分组直接插入排序
 * 按照length/2进行划分间隔，以间隔分组
 * 如length=10, 则组数=length/2=5组，即a[0],a[5]一组排序 a[1],a[6]一组排序...a[4],a[9]一组排序
 * 下一次组数=5/2=2组即a[0],a[2],a[4],a[6],a[8]一组排序a[1],a[3],a[5],a[7],a[9]一组排序
 * 下一次组数=2/2=1组即a[0],a[1],a[2],a[3],a[4],a[5]a[6],a[7],a[8],a[9]一组排序
 * 不稳定 
 */
public class ShellSort {
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static void sort(Comparable[] compare) {
		int n = compare.length;
		for (int gap = n / 2; gap > 0; gap /= 2) {
			for (int j = gap; j < n; j++) { // 从数组第gap个元素开始
				if (compare[j].compareTo(compare[j - gap]) < 0)// 每个元素与自己组内的数据进行直接插入排序
				{
					Comparable temp = compare[j];
					int k = j - gap;
					while (k >= 0 && compare[k].compareTo(temp) > 0) {
						compare[k + gap] = compare[k];
						k -= gap;
					}
					compare[k + gap] = temp;
				}
			}
		}
	}
	
}
