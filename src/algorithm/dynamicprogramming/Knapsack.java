package algorithm.dynamicprogramming;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Knapsack {
	static char c;
	public static void main(String[] args) {
		
		System.out.println(c);
		new Knapsack().test();
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

	public int logic(List<Clock> list, int gcapacity) {
		int[] cache = new int[gcapacity + 1];
		for (int i = 0; i < list.size(); i++) {
			Clock clock = list.get(i);
			for (int capacity = gcapacity; capacity >= 0; capacity--) {
				//if (i == -1) {
				//	if (capacity >= clock.weight) {
				//		cache[capacity] = clock.value;
				//	} else {
				//		cache[capacity] = 0;
				//	}
				//} else {
					List<Integer> lis = Stream.of(capacity, capacity - clock.weight).collect(Collectors.toList());
					lis = lis.stream().map(c -> c >= 0 ? cache[c] : -1).collect(Collectors.toList());
					if (lis.get(1) != -1) {
						lis.set(1, lis.get(1) + clock.value);
					} 
					cache[capacity] = lis.stream().mapToInt(x -> x).max().getAsInt();
				//}
			}
		}
		return cache[gcapacity];
	}

	public class Clock {
		Integer value;
		Integer weight;

		Clock(int value, int weight) {
			this.value = value;
			this.weight = weight;
		}
	}
}
