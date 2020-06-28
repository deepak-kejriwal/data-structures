package com.coders.strings;

/**
 * 
 * @author Deepak Kejriwal
 *
 */
public class KMP {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int[] prefixTable(String str) {
		char[] pattern = str.toCharArray();
		int[] lps = new int[pattern.length];
		int index = 0;
		for (int i = 1; i < pattern.length;) {
			if (pattern[i] == pattern[index]) {
				lps[i] = index + 1;
				index++;
				i++;
			} else {
				if (index != 0) {
					index = lps[index - 1];
				} else {
					lps[i] = 0;
					i++;
				}
			}
		}
		return lps;
	}
}
