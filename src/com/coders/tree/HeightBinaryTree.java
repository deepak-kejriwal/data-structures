package com.coders.tree;

/**
* 
* @author Deepak Kejriwal
*
*/
/*
 * 
 Given a binary tree, write a method to find its height recursively.
An empty tree has a height of 0.

Example:  
     1
    / \
   2   3     ==> height=3
  / \ / \
 4  5 6  7
 
       20                                  
    /     \                              
   15     30 
  /  \      \  height ==> 4                    
 14  18     35
    /  \    /
   17  19  32
 */
public class HeightBinaryTree {

	public static void main(String[] args) {
		TreeNode<Integer> node32=new TreeNode<Integer>(32);
		TreeNode<Integer> node35=new TreeNode<Integer>(35);
		node35.left=node32;
		TreeNode<Integer> node30=new TreeNode<Integer>(30);
		node30.right=node35;		
		TreeNode<Integer> root=new TreeNode<Integer>(20);
		root.right=node30;
		TreeNode<Integer> node17=new TreeNode<Integer>(17);
		TreeNode<Integer> node19=new TreeNode<Integer>(19);
		TreeNode<Integer> node18=new TreeNode<Integer>(18);
		node18.left=node17;
		node18.right=node19;
		TreeNode<Integer> node14=new TreeNode<Integer>(14);
		TreeNode<Integer> node15=new TreeNode<Integer>(15);
		node15.left=node14;
		node15.right=node18;
		root.left=node15;
		System.out.println(new HeightBinaryTree().findHeight(root));
	}
	public int findHeight(TreeNode<Integer> root) { 
	    
		if(root==null) return 0;

		return 1+Math.max(findHeight(root.left),findHeight(root.right));

		}
}
