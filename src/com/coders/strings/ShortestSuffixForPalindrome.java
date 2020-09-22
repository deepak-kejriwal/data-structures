package com.coders.strings;

/**
 * 
 * @author Deepak Kejriwal
 *
 */
public class ShortestSuffixForPalindrome {

	public static void main(String[] args) {
		ShortestSuffixForPalindrome ssfp=new ShortestSuffixForPalindrome();
		//String input = "mmmmmabmmmmm";
		//String input = "boof";
		//String input = "madcda";
		//String input = "adcda";
		//String input = "madcdat";
		//String input = "mcaabaa";
		String input = "abcdcb";
		System.out.println("Output:" + ssfp.suffixKMP(input));
	}

	private String suffixKMP(String input) {
		KMP kmp=new KMP();
		int[] prefix=kmp.prefixTable(new StringBuilder(input).reverse().toString()+"#"+input);
		int lengthOfLongestPalindrome=prefix[prefix.length - 1];
		return new StringBuilder(input.substring(0,input.length()-lengthOfLongestPalindrome)).reverse().toString();// + input;
	}

	private String suffixNative(String input) {
		if (input == null)
			return "";
		char[] chs = input.toCharArray();

		for (int i = 0; i < chs.length; ++i) {
			if (isPalindrome(input.substring(i))) {
				String res = input.substring(0, i);
				StringBuilder sb = new StringBuilder(res);
				return sb.reverse().toString();
			}
		}

		return "";
	}

	private boolean isPalindrome(String input) {
		char[] chs = input.toCharArray();
		int i = 0;
		int j = chs.length - 1;
		while (i < j) {
			if (chs[i++] != chs[j--]) {
				return false;
			}
		}

		return true;
	}

}
