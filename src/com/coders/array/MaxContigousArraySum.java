package com.coders.array;
/**
* 
* @author Deepak Kejriwal
*
*/
public class MaxContigousArraySum {
	public static void main(String[] args) {
		int[] matrix = { -2, -3, 4, -1, -2, 1, 5, -3 };
		int maxSum = maxSubArraySumDivideAndConquer(matrix, 0, matrix.length - 1);
		System.out.println("maxSum = " + maxSum);
		maxSum = maxSubArraySum(matrix);
		System.out.println("maxSum = " + maxSum);
	}

//Kadane's algorithm
	static int maxSubArraySum(int a[]) {
		int size = a.length;
		int max_so_far = Integer.MIN_VALUE, max_ending_here = 0;

		for (int i = 0; i < size; i++) {
			max_ending_here = max_ending_here + a[i];
			if (max_so_far < max_ending_here)
				max_so_far = max_ending_here;
			if (max_ending_here < 0)
				max_ending_here = 0;
		}
		return max_so_far;
	}

	private static int maxSubArraySumDivideAndConquer(int[] matrix, int left, int right) {
		if (left == right)
			return matrix[left];

		int mid = (left + right) / 2;
		int leftArr = maxSubArraySumDivideAndConquer(matrix, left, mid);
		int rightArr = maxSubArraySumDivideAndConquer(matrix, mid + 1, right);
		int maxCross = maxSumCrossOver(matrix, left, mid, right);
		// System.out.println("L: "+leftArr+" ,R: "+rightArr+" ,C: "+maxCross);
		return Math.max(Math.max(leftArr, rightArr), maxCross);
	}

	private static int maxSumCrossOver(int[] matrix, int left, int mid, int right) {

		int leftSum = matrix[mid];
		int sum = 0;
		for (int i = mid; i >= left; i--) {
			sum = sum + matrix[i];
			if (sum > leftSum)
				leftSum = sum;
		}

		int rightSum = matrix[mid + 1];
		sum = 0;
		for (int i = mid + 1; i <= right; i++) {
			sum = sum + matrix[i];
			if (sum > rightSum)
				rightSum = sum;
		}
		return leftSum + rightSum;
	}
}
