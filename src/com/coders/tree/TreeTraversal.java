package com.coders.tree;
/**
 * 
 * @author Deepak Kejriwal
 *
 */
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class TreeTraversal {
    public List < Integer > inorderTraversal(TreeNode<Integer> root) {
        List < Integer > res = new ArrayList < > ();
        Stack < TreeNode<Integer> > stack = new Stack < > ();
        TreeNode<Integer> curr = root;
        while (curr != null || !stack.isEmpty()) {
            while (curr != null) {
                stack.push(curr);
                curr = curr.left;
            }
            curr = stack.pop();
            res.add(curr.data);
            curr = curr.right;
        }
        return res;
    }
}
