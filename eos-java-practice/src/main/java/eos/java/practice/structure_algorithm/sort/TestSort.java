package eos.java.practice.structure_algorithm.sort;

public class TestSort {
	public static void main(String[] args) {
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
