package com.example.leet.may.week3;

import com.example.leet.util.TreeNode;

/**
 * Kth Smallest Element in a BST
 * Given a binary search tree, write a function kthSmallest to find the kth smallest element in it.
 *
 * Example 1:
 *
 * Input: root = [3,1,4,null,2], k = 1
 *    3
 *   / \
 *  1   4
 *   \
 *    2
 * Output: 1
 * Example 2:
 *
 * Input: root = [5,3,6,2,4,null,null,1], k = 3
 *        5
 *       / \
 *      3   6
 *     / \
 *    2   4
 *   /
 *  1
 * Output: 3
 *
 * Follow up:
 * What if the BST is modified (insert/delete operations) often and you need to find the kth smallest frequently?
 * How would you optimize the kthSmallest routine?
 *
 * Constraints:
 *
 * The number of elements of the BST is between 1 to 10^4.
 * You may assume k is always valid, 1 ≤ k ≤ BST's total elements.
 *    Hide Hint #1
 * Try to utilize the property of a BST.
 *    Hide Hint #2
 * Try in-order traversal. (Credits to @chan13)
 *    Hide Hint #3
 * What if you could modify the BST node's structure?
 *    Hide Hint #4
 * The optimal runtime complexity is O(height of BST).
 */
public class Day20 {

    int count, ans;
    public int kthSmallest(TreeNode root, int k) {
        count = k;
        inOrderTraverse(root);

        return ans;
    }

    private void inOrderTraverse(TreeNode root) {
        if(root == null)
            return;
        inOrderTraverse(root.left);
        count--;
        if(count == 0) {
            ans = root.val;
            return;
        }

        inOrderTraverse(root.right);
    }


    public static void main(String[] args) {
        TreeNode t1 = new TreeNode(1);
        TreeNode t2 = new TreeNode(2);
        TreeNode t3 = new TreeNode(3);
        TreeNode t4 = new TreeNode(4);
        TreeNode t5 = new TreeNode(5);
        TreeNode t6 = new TreeNode(6);

        t5.left = t3;
        t5.right = t6;
        t3.left = t2;
        t3.right = t4;
        t2.left = t1;

        System.out.println(new Day20().kthSmallest(t3, 3));

    }

}
