package com.example.leet.july.week2;

import com.example.leet.util.TreeNode;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Maximum Width of Binary Tree
 * Given a binary tree, write a function to get the maximum width of the given tree. The width of a tree is the
 * maximum width among all levels. The binary tree has the same structure as a full binary tree, but some nodes are
 * null.
 *
 * The width of one level is defined as the length between the end-nodes (the leftmost and right most non-null nodes
 * in the level, where the null nodes between the end-nodes are also counted into the length calculation.
 *
 * Example 1:
 *
 * Input:
 *
 *            1
 *          /   \
 *         3     2
 *        / \     \
 *       5   3     9
 *
 * Output: 4
 * Explanation: The maximum width existing in the third level with the length 4 (5,3,null,9).
 * Example 2:
 *
 * Input:
 *
 *           1
 *          /
 *         3
 *        / \
 *       5   3
 *
 * Output: 2
 * Explanation: The maximum width existing in the third level with the length 2 (5,3).
 * Example 3:
 *
 * Input:
 *
 *           1
 *          / \
 *         3   2
 *        /
 *       5
 *
 * Output: 2
 * Explanation: The maximum width existing in the second level with the length 2 (3,2).
 * Example 4:
 *
 * Input:
 *
 *           1
 *          / \
 *         3   2
 *        /     \
 *       5       9
 *      /         \
 *     6           7
 * Output: 8
 * Explanation:The maximum width existing in the fourth level with the length 8 (6,null,null,null,null,null,null,7).
 *
 *
 * Note: Answer will in the range of 32-bit signed integer.
 */
public class Day9 {
    public int widthOfBinaryTree(TreeNode root) {
        if (root == null) return 0;

        int maxWidth = 0;
        Queue<Pair<TreeNode, Integer>> queue = new LinkedList<>();
        queue.offer(new Pair(root, 0));
        while (!queue.isEmpty()) {
            Pair<TreeNode, Integer> first = queue.peek();
            int size = queue.size();
            Pair<TreeNode, Integer> curr = null;
            while (size-- > 0) {
                curr = queue.poll();
                TreeNode node = curr.key;
                int index = curr.value;
                if (node.left != null) queue.offer(new Pair(node.left, 2 * index));
                if (node.right != null) queue.offer(new Pair(node.right, 2 * index + 1));
            }
            maxWidth = Math.max(maxWidth, curr.value - first.value + 1);
        }
        return maxWidth;
    }

    public class Pair<A, M>{
        A key;
        M value;

        Pair(A key, M value){
            this.key = key;
            this.value = value;
        }
    }

    class Solution {
        private int max = 1;
        public int widthOfBinaryTree(TreeNode root) {
            if (root == null) return 0;
            List<Integer> startOfLevel = new LinkedList<>();
            helper(root, 0, 1, startOfLevel);
            return max;
        }
        public void helper(TreeNode root, int level, int index, List<Integer> list) {
            if (root == null) return;
            if (level == list.size()) list.add(index);
            max = Math.max(max, index + 1 - list.get(level));
            helper(root.left, level + 1, index * 2, list);
            helper(root.right, level + 1, index * 2 + 1, list);
        }
    }
    public static void main(String[] args) {

    }

}
