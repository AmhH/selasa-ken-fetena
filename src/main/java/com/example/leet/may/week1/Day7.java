package com.example.leet.may.week1;

/**
 * Cousins in Binary Tree
 * In a binary tree, the root node is at depth 0, and children of each depth k node are at depth k+1.
 *
 * Two nodes of a binary tree are cousins if they have the same depth, but have different parents.
 *
 * We are given the root of a binary tree with unique values, and the values x and y of two different nodes in the tree.
 *
 * Return true if and only if the nodes corresponding to the values x and y are cousins.
 *
 * Example 1:
 *
 * Input: root = [1,2,3,4], x = 4, y = 3
 * Output: false
 * Example 2:
 *
 * Input: root = [1,2,3,null,4,null,5], x = 5, y = 4
 * Output: true
 * Example 3:
 *
 * Input: root = [1,2,3,null,4], x = 2, y = 3
 * Output: false
 *
 * Note:
 *
 * The number of nodes in the tree will be between 2 and 100.
 * Each node has a unique integer value from 1 to 100.
 */
public class Day7 {

    public boolean isCousins(TreeNode root, int x, int y) {
        Pair pair1 = isCousinsHelper(root, x, null, 0);
        Pair pair2 = isCousinsHelper(root, y, null, 0);

        return pair1.level == pair2.level && pair1.parent != pair2.parent;

    }

    Pair isCousinsHelper(TreeNode root, int val, TreeNode parent, int level){
        if(root == null){
            return null;
        }
        if(root.val == val){
            return new Pair(parent, level);
        }
        Pair leftPair = isCousinsHelper(root.left, val, root, level + 1);
        Pair rightPair = isCousinsHelper(root.right, val, root, level + 1);
        return leftPair == null ? rightPair : leftPair;
    }

    class Pair{
        TreeNode parent;
        int level;

        Pair(TreeNode parent, int level){
            this.parent = parent;
            this.level = level;
        }
    }

    /**
     * Definition for a binary tree node.
     */
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}



