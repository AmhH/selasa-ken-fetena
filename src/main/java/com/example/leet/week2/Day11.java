package com.example.leet.week2;

/**
 * Diameter of Binary Tree
 * Given a binary tree, you need to compute the length of the diameter of the tree. The diameter of a binary tree is the length of the longest path between any two nodes in a tree. This path may or may not pass through the root.
 *
 * Example:
 * Given a binary tree
 *           1
 *          / \
 *         2   3
 *        / \
 *       4   5
 * Return 3, which is the length of the path [4,2,1,3] or [5,2,1,3].
 *
 * Note: The length of path between two nodes is represented by the number of edges between them.
 * Check this: https://www.rajkambo.com/leetcoding-challenge-day-11/
 */
public class Day11 {

    int maxDiameter = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        findDepth(root);
        return maxDiameter;
    }
    private int findDepth(TreeNode root){
        if(root == null)
            return -1;
        int left = findDepth(root.left);
        int right = findDepth(root.right);
        int depth = Math.max(left,right)+1;
        int diameter = left+right+2;
        maxDiameter = Math.max(maxDiameter,diameter);
        return depth;
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    int diameter = 0;
    public int diameterOfBinaryTree2(TreeNode root) {
        dfs(root);
        return diameter;
    }

    int dfs(TreeNode node){
        if(node == null)
            return 0;
        int l = dfs(node.left);
        int r = dfs(node.right);
        diameter = Math.max(diameter, l+r);
        return Math.max(l, r)+1;
    }
}
