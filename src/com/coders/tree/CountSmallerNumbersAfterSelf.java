package com.coders.tree;
/**
 * 
 * @author Deepak Kejriwal
 *
 */
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CountSmallerNumbersAfterSelf {

	public static void main(String[] args) {
		int[] nums=new int[] {3,4,2,1};
		CountSmallerNumbersAfterSelf cs=new CountSmallerNumbersAfterSelf();
		System.out.println(cs.countSmaller(nums));

	}

	public List<Integer> countSmaller(int[] nums) {
		// count the freq[rank]
		List<Integer> res = new ArrayList<>();
		if (nums == null || nums.length == 0) {
			return res;
		}
		int[] sorted = nums.clone();
		Arrays.sort(sorted);
		nums = reverse(nums);
		Map<Integer, Integer> map = new HashMap<>();
		// get rank
		for (int i = nums.length - 1; i >= 0; i--) {
			map.put(sorted[i], i);
		}
		int[] bit = new int[nums.length + 1];

		for (int i = 0; i < nums.length; i++) {
			int count = getSum(bit, map.get(nums[i]) - 1);
			res.add(0, count);
			update(bit, map.get(nums[i]), 1);
		}
		return res;
	}

	private int getSum(int[] bit, int index) {
		int sum = 0;
		for (int i = index + 1; i > 0; i -= (i & (-i))) {
			sum += bit[i];
		}
		return sum;
	}

	private void update(int[] bit, int index, int diff) {
		for (int i = index + 1; i < bit.length; i += (i & (-i))) {
			bit[i] += diff;
		}
	}

	private int[] reverse(int[] nums) {
		int[] res = new int[nums.length];
		for (int i = 0; i < nums.length; i++) {
			res[nums.length - i - 1] = nums[i];
		}
		return res;
	}
}
