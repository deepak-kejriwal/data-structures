package com.coders.tree;

/**
* 
* @author Deepak Kejriwal
*
*/
/*
 * 
 Given a BST, write a function to return its diameter. The diameter of a Binary Tree is defined as the "Number of nodes on the longest path between two leaf nodes".

Example:  
      20                                  
    /     \                              
   15     30 
  /  \      \  diameter ==> 7                    
 14  18     35
    /  \    /
   17  19  32
 * 
 */
public class MaxDiameterTree {

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
		System.out.println(new MaxDiameterTree().diameter(root));
	}
	public int diameter(TreeNode<Integer> root) {
	    if(root==null) return 0;
	    return heightAndDiameter(root).diameter;
	}

	public HeightDiameter heightAndDiameter(TreeNode<Integer> root){
	    if(root==null) return new HeightDiameter(0,0);
	    HeightDiameter left=heightAndDiameter(root.left);
	    HeightDiameter right=heightAndDiameter(root.right);
	    int diameter=Math.max(Math.max(left.diameter,right.diameter),left.height+right.height+1);
	    return new HeightDiameter(Math.max(left.height,right.height)+1,diameter);
	}

	class HeightDiameter{
	    int height;
	    int diameter;
	    
	    HeightDiameter(int height,int diameter){
	        this.height=height;
	        this.diameter=diameter;
	    }
	}
}
