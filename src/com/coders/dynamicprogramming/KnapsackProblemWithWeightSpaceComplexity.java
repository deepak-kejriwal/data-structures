package com.coders.dynamicprogramming;

/**
 * 
 * @author Deepak Kejriwal
 *
 */
import java.util.ArrayList;
import java.util.List;

public class KnapsackProblemWithWeightSpaceComplexity {

	public int logic(List<Clock> list, int gcapacity) {
		
		int[] dp = new int[gcapacity + 1];
		
		for (int i = 0; i < list.size(); i++) {
			Clock clock = list.get(i);
			for (int capacity = gcapacity; capacity >= 0; capacity--) {
				if (capacity - clock.weight >= 0) {
					dp[capacity] = Math.max(dp[capacity], dp[capacity - clock.weight] + clock.value);
				}
			}
		}
		
		return dp[gcapacity];
	}

	public class Clock {
		Integer value;
		Integer weight;

		Clock(int value, int weight) {
			this.value = value;
			this.weight = weight;
		}
	}

	public static void main(String[] args) {
		new KnapsackProblemWithWeightSpaceComplexity().test();
	}

	public void test() {
		Clock c1 = new Clock(60, 5);
		Clock c2 = new Clock(50, 3);
		Clock c3 = new Clock(70, 4);
		Clock c4 = new Clock(30, 2);
		List<Clock> list = new ArrayList<>();
		list.add(c1);
		list.add(c2);
		list.add(c3);
		list.add(c4);
		System.out.println(logic(list, 6));
	}
}
