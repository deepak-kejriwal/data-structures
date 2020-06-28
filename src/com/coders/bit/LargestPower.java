package com.coders.bit;

public class LargestPower {

	public static void main(String[] args) {
		System.out.println(largest_power((long)Math.pow(2, 31)-1));
		System.out.println((long)Math.pow(2, 30));
	}

	private static long largest_power(long N) {
	    //changing all right side bits to 1.
	    N = N | (N>>1);  // leftmost 2 bit became 1
	    N = N | (N>>2);  // leftmost 4 bit became 1
	    N = N | (N>>4);  // leftmost 8 bit became 1
	    N = N | (N>>8);  // leftmost 16 bit became 1
	    N = N | (N>>16);  // leftmost 32 bit became 1
	    return (N+1)>>1;
	}
}
