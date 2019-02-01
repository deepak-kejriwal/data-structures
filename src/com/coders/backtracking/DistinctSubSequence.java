package com.coders.backtracking;
/**
 * 
 * @author Deepak Kejriwal
 *
 */
/*
 * 
 * 
 Given a string S, count the number of distinct, non-empty subsequences of S .

Since the result may be large, return the answer modulo 10^9 + 7.

 

Example 1:

Input: "abc"
Output: 7
Explanation: The 7 distinct subsequences are "a", "b", "c", "ab", "ac", "bc", and "abc".
Example 2:

Input: "aba"
Output: 6
Explanation: The 6 distinct subsequences are "a", "b", "ab", "ba", "aa" and "aba".
Example 3:

Input: "aaa"
Output: 3
Explanation: The 3 distinct subsequences are "a", "aa" and "aaa".

Note:

S contains only lowercase letters.
1 <= S.length <= 2000
 * 
 * 
 */
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
