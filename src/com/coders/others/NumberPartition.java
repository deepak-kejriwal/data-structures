package com.coders.others;

import java.util.ArrayList;
import java.util.List;

/**
* 
* @author Deepak Kejriwal
*
*/
/*
 * Given value, find all possible combination of ways which equals to that sum.
 * Example 1: Input 5, Output: [[5], [4, 1], [3, 2], [3, 1, 1], [2, 2, 1], [2, 1, 1, 1], [1, 1, 1, 1, 1]]
 * Example 2: Input 4, Output: [[4], [3, 1], [2, 2], [2, 1, 1], [1, 1, 1, 1]]
 * 
 */
public class NumberPartition {

    /**
     * partition returns a list of int[] that represent all distinct partitions of n.
     */
    public  List<List<Integer>> partition(int n) {
        List<Integer> partial = new ArrayList<Integer>();
        List<List<Integer>> partitions = new ArrayList<>();
        partition(n, partial, partitions);
        return partitions;
    }

    /**
     * If n=0, it copies the partial solution into the list of complete solutions.
     * Else, for all values i less than or equal to n, put i in the partial solution and partition the remainder n-i.
     */
    private void partition(int n, List<Integer> partial, List<List<Integer>> partitions) {
        //System.out.println("partition " + n + ", partial solution: " + partial);
        if (n == 0) {
            // Complete solution is held in 'partial' --> add it to list of solutions
            partitions.add(new ArrayList<>(partial));
        } else {
            // Iterate through all numbers i less than n.
            // Avoid duplicate solutions by ensuring that the partial array is always non-increasing
            for (int i=n; i>0; i--) {
                if (partial.isEmpty() || partial.get(partial.size()-1) >= i) {
                    partial.add(i);
                    partition(n-i, partial, partitions);
                    partial.remove(partial.size()-1);
                }
            }
        }
    }
    
    public static void main(String[] args) {
    	NumberPartition numberPartition=new NumberPartition();
    	List<List<Integer>> output= numberPartition.partition(5);
    	System.out.println(output);
    	
    	numberPartition=new NumberPartition();
    	output= numberPartition.partition(4);
    	System.out.println(output);
    }
}
