package com.coders.array;

/**
 * 
 * @author Deepak Kejriwal
 *
 */
/*
 * 
 * Given an Array of integers, write a method that will return the integer with
 * the maximum number of repetitions. Your code is expected to run with O(n)
 * time complexity and O(1) space complexity. The elements in the array are
 * between 0 to size(array) - 1 and the array will not be empty.
 * 
 * f({3,1,2,2,3,4,4,4}) --> 4
 * 
 */
public class MaxRepetitions {

	public static void main(String[] args) {
		int[] a = { 3, 1, 2, 2, 3, 4, 4, 4 };
		int[] b = {0,1,2 };
		System.out.println(getMaxRepetition(a));
		System.out.println(getMaxRepetition(b));
	}

	public static int getMaxRepetition(int[] a) {

		if (a.length == 1)
			return a[0];
		int size = a.length;

		for (int i = 0; i < size; i++) {
			a[a[i] % size] += size;
		}
		int maxr = -1;
		int result = -1;
		for (int i = 0; i < size; i++) {
			//System.out.println(a[i]);
			if (a[i] > maxr) {
				maxr = a[i];
				result = i;
			}
		}
		return maxr > 2 * size ? result : -1;
	}
}
