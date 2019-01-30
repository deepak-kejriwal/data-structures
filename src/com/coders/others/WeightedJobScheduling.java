package com.coders.others;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * 
 * @author Deepak Kejriwal
 *
 */
public class WeightedJobScheduling {

	public int findMaxProfit(List<List<Integer>> jobs) {
		sort(jobs);
		Map<Integer, Integer> map = createNonConflict(jobs);
		Map<Integer, Integer> dp = new HashMap<>();
		return findMaxProfit(jobs, map, dp,jobs.size());
	}

	private int findMaxProfit(List<List<Integer>> jobs, Map<Integer, Integer> map, Map<Integer, Integer> dp, int numberOfJobs) {
		if (numberOfJobs == 0)
			return 0;
		if(dp.get(numberOfJobs)!=null) {
			return dp.get(numberOfJobs);
		}
		int profit1 = jobs.get(numberOfJobs - 1).get(2) + findMaxProfit(jobs, map,dp, map.getOrDefault(numberOfJobs, 0));
		int profit2 = findMaxProfit(jobs, map, dp,numberOfJobs - 1);
		int maxProfit=Math.max(profit1, profit2);
		dp.put(numberOfJobs, maxProfit);
		return maxProfit;
	}

	private Map<Integer, Integer> createNonConflict(List<List<Integer>> jobs) {
		Map<Integer, Integer> map = new HashMap<>();
		for (int i = jobs.size() - 1; i >= 0; --i) {
			for (int j = i - 1; j >= 0; --j) {
				if (jobs.get(j).get(1) <= jobs.get(i).get(0)) {
					map.put(i + 1, j + 1);
					break;
				}
			}
		}
		return map;
	}

	private void sort(List<List<Integer>> jobs) {
		jobs.sort((v1, v2) -> v1.get(1).compareTo(v2.get(1)));
	}

	public static void main(String[] args) {
		WeightedJobScheduling maxProfiter = new WeightedJobScheduling();
		maxProfiter.test1();
		maxProfiter.test2();
		maxProfiter.test3();
		maxProfiter.test4();
	}

	private void test1() {
		List<Integer> job1 = Stream.of(1, 4, 50).collect(Collectors.toList());
		List<Integer> job2 = Stream.of(3, 5, 70).collect(Collectors.toList());
		List<Integer> job3 = Stream.of(6, 19, 100).collect(Collectors.toList());
		List<Integer> job4 = Stream.of(19, 100, 200).collect(Collectors.toList());
		List<List<Integer>> jobs = new ArrayList<>();
		jobs.add(job1);
		jobs.add(job2);
		jobs.add(job3);
		jobs.add(job4);
		System.out.println(findMaxProfit(jobs));
	}

	private void test2() {
		List<Integer> job1 = Stream.of(1, 4, 50).collect(Collectors.toList());
		List<Integer> job2 = Stream.of(3, 5, 20).collect(Collectors.toList());
		List<Integer> job3 = Stream.of(6, 19, 100).collect(Collectors.toList());
		List<Integer> job4 = Stream.of(2, 100, 200).collect(Collectors.toList());
		List<List<Integer>> jobs = new ArrayList<>();
		jobs.add(job1);
		jobs.add(job2);
		jobs.add(job3);
		jobs.add(job4);
		System.out.println(findMaxProfit(jobs));
	}

	private void test3() {
		List<Integer> job1 = Stream.of(1, 4, 50).collect(Collectors.toList());
		List<Integer> job2 = Stream.of(3, 5, 20).collect(Collectors.toList());
		List<Integer> job3 = Stream.of(6, 19, 100).collect(Collectors.toList());
		List<Integer> job4 = Stream.of(19, 100, 200).collect(Collectors.toList());
		List<List<Integer>> jobs = new ArrayList<>();
		jobs.add(job1);
		jobs.add(job2);
		jobs.add(job3);
		jobs.add(job4);
		System.out.println(findMaxProfit(jobs));
	}

	private void test4() {
		List<Integer> job1 = Stream.of(1, 2, 50).collect(Collectors.toList());
		List<Integer> job2 = Stream.of(3, 5, 20).collect(Collectors.toList());
		List<Integer> job3 = Stream.of(6, 19, 100).collect(Collectors.toList());
		List<Integer> job4 = Stream.of(2, 100, 200).collect(Collectors.toList());
		List<List<Integer>> jobs = new ArrayList<>();
		jobs.add(job1);
		jobs.add(job2);
		jobs.add(job3);
		jobs.add(job4);
		System.out.println(findMaxProfit(jobs));
	}
}
