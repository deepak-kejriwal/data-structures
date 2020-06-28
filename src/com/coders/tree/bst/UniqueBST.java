package com.coders.tree.bst;
/**
 * 
 * @author Deepak Kejriwal
 *
 */
import java.util.LinkedList;
import java.util.List;

import com.coders.tree.TreeNode;

/*
 * 
 * 
Problem: Given an integer n, generate all structurally unique BST's (binary search trees) that store values 1 ... n.
 * 
 * 
 */
public class UniqueBST {
	public static int counter = 0;

	public static void main(String[] args) {
		new UniqueBST().solution();

	}

	private void solution() {
		List<TreeNode<Integer>> result = generateTrees(4);
		System.out.println("List Size: "+result.size()+" forLoopCount: "+counter);
		System.out.println(result);

	}

	public List<TreeNode<Integer>> generateTrees(int n) {
		if (n == 0)
			return new LinkedList<>();
		return generateTrees(1, n);
	}

	public List<TreeNode<Integer>> generateTrees(int start, int end) {
		List<TreeNode<Integer>> result = new LinkedList<>();
		if (start > end) {
			result.add(null);
			return result;
		}

		for (int val = start; val <= end; val++) {
			List<TreeNode<Integer>> left = generateTrees(start, val - 1);
			List<TreeNode<Integer>> right = generateTrees(val + 1, end);
			for (int i = 0; i < left.size(); i++) {
				for (int j = 0; j < right.size(); j++) {
					counter++;
					TreeNode<Integer> node = new TreeNode<>(val);
					node.left = left.get(i);
					node.right = right.get(j);
					result.add(node);
				}
			}
		}
		return result;
	}
}
