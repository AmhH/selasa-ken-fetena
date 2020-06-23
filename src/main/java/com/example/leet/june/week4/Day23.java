package com.example.leet.june.week4;

/**
 * Count Complete Tree Nodes
 * Given a complete binary tree, count the number of nodes.
 *
 * Note:
 *
 * Definition of a complete binary tree from Wikipedia:
 * In a complete binary tree every level, except possibly the last, is completely filled, and all nodes in the last
 * level are as far left as possible. It can have between 1 and 2h nodes inclusive at the last level h.
 *
 * Example:
 *
 * Input:
 *     1
 *    / \
 *   2   3
 *  / \  /
 * 4  5 6
 *
 * Output: 6
 */
public class Day23 {

    public static int countNodes(TreeNode root) {
        if(root == null)
            return 0;
        int l = countNodes(root.left);
        int r = countNodes(root.right);
        return l + r + 1;
    }

    public static int countNodes2(TreeNode root) {
        if (root == null) {
            return 0;
        }

        if (root.left == null && root.right == null) {
            return 1;
        } else if (root.left == null && root.right != null) {
            return 1 + countNodes(root.right);
        } else if (root.left != null && root.right == null) {
            return 1 + countNodes(root.left);
        } else {
            return 1 + countNodes(root.left) + countNodes(root.right);
        }
    }

    public static void main(String[] args) {
        TreeNode node2 = new TreeNode(2, new TreeNode(4), new TreeNode(5));
        TreeNode node3 = new TreeNode(3);
        TreeNode node6 = new TreeNode(6);
        node3.left = node6;
        TreeNode node1 = new TreeNode(2, node2, node3);

        System.out.println(countNodes(node1));
        System.out.println(countNodes2(node1));
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

}
