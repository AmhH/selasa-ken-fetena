package com.example.leet.october.week4;

import com.example.leet.util.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Minimum Depth of Binary Tree
 * Given a binary tree, find its minimum depth.
 *
 * The minimum depth is the number of nodes along the shortest path from the root node down to the nearest leaf node.
 *
 * Note: A leaf is a node with no children.
 *          3
 *        /  \
 *       9   20
 *          /  \
 *         15  7
 *
 * Example 1:
 * Input: root = [3,9,20,null,null,15,7]
 * Output: 2
 *
 * Example 2:
 * Input: root = [2,null,3,null,4,null,5,null,6]
 * Output: 5
 *
 *
 * Constraints:
 *
 * The number of nodes in the tree is in the range [0, 105].
 * -1000 <= Node.val <= 1000
 */
public class Day22 {

    public int minDepth(TreeNode root) {
        if(root == null) return 0;
        int left = minDepth(root.left);
        int right = minDepth(root.right);
        return (left == 0 || right == 0) ? left + right + 1: Math.min(left,right) + 1;
    }

    public int minDepth1(TreeNode root) {
        if(root == null)
            return 0;
        Queue<TreeNode> level = new LinkedList<>();
        level.add(root);
        int ht = 1;
        while(!level.isEmpty()) {
            int size = level.size();
            TreeNode temp;
            for(int i = 0; i < size; ++i) {
                temp = level.poll();
                if(temp.left == null && temp.right == null)
                    return ht;
                if(temp.left != null)
                    level.add(temp.left);
                if(temp.right != null)
                    level.add(temp.right);
            }
            ht++;
        }
        return ht;
    }
}
