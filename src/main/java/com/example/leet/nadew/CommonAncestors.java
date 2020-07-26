package com.example.leet.nadew;

import com.example.leet.util.TreeNode;

/**
 * First Common Ancestor: Design an algorithm and write code to find the first common ancestor of two nodes in a binary
 * tree. Avoid storing additional nodes in a data structure. NOTE: this is not necessarily a binary search tree.
 */
public class CommonAncestors {

    public TreeNode commonAncestor(TreeNode root, TreeNode first, TreeNode second){
        if(!covers(root, first) || !covers(root, second))
            return null;
        return commonAncestorHelper(root, first, second);
    }

    private boolean covers(TreeNode root, TreeNode node) {
        if(root == null)
            return false;
        if(root == node)
            return true;
        return covers(root.left, node) || covers(root.right, node);
    }

    private TreeNode commonAncestorHelper(TreeNode root, TreeNode first, TreeNode second) {
        if(root == null || root == first || root == second){
            return root;
        }

        boolean firstLeft = covers(root.left, first);
        boolean secondLeft = covers(root.left, second);
        if(firstLeft != secondLeft)
            return root;
        TreeNode child = firstLeft ? root.left : root.right;
        return commonAncestorHelper(child, first, second);
    }

}
