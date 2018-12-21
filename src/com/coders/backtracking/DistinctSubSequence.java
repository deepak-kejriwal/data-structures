package com.coders.backtracking;
import java.util.Arrays;

public class DistinctSubSequence {

	public static void main(String[] args) {
		System.out.println(distinctSubseqII("aba"));

	}
    public static int distinctSubseqII(String S) {
        long end[] = new long[26], mod = (long)1e9 + 7;
        for (char c : S.toCharArray())
            end[c - 'a'] = Arrays.stream(end).sum() + 1;
        return (int)(Arrays.stream(end).sum() % mod);
    }
    public static int distinctSubseqII2(String S) {
        int end[] = new int[26], res = 0, added = 0, mod = (int)1e9 + 7;
        for (char c : S.toCharArray()) {
            added = (res + 1 - end[c - 'a']) % mod;
            res = (res + added) % mod;
            end[c - 'a'] = (end[c - 'a'] + added) % mod;
        }
        return (res + mod) % mod;
    }
    
    public int distinctSubseqII3(String S) {
        int n = S.length(), M = (int)1e9 + 7; //result = 0;
        int[] count = new int[26];
        int res = 0;
        for (int i = 0; i < n; i++) {
            int index = S.charAt(i) - 'a';
            int added = (1 + res - count[index] + M) % M;
            res = (res + added) % M;
            count[index] = (count[index] + added) % M;
           // result = (result + added) % M;
        }
        return res;
    }
}
