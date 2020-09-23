package com.coders.dynamicprogramming;

/**
 * 
 * @author Deepak Kejriwal
 *
 */
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

public class KnapsackProblemWithAchievableWeightSpaceComplexity {

	public int logic(List<Clock> list, int gcapacity) {
		List<Integer> reverseKey = subsets(list, gcapacity);
		
		Map<Integer, Integer> dp = new HashMap<>();
		
		for(int key:reverseKey) {
			if(key>=list.get(0).weight) {
				dp.put(key, list.get(0).value);
			}else {
				dp.put(key, 0);
			}
		}
		
		
		for (int i = 1; i < list.size(); i++) {
			Clock clock = list.get(i);
			for (int j = 0; j < reverseKey.size(); j++) {
				int capacity = reverseKey.get(j);
				if ( capacity - clock.weight >= 0) {
											  //Not include			//Include
					dp.put(capacity, Math.max(dp.get(capacity), dp.get(capacity - clock.weight) + clock.value));
				}
			}
		}
		return dp.get(reverseKey.get(0));
	}

	public List<Integer> subsets(List<Clock> clocks, int capacity) {

		List<Integer> list = new ArrayList<>();
		list.add(0);

		for (Clock clock : clocks) {

			int size = list.size();
			Set<Integer> tempList = new TreeSet<>(list);
			
			for (int i = 0; i < size; i++) {
				if (list.get(i) + clock.weight <= capacity) {
					tempList.add(list.get(i) + clock.weight);
				}

			}
			list = new ArrayList<>(tempList);
		}
		list.sort(Collections.reverseOrder());
		return list;
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
		new KnapsackProblemWithAchievableWeightSpaceComplexity().test();
	}

	public void test() {
		Clock c1 = new Clock(60, 100);
		Clock c2 = new Clock(50, 200);
		Clock c3 = new Clock(70, 200);
		Clock c4 = new Clock(30, 500);
		List<Clock> list = new ArrayList<>();
		list.add(c1);
		list.add(c2);
		list.add(c3);
		list.add(c4);
		System.out.println(logic(list, 853));
	}
}
