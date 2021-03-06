package com.example.leet.april.week5;

import com.example.leet.util.TreeNode;

/**
 * Binary Tree Maximum Path Sum
 * Given a non-empty binary tree, find the maximum path absoluteSum.
 *
 * For this problem, a path is defined as any sequence of nodes from some starting node to any node in the tree along
 * the parent-child connections. The path must contain at least one node and does not need to go through the root.
 *
 * Example 1:
 *
 * Input: [1,2,3]
 *
 *        1
 *       / \
 *      2   3
 *
 * Output: 6
 * Example 2:
 *
 * Input: [-10,9,20,null,null,15,7]
 *
 *    -10
 *    / \
 *   9  20
 *     /  \
 *    15   7
 *
 * Output: 42
 */
public class Day29 {

    int max_sum;
    public int maxPathSum(TreeNode root) {
        max_sum = Integer.MIN_VALUE;
        max_gain(root);
        return max_sum;
    }

    int max_gain(TreeNode root){
        if(root == null){
            return 0;
        }

        int leftGain = Math.max(max_gain(root.left), 0);
        int rightGain = Math.max(max_gain(root.right), 0);
        int sum = root.val + leftGain + rightGain;
        max_sum = Math.max(max_sum, sum);
        return root.val + Math.max(leftGain, rightGain);
    }
}
