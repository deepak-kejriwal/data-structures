package com.coders.dynamicprogramming;

/**
* 
* @author Deepak Kejriwal
*
*/
/*
 * 
 You're given a game board that has m x n squares on it, represented by an m x n array. Write a method - countPaths that takes in m and n and returns the number of possible paths from the top left corner to the bottom right corner. Only down and right directions of movement are permitted. 

Note: 
Your method should output the result in a reasonable amount of time for large values of m and n. If you're thinking of using DFS, consider the tree depth and branching factor for m and n > 15!

m = number of rows, n = number of columns

Example:  
countPaths(m = 2, n = 2) => 2

as on the following 2x2 Board, the two paths are A->C->D and A->B->D

A B
C D
 * 
 */
public class CountPathOnGameBoard {

	public static void main(String[] args) {
		System.out.println(new CountPathOnGameBoard().countPaths(3, 3));

	}
	public int[][] memo=null;//new int[m+1][n+1];

	public  int countPaths(int m, int n){
	    if(m==1 || n==1) {
	    return 1;
	    }
	    memo=new int[m+1][n+1];
	    return countPathsWithMemo(m,n);
	}

	public  int countPathsWithMemo(int m, int n){
	    
	    if(m==1 || n==1) return 1;
	    int x=0;
	    int y=0;
	    if(memo[m-1][n]!=0){
	        x=memo[m-1][n];
	    }else{
	        x=countPathsWithMemo(m-1, n);
	        memo[m-1][n]=x;
	    }
	    if(memo[m][n-1]!=0){
	        y=memo[m][n-1];
	    }else{
	        y=countPathsWithMemo(m, n-1);
	        memo[m][n-1]=y;
	    }
	    return x+y;
	}
}
