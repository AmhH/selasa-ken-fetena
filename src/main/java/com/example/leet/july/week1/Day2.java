package com.example.leet.july.week1;

import java.util.LinkedList;
import java.util.List;

/**
 *  Binary Tree Level Order Traversal II
 * Given a binary tree, return the bottom-up level order traversal of its nodes' values. (ie, from left to right,
 * level by level from leaf to root).
 *
 * For example:
 * Given binary tree [3,9,20,null,null,15,7],
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * return its bottom-up level order traversal as:
 * [
 *   [15,7],
 *   [9,20],
 *   [3]
 * ]
 */
public class Day2 {

    public List<List<Integer>> levelOrderBottom (TreeNode root) {

        List<List<Integer>> ans = new LinkedList<>();
        helper (root, 0, ans);
        return ans;
    }

    private void helper (TreeNode root, int depth, List<List<Integer>> ans) {

        if (root == null) {
            return;
        }
        else if (depth == ans.size ()) {
            ans.add (0, new LinkedList<> ());
        }
        ans.get (ans.size () - depth - 1).add (root.val);
        helper (root.left, depth + 1, ans);
        helper (root.right, depth + 1, ans);
    }


    /**
     * Definition for a binary tree node.
     */
      public class TreeNode {
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
