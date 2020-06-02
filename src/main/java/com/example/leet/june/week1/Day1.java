package com.example.leet.june.week1;

/**
 * Invert Binary Tree
 * Invert a binary tree.
 *
 * Example:
 *
 * Input:
 *
 *      4
 *    /   \
 *   2     7
 *  / \   / \
 * 1   3 6   9
 * Output:
 *
 *      4
 *    /   \
 *   7     2
 *  / \   / \
 * 9   6 3   1
 * Trivia:
 * This problem was inspired by this original tweet by Max Howell:
 *
 * Google: 90% of our engineers use the software you wrote (Homebrew), but you can’t invert a binary tree on a whiteboard so f*** off.
 */
public class Day1 {
    public static TreeNode invertTree(TreeNode root) {
        if(root == null)
            return root;
        TreeNode left = invertTree(root.left);
        TreeNode right = invertTree(root.right);

        root.left = right;
        root.right = left;

        return root;
    }


    /**
     * Definition for a binary tree node.
     */
      public static class TreeNode {
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

    public static void main(String[] args) {
        TreeNode t1 = new TreeNode(1);
        TreeNode t2 = new TreeNode(2);
        TreeNode t3 = new TreeNode(3);
        TreeNode t4 = new TreeNode(4);
        TreeNode t6 = new TreeNode(6);
        TreeNode t7 = new TreeNode(7);
        TreeNode t9 = new TreeNode(9);
        t4.left = t2;
        t4.right = t7;
        t2.left = t1;
        t2.right = t3;
        t7.left = t6;
        t7.right = t9;

        TreeNode treeNode = invertTree(t4);
        System.out.println(treeNode);

    }

}
