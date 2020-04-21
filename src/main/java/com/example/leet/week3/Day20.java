package com.example.leet.week3;

/**
 *Construct Binary Search Tree from Preorder Traversal
 * Return the root node of a binary search tree that matches the given preorder traversal.
 *
 * (Recall that a binary search tree is a binary tree where for every node, any descendant of
 * node.left has a value < node.val, and any descendant of node.right has a value > node.val.
 * Also recall that a preorder traversal displays the value of the node first, then traverses
 * node.left, then traverses node.right.)
 *
 * Example 1:
 *
 * Input: [8,5,1,7,10,12]
 * Output: [8,5,10,1,7,null,12]
 *
 * Note:
 *
 * 1 <= preorder.length <= 100
 * The values of preorder are distinct.
 */
public class Day20 {

    public TreeNode bstFromPreorder(int[] preorder) {
        return preOrderTraverse(preorder, 0, preorder.length - 1);
    }

    private TreeNode preOrderTraverse(int[] preOrder, int start, int end) {
        if(start > end) return null;

        TreeNode node = new TreeNode(preOrder[start]);
        int i;
        for(i=start;i<=end;i++) {
            if(preOrder[i] > node.val)
                break;
        }

        node.left = preOrderTraverse(preOrder, start+1, i-1);
        node.right = preOrderTraverse(preOrder, i, end);
        return node;
    }

    /**
     * Definition for a binary tree node.
     * */
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}

