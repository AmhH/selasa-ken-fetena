package com.example.leet.august.week2;

import com.example.leet.util.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * Path Sum III
 * You are given a binary tree in which each node contains an integer value.
 * Find the number of paths that sum to a given value.
 *
 * The path does not need to start or end at the root or a leaf, but it must go downwards (traveling only from parent
 * nodes to child nodes).
 *
 * The tree has no more than 1,000 nodes and the values are in the range -1,000,000 to 1,000,000.
 *
 * Example:
 * root = [10,5,-3,3,2,null,11,3,-2,null,1], sum = 8
 *
 *       10
 *      /  \
 *     5   -3
 *    / \    \
 *   3   2   11
 *  / \   \
 * 3  -2   1
 *
 * Return 3. The paths that sum to 8 are:
 *
 * 1.  5 -> 3
 * 2.  5 -> 2 -> 1
 * 3. -3 -> 11
 */
public class Day8 {

    public int pathSum(TreeNode root, int sum) {
        if(root == null) {
            return 0;
        }
        return pathSumHelper(root, sum) + pathSum(root.left, sum) + pathSum(root.right, sum);
    }

    private int pathSumHelper(TreeNode root, int sum) {
        if(root == null) {
            return 0;
        }
        int s = pathSumHelper(root.left, sum-root.val) + pathSumHelper(root.right, sum-root.val);
        if(root.val == sum) {
            s++;
        }
        return s;
    }

    public int pathSum2(TreeNode root, int sum) {
        // prefixSum, numOccurrence
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);

        return dfs(root, sum, map, 0);
    }

    private int dfs(TreeNode curr, int target, Map<Integer, Integer> map, int sumSoFar) {
        if (curr == null) return 0;

        sumSoFar += curr.val;

        int res = map.getOrDefault(sumSoFar - target, 0);
        map.put(sumSoFar, map.getOrDefault(sumSoFar, 0) + 1);

        res += dfs(curr.left, target, map, sumSoFar) + dfs(curr.right, target, map, sumSoFar);
        map.put(sumSoFar, map.get(sumSoFar) - 1);

        return res;
    }

    public static void main(String[] args) {
        TreeNode node = TreeNode.createTreeFromArray(new int[]{10, 5, -3, 3, 2, 0, 11, 3, -2, 0, 1});
        System.out.println(new Day8().pathSum(node, 8));
        System.out.println(new Day8().pathSum2(node , 8));
    }
}
