package eos.java.practice.sort;

/**
 * 基数排序(也可称作桶排序，即按桶号进行排数)
 * 按照待排序列的某一位上的数字大小进行排序 直至所有位都进行过排序为止
 * 比如 1,42,33,12,44 
 * 先按照个位大小进行排序 1,42,12,33,44
 * 再按照十位大小进行排序 1,12,33,42,44
 */
public class RadixSort {

	public static void sort(Integer[] array) {
		int maxDigit = getMaxDigit(array);
		int n = 1;
		int length = array.length;
		int count = 1;
		while (count <= maxDigit) {
			int[][] bucket = new int[10][array.length]; // 记录桶号 + 每个桶中放置的数
			int[] order = new int[10]; // order[x] :记录 x号桶放了多少个数
			for (int i = 0; i < length; i++) {
				int remainder = array[i] / n % 10;
				bucket[remainder][order[remainder]] = array[i];
				order[remainder]++;
			}
			for (int i = 0, k = 0; i < 10; i++) {
				if (order[i] != 0)
					for (int j = 0; j < order[i]; j++) {
						array[k] = bucket[i][j];
						k++;
					}
				order[i] = 0;
			}
			n *= 10;
			count++;
		}
	}
	
	/**
	 * 得到待排序列中最大的数的位数
	 */
	public static int getMaxDigit(Integer [] array) {
		Integer maxInteger = array[0];
		for(int i = 1; i < array.length; i ++) {
			maxInteger = maxInteger.compareTo(array[i]) > 0 ? maxInteger : array[i];
		}
		return String.valueOf(maxInteger).length();
	}
}
