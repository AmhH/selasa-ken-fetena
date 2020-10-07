package com.example.leet.october.week1;

import com.example.leet.util.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Insert into a Binary Search Tree
 * You are given the root node of a binary search tree (BST) and a value to insert into the tree. Return the root
 * node of the BST after the insertion. It is guaranteed that the new value does not exist in the original BST.
 *
 * Notice that there may exist multiple valid ways for the insertion, as long as the tree remains a BST after
 * insertion. You can return any of them.
 *
 * Example 1:
 *        4           ====>            4
 *      /  \                        /   \
 *    2    7                       2     7
 *   / \                         /  \   /
 *  1  3                        1   3  5
 *
 * Input: root = [4,2,7,1,3], val = 5
 * Output: [4,2,7,1,3,5]
 * Explanation: Another accepted tree is:
 *        5
 *       / \
 *      2   7
 *     / \
 *    1  3
 *        \
 *         4
 *
 * Example 2:
 *
 * Input: root = [40,20,60,10,30,50,70], val = 25
 * Output: [40,20,60,10,30,50,70,null,null,25]
 * Example 3:
 *
 * Input: root = [4,2,7,1,3,null,null,null,null,null,null], val = 5
 * Output: [4,2,7,1,3,5]
 *
 *
 * Constraints:
 *
 * The number of nodes in the tree will be in the range [0, 104].
 * -108 <= Node.val <= 108
 * All the values Node.val are unique.
 * -108 <= val <= 108
 * It's guaranteed that val does not exist in the original BST.
 */
public class Day6 {

    public static TreeNode insertIntoBST(TreeNode root, int val) {
        if (root == null) {
            return new TreeNode(val);
        } else if (val > root.val) {
            root.right = insertIntoBST(root.right, val);
        } else {
            root.left = insertIntoBST(root.left, val);
        }
        return root;
    }

    public static void main(String[] args) {
        System.out.println(print(insertIntoBST(TreeNode.createTreeFromArray(new Integer[]{4,2,7,1,3}), 5)));
        System.out.println(print(insertIntoBST(TreeNode.createTreeFromArray(new Integer[]{40,20,60,10,30,50,70}), 25)));
        System.out.println(print(insertIntoBST(TreeNode.createTreeFromArray(new Integer[]{4,2,7,1,3}), 5)));
    }

    private static String print(TreeNode root) {
        StringBuilder builder = new StringBuilder(root.val).append(" ");
        Queue<TreeNode> q = new LinkedList<>();

        q.offer(root);
        while (!q.isEmpty()){
            TreeNode node = q.poll();
            if(null != node.left){
                builder.append(node.left.val).append(" ");
                q.offer(node.left);
            }
            if(null != node.right){
                builder.append(node.right.val).append(" ");
                q.offer(node.right);
            }
        }

        return builder.toString();
    }
}
