package com.example.leet.july.week4;

import com.example.leet.util.TreeNode;

import java.util.Stack;

/**
 * Construct Binary Tree from Inorder and Postorder Traversal
 * Given inorder and postorder traversal of a tree, construct the binary tree.
 *
 * Note:
 * You may assume that duplicates do not exist in the tree.
 *
 * For example, given
 *
 * inorder = [9,3,15,20,7]
 * postorder = [9,15,7,20,3]
 * Return the following binary tree:
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 */
public class Day27 {

    public static TreeNode buildTree(int[] inorder, int[] postorder) {

        return buildTree(inorder, inorder.length - 1, 0, postorder, postorder.length - 1);
    }

    private static TreeNode buildTree(int[] inorder, int inStart, int inEnd, int[] postorder, int postStart) {
        if(postStart < 0 || inEnd > inStart)
            return null;

        TreeNode root = new TreeNode(postorder[postStart]);
        int index = inStart;
        for (int i = inStart; i >= inEnd; i--) {
            if(inorder[i] == postorder[postStart]){
                index = i;
                break;
            }
        }

        root.right = buildTree(inorder, inStart, index + 1, postorder, postStart -1);
        root.left = buildTree(inorder, index - 1, inEnd,  postorder, postStart - (inStart - index) -1);

        return root;
    }

    public static void main(String[] args) {
        System.out.println(buildTree(new int[]{9,3,15,20,7}, new int[]{9,15,7,20,3}));
    }

    public TreeNode buildTreeIetrative(int[] inorder, int[] postorder) {
        if (inorder == null || inorder.length < 1) return null;
        int i = inorder.length - 1;
        int p = i;
        TreeNode node;
        TreeNode root = new TreeNode(postorder[postorder.length - 1]);
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        p--;

        while (true) {
            if (inorder[i] == stack.peek().val) { // inorder[i] is on top of stack, pop stack to get its parent to get to left side
                if (--i < 0) break;
                node = stack.pop();
                if (!stack.isEmpty() && inorder[i] == stack.peek().val) {// continue pop stack to get to left side
                    continue;
                }
                node.left = new TreeNode(postorder[p]);
                stack.push(node.left);
            } else { // inorder[i] is not on top of stack, postorder[p] must be right child
                node = new TreeNode(postorder[p]);
                stack.peek().right = node;
                stack.push(node);
            }
            p--;
        }

        return root;
    }
}
