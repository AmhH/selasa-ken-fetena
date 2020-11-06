package com.example.leet.october.week5;

import com.example.leet.util.TreeNode;

/**
 * Recover Binary Search Tree
 *
 * Solution
 * You are given the root of a binary search tree (BST), where exactly two nodes of the tree were swapped by mistake.
 * Recover the tree without changing its structure.
 *
 * Follow up: A solution using O(n) space is pretty straight forward. Could you devise a constant space solution?
 *
 * Example 1:
 *      1           3
 *     /           /
 *    3      =>   1
 *     \           \
 *     2            2
 *
 * Input: root = [1,3,null,null,2]
 * Output: [3,1,null,null,2]
 * Explanation: 3 cannot be a left child of 1 because 3 > 1. Swapping 1 and 3 makes the BST valid.
 * Example 2:
 *      3                2
 *    /  \             /  \
 *   1    4    =>    1     4
 *       /                /
 *      2                3
 *
 * Input: root = [3,1,4,null,null,2]
 * Output: [2,1,4,null,null,3]
 * Explanation: 2 cannot be in the right subtree of 3 because 2 < 3. Swapping 2 and 3 makes the BST valid.
 *
 *
 * Constraints:
 *
 * The number of nodes in the tree is in the range [2, 1000].
 * -231 <= Node.val <= 231 - 1
 */
public class Day31 {
    private TreeNode prev;
    private TreeNode wrong1;
    private TreeNode wrong2;

    public void recoverTree(TreeNode root) {
        inOrder(root);

        int val = wrong1.val;
        wrong1.val = wrong2.val;
        wrong2.val = val;
    }

    private void inOrder(TreeNode root) {
        if(null == root)
            return;
        inOrder(root.left);

        if(null != prev && prev.val > root.val){
            if(null == wrong1)
                wrong1 = prev;
            wrong2 = root;
        }
        prev = root;
        inOrder(root.right);
    }
}
