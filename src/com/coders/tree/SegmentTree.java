package com.coders.tree;

import java.util.Arrays;

public class SegmentTree {

	int[] A;
	int[] tree;
	
	SegmentTree(int[] A){
		this.A = A;
		this.tree = new int[2*A.length-1];
		build(0, 0, A.length-1);
	}
	
	void build(int node, int start, int end)
	{
	    if(start == end)
	    {
	        // Leaf node will have a single element
	        tree[node] = A[start];
	    }
	    else
	    {
	        int mid = (start + end) / 2;
	        // Recurse on the left child
	        build(2*node+1, start, mid);
	        // Recurse on the right child
	        build(2*node+2, mid+1, end);
	        // Internal node will have the sum of both of its children
	        tree[node] = tree[2*node+1] + tree[2*node+2];
	    }
	}
	
	void update(int node, int start, int end, int idx, int val)
	{
	    if(start == end)
	    {
	        // Leaf node
	        A[idx] += val;
	        tree[node] += val;
	    }
	    else
	    {
	        int mid = (start + end) / 2;
	        if(start <= idx && idx <= mid)
	        {
	            // If idx is in the left child, recurse on the left child
	            update(2*node, start, mid, idx, val);
	        }
	        else
	        {
	            // if idx is in the right child, recurse on the right child
	            update(2*node+1, mid+1, end, idx, val);
	        }
	        // Internal node will have the sum of both of its children
	        tree[node] = tree[2*node+1] + tree[2*node+2];
	    }
	}
	
	int query(int node, int start, int end, int l, int r)
	{
	    if(r < start || end < l)
	    {
	        // range represented by a node is completely outside the given range
	        return 0;
	    }
	    if(l <= start && end <= r)
	    {
	        // range represented by a node is completely inside the given range
	        return tree[node];
	    }
	    // range represented by a node is partially inside and partially outside the given range
	    int mid = (start + end) / 2;
	    int p1 = query(2*node+1, start, mid, l, r);
	    int p2 = query(2*node+2, mid+1, end, l, r);
	    return (p1 + p2);
	}
	
	public static void main(String[] args) {
		int[] a = {1,2,3,4};
		SegmentTree st = new SegmentTree(a);
		System.out.println(Arrays.toString(st.tree));
	}

}
