package com.example.leet.august.week4;

import com.example.leet.util.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Sum of Left Leaves
 * Find the sum of all left leaves in a given binary tree.
 *
 * Example:
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 *
 * There are two left leaves in the binary tree, with values 9 and 15 respectively. Return 24.
 */
public class Day24 {
    public static int sumOfLeftLeaves(TreeNode root) {
        if(null == root){
            return 0;
        }
        int sum = 0;
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while (!q.isEmpty()){
            TreeNode node = q.poll();
            if(null != node.left && (null == node.left.left && null == node.left.right)){
                sum += node.left.val;
            }else if(null != node.left){
                q.offer(node.left);
            }
            if(null != node.right){
                q.offer(node.right);
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        TreeNode root = TreeNode.createTreeFromArray(new int[]{3, 9, 20, 0, 0, 15, 7});
        root.left.left = null;
        root.left.right = null;
        System.out.println(sumOfLeftLeaves(root));
        System.out.println(sumOfLeftLeaves1(root));
    }

    public static int sumOfLeftLeaves1(TreeNode root) {
        int[] sum = new int[1];
        sumOfLeftLeaves(root, sum, false);
        return sum[0];
    }

    private static void sumOfLeftLeaves(TreeNode root, int[] sum, boolean left) {
        if(null == root)
            return;
        else if(left && null == root.left  && null == root.right){
            sum[0] += root.val;
        }else {
            sumOfLeftLeaves(root.left, sum, true);
            sumOfLeftLeaves(root.right, sum, false);
        }
    }
}
