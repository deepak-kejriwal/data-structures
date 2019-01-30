package com.coders.others;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 
 * @author Deepak Kejriwal
 *
 */

/*
 * 
 * You have given height array of array. Generate the original array. 
 * 
 * Input: [6,3,0,2,2,0,0] 
 * 
 * Output : [ 1,4,7,3,2,6,5] 
 * 
 * A[i] value in input array is the number of greater element on right side
 * 
 * 
 */
public class GenerateArrayWithGivenHeight {
	
	public static int[] constructArray(int[] arr) {
		
		List<Integer> list = new ArrayList<>();
		
		for (int i = 1; i <= arr.length; i++) {
			list.add(i);		
		}
		
		for (int i = 0; i < arr.length; i++) {
			int k = arr.length - arr[i] - i;
			arr[i] = list.get(k - 1);
			list.remove(k - 1);
		}
		
		return arr;
	}

	public static void main(String[] args) {
		int[] input= {6,3,0,2,2,0,0};
		int[] output=constructArray(input);
		System.out.println(Arrays.toString(output));
	}

}
