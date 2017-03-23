package eos.java.practice.structure_algorithm.sort;

/**
 * 快速排序
 * 通过一趟排序将要排序的数据分割成独立的两部分，其中一部分的所有数据都比另外一部分的所有数据都要小，然后再按此方法对这两部分数据分别进行快速排序，
 * 整个排序过程可以递归进行，以此达到整个数据变成有序序列。
 * 不稳定   时间复杂度：O(nlgn)  空间复杂度O(nlgn)
 * 
 * 方便理解：
 * 快排可以理解成head=0  tail=length-1的两端自中间直至碰头(head=tail)的挖坑填数
 * 取X=a[head],首先从tail找比X小的，找到后将a[tail]取出，填到坑a[head]中，然后head++，从head找出比X大的，找到后将a[head]取出，填到坑a[tail]中，tail--
 * 循环直至head=tail 将X填至坑a[head]中
 * 递归将0~head-1和head+1~length-1进行挖坑填数即可，递归至拆分成长度为1的数组即停止
 */
public class QuickSort {
	
	@SuppressWarnings("rawtypes")
	private static Comparable [] compare = null; 
	
	@SuppressWarnings("rawtypes")
	public static void sort(Comparable [] compare_){
		compare = compare_;
		recursive(0,compare.length-1);
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	private static void recursive(int head, int tail) {
		Comparable x = compare[head]; // 默认数组首位元素为比较值x
		int xIndex = head;
		for (int i = head, j = tail; i != j;) {
			while (i != j) { //进行从尾部向前扫描小数
				if (x.compareTo(compare[j]) == 1) { //找到即结束，没找到则循环至碰头
					compare[i] = compare[j];
					i++;
					break;
				}
				j--;
			}
			while (i != j) { //进行从头部向后扫描大数
				if (x.compareTo(compare[i]) == -1) { //找到即结束，没找到则循环至碰头
					compare[j] = compare[i];
					j--;
					break;
				}
				i++;
			}
			if (i == j) {
				compare[i] = x;
				xIndex = i;
			}
		}
		if (xIndex - 1 > head) {
			recursive(head, xIndex - 1);
		}
		if (xIndex + 1 < tail) {
			recursive(xIndex + 1, tail);
		}
	}
}
