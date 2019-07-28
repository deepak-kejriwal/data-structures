package com.coders.tree;

/**
 * 
 * @author Deepak Kejriwal
 *
 */
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class CountSmallerNumbersAfterSelfSimplified {

	public static void main(String[] args) {
		//int[] nums=new int[] {8,7,5,6};
		int[] nums=new int[] {4,3,2,1};
		CountSmallerNumbersAfterSelfSimplified cs=new CountSmallerNumbersAfterSelfSimplified();
		System.out.println(cs.countSmaller(nums));

	}

	public List<Integer> countSmaller(int[] nums) {
		if (nums == null || nums.length == 0)
			return null;
		int[] sorted = nums.clone();
		Arrays.sort(sorted);
		Map<Integer, Integer> map = new HashMap<>();
		for (int i = sorted.length - 1; i >= 0; --i) {
			map.put(sorted[i], i + 1);
		}
		int[] bit = new int[nums.length + 1];
		List<Integer> result = new ArrayList<>();
		for (int i = nums.length - 1; i >= 0; --i) {
			int count = sumBit(bit, map.get(nums[i]));
			result.add(count);
			updateBit(bit, map.get(nums[i]), 1);
		}
		Collections.reverse(result);
		return result;
	}

	private int sumBit(int[] bit, int index) {
		int sum = 0;
		for (int i = index; i > 0; i -= (i & (-i))) {
			sum += bit[i];
		}
		return sum;
	}

	private void updateBit(int[] bit, int index, int diff) {
		for (int i = index; i < bit.length; i += (i & (-i))) {
			bit[i] += diff;
		}
	}

	private int sum(int[] bit, int index) {
		// System.out.println(index);
		int s = 0;
		for (int i = index; i > 0; --i) {
		
				s += bit[i];
			
		}
		return s;
	}

	private void update(int[] bit, int index, int value) {
		// System.out.println(index+":"+value);
		bit[index] += value;
	}


	private int[] reverse(int[] nums) {
		int[] res = new int[nums.length];
		for (int i = 0; i < nums.length; i++) {
			res[nums.length - i - 1] = nums[i];
		}
		return res;
	}
}
