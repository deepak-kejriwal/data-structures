package com.coders.array;

public class MajoritySearchInSortedArray {

	public static void main(String[] args) {
		System.out.println(hasPopularNumber(new int[] {1,2,3,4,5,6,7,8}));
			
	}

	public static boolean hasPopularNumber(int[] arr) {
		int window = arr.length / 4;
		for (int i = 0; i < arr.length; ) {
			int right = lastOccurence(arr, arr[i], i);
			
			if (i+window-1<right) {
				return true;
			}else {
				i = right +1;
			}
		}
		return false;
	}

	public static int lastOccurence(int[] a, int target, int low) {
		if (a == null) {
			return -1;
		}
		int high = a.length - 1;
		while (low <= high) {
			int mid = low + (high - low) / 2;
			if (a[mid] < target || (a[mid] == target && mid < a.length - 1 && a[mid + 1] == target)) {
				low = mid + 1;
			} else if (a[mid] > target) {
				high = mid - 1;
			} else {
				return mid;
			}
		}
		return -1;
	}
}
