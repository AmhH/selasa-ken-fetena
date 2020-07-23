package com.example.leet.july.week4;

import com.example.leet.util.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Binary Tree Zigzag Level Order Traversal
 * Given a binary tree, return the zigzag level order traversal of its nodes' values. (ie, from left to right, then
 * right to left for the next level and alternate between).
 *
 * For example:
 * Given binary tree [3,9,20,null,null,15,7],
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * return its zigzag level order traversal as:
 * [
 *   [3],
 *   [20,9],
 *   [15,7]
 * ]
 */
public class Day22 {

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if(root == null)
            return result;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        boolean inOrder = true;
        int size = 1;
        while (!q.isEmpty()){
            LinkedList<Integer> temp = new LinkedList<>();
            for (int i = 0; i < size; i++) {
                TreeNode node = q.poll();
                if(inOrder){
                    temp.addLast(node.val);
                }else {
                    temp.addFirst(node.val);
                }
                if(node.left !=  null)
                    q.add(node.left);
                if(node.right !=  null)
                    q.add(node.right);
            }


            result.add(temp);
            size = q.size();
            inOrder = !inOrder;

        }
        return result;
    }

    public static void main(String[] args) {
        TreeNode node = TreeNode.createTreeFromArray(new int[]{3, 9, 20, -1, -1, 15, 7});
        System.out.println(node);
    }

    class Solution {
        public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
            List<List<Integer>> resList = new ArrayList<>();

            zigzagLevelOrder(root, 0, resList);

            return resList;
        }

        private void zigzagLevelOrder(TreeNode node, int level, List<List<Integer>> resList) {
            if(node == null) {
                return;
            } else {
                if(resList.size() == level) {
                    resList.add(new LinkedList<>());
                }

                if(level % 2 == 0) {
                    ((LinkedList<Integer>)resList.get(level)).addLast(node.val);
                } else {
                    ((LinkedList<Integer>)resList.get(level)).addFirst(node.val);
                }

                zigzagLevelOrder(node.left, level + 1, resList);
                zigzagLevelOrder(node.right, level + 1, resList);
            }
        }
    }
}
