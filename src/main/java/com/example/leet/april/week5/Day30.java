package com.example.leet.april.week5;

/**
 * Check If a String Is a Valid Sequence from Root to Leaves Path in a Binary Tree
 * Given a binary tree where each path going from the root to any leaf form a valid sequence, check if a given string
 * is a valid sequence in such binary tree.
 *
 * We get the given string from the concatenation of an array of integers arr and the concatenation of all values of
 * the nodes along a path results in a sequence in the given binary tree.
 *
 * Example 1:
 *
 * Input: root = [0,1,0,0,1,0,null,null,1,0,0], arr = [0,1,0,1]
 * Output: true
 * Explanation:
 * The path 0 -> 1 -> 0 -> 1 is a valid sequence (green color in the figure).
 * Other valid sequences are:
 * 0 -> 1 -> 1 -> 0
 * 0 -> 0 -> 0
 * Example 2:
 *
 * Input: root = [0,1,0,0,1,0,null,null,1,0,0], arr = [0,0,1]
 * Output: false
 * Explanation: The path 0 -> 0 -> 1 does not exist, therefore it is not even a sequence.
 * Example 3:
 *
 * Input: root = [0,1,0,0,1,0,null,null,1,0,0], arr = [0,1,1]
 * Output: false
 * Explanation: The path 0 -> 1 -> 1 is a sequence, but it is not a valid sequence.
 *
 *
 * Constraints:
 *
 * 1 <= arr.length <= 5000
 * 0 <= arr[i] <= 9
 * Each node's value is between [0 - 9].
 *    Hide Hint #1
 * Depth-first search (DFS) with the parameters: current node in the binary tree and current position in the array of
 * integers.
 *    Hide Hint #2
 * When reaching at final position check if it is a leaf node.
 */
public class Day30 {

    public boolean isValidSequence(TreeNode root, int[] arr) {
        if(root == null){
            return arr.length == 0;
        }
        return isValid(root, arr, 0);
    }

    private boolean isValid(TreeNode root, int[] arr, int index) {
        if(root.val != arr[index]){
            return false;
        }
        if(index == arr.length - 1){
            return root.left == null && root.right == null;
        }

        return (root.left != null && isValid(root.left, arr, index+1)) ||
                (root.right != null && isValid(root.right, arr, index+1));

    }

    /**
     * Definition for a binary tree node.
     */ public class TreeNode {
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
