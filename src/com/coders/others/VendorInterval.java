package com.coders.others;
/**
* 
* @author Deepak Kejriwal
*
*/
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;

/*
There is going to be a sale during this month. You are interested in a particular item and you found that different Vendors have different prices during different time periods. You collected the following information:


Vendor => (start date, end date, price) both sides inclusive
A => (1, 5, $20)
B => (3, 6, $15)
C => (2, 8, $25)
D => (7, 12, $18)
E => (1, 31, $22)
As you can see, there are conflicting entries. You need to print out a non-conflicting schedule of prices, taking the best price from each period: 

e.g. 
(1, 2, $20), (3, 6, $15), (7, 12, $18), (13, 31, $22)
 * 
 * 
 * 
 */
public class VendorInterval {

	public static void main(String[] args) {
		// new VendorInterval().test1();
		new VendorInterval().test2();
	}

	public void test1() {
		Interval v1 = new Interval(1, 5, 28);
		Interval v2 = new Interval(3, 7, 15);
		Interval v3 = new Interval(6, 12, 8);
		List<Interval> vendors = new ArrayList<>();
		vendors.add(v1);
		vendors.add(v2);
		vendors.add(v3);
		List<Interval> result = minimumPriceIntervals1(vendors);
		System.out.println(result);
		result = minimumPriceIntervals2(vendors);
		System.out.println(result);
	}

	public void test2() {
		Interval v1 = new Interval(1, 5, 20);
		Interval v2 = new Interval(3, 6, 15);
		Interval v3 = new Interval(2, 8, 25);
		Interval v4 = new Interval(7, 12, 18);
		Interval v5 = new Interval(1, 31, 22);
		List<Interval> vendors = new ArrayList<>();
		vendors.add(v1);
		vendors.add(v2);
		vendors.add(v3);
		vendors.add(v4);
		vendors.add(v5);
		List<Interval> result = minimumPriceIntervals1(vendors);
		System.out.println(result);
		result = minimumPriceIntervals2(vendors);
		System.out.println(result);
		// Difference between above 2 result seen below
		// [[1,2,20], [3,6,15], [7,12,18], [13,31,22]]
		// [[1,3,20], [3,6,15], [6,7,22], [7,12,18], [12,31,22]]
	}

	// This is for interval like date where there is no in-between date between say 2 and 3
	private List<Interval> minimumPriceIntervals1(List<Interval> vendors) {
		List<Interval> output = new LinkedList<>();
		Map<Integer, Integer> map = new TreeMap<>();
		for (Interval v : vendors) {
			int start = v.startTime;
			int end = v.endTime;
			int price = v.price;
			for (int i = start; i <= end; i++) {
				//Interval key = new Interval(i, i + 1, price);
				if (map.getOrDefault(i, Integer.MAX_VALUE) > price) {
					map.put(i, price);
				}
			}
		}
		
		int prevPrice = Integer.MAX_VALUE;
		int start = 0;
		int end = 0;
		for (Entry<Integer, Integer> entry : map.entrySet()) {
			 int price=entry.getValue();
			 if(price!=prevPrice) {
				 output.add(new Interval(start,end,prevPrice));
				 prevPrice=price;
				 start=entry.getKey();
				 end=start;
			 }else {
				 end=entry.getKey();
			 }
		}
		output.add(new Interval(start, end, prevPrice));
		output.remove(0);
		return output;
	}

	// This is for interval like time where there is in-between time between say 2 and 3
	public List<Interval> minimumPriceIntervals2(List<Interval> vendors) {

		List<Interval> output = new LinkedList<>();
		Map<Interval, Integer> map = new TreeMap<>((v1, v2) -> Integer.compare(v1.startTime, v2.startTime));

		for (Interval v : vendors) {
			int start = v.startTime;
			int end = v.endTime;
			int price = v.price;
			//Difference is in for loop condition only, rest code is same as above
			for (int i = start; i < end; i++) {
				Interval key = new Interval(i, i + 1, price);
				if (map.getOrDefault(key, Integer.MAX_VALUE) > price) {
					map.put(key, price);
				}
			}
		}

		int prevPrice = Integer.MAX_VALUE;
		int start = 0;
		int end = 0;
		for (Entry<Interval, Integer> entry : map.entrySet()) {
			int price = entry.getValue();
			if (price != prevPrice) {
				output.add(new Interval(start, end, prevPrice));
				prevPrice = price;
				start = entry.getKey().startTime;
				end = entry.getKey().endTime;
			} else {
				end = entry.getKey().endTime;
			}
		}
		output.add(new Interval(start, end, prevPrice));
		output.remove(0);
		return output;
	}

	class Interval {
		int startTime;
		int endTime;
		int price;

		public Interval(int startTime, int endTime, int price) {
			this.startTime = startTime;
			this.endTime = endTime;
			this.price = price;
		}

		@Override
		public String toString() {
			return "[" + startTime + "," + endTime + "," + price + "]";
		}
	}

}
