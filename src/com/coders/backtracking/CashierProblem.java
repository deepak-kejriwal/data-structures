package com.coders.backtracking;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * 
 * @author deepak1037
 *
 */
public class CashierProblem {
	private static Map<Integer, Set<List<Integer>>> dp = new HashMap<>();

	public static void main(String[] args) {
		Integer amount = 4;
		List<Integer> deno = Stream.of(1, 2, 3).collect(Collectors.toList());
		System.out.println(denominationsList(amount, deno));

	}

	private static Set<List<Integer>> denominationsList(Integer amount, List<Integer> denominations) {
		if (dp.get(amount) != null) {
			return createCopyOfSet(dp.get(amount));
		}
		if (amount <= 0) {
			Set<List<Integer>> empty = new HashSet<>();
			empty.add(new ArrayList<>());
			return empty;
		}
		Set<List<Integer>> rsp = new HashSet<>();
		for (int i = 0; i < denominations.size(); ++i) {
			Integer coin = denominations.get(i);
			if (coin <= amount) {
				Set<List<Integer>> tmp = denominationsList(amount - coin, denominations);
				for (List<Integer> list : tmp) {
					list.add(coin);
				}
				rsp.addAll(tmp);
			}
		}
		dp.put(amount, createCopyOfSet(rsp));
		return rsp;
	}
	
	private static Set<List<Integer>> createCopyOfSet(Set<List<Integer>> set) {
		Set<List<Integer>> set2 = new HashSet<>();
		for (List<Integer> list : set) {
			set2.add(new ArrayList<Integer>(list));
		}
		return set2;
	}
}
