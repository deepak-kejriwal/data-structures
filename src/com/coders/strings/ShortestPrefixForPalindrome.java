package com.coders.strings;

public class ShortestPrefixForPalindrome {

	public static void main(String[] args) {
		ShortestPrefixForPalindrome ssfp = new ShortestPrefixForPalindrome();
		// String input = "mmmmmabmmmmm";
		// String input = "boof";
		// String input = "madcda";
		// String input = "adcda";
		String input = "adcdats";
		// String input = "mcaabaa";
		System.out.println("Output:" + ssfp.shortestPalindromeKMP(input));
	}

	private String shortestPalindromeKMP(String input) {
		KMP kmp = new KMP();
		int[] prefix = kmp.prefixTable(input + "#" + new StringBuilder(input).reverse().toString());
		int lengthOfLongestPalindrome = prefix[prefix.length - 1];
		return new StringBuilder(input.substring(lengthOfLongestPalindrome, input.length())).reverse() + input;
	}
	
	

}
