package com.example.leet.september.week1;

import com.example.leet.util.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * All Elements in Two Binary Search Trees
 * Given two binary search trees root1 and root2.
 *
 * Return a list containing all the integers from both trees sorted in ascending order.
 *
 * Example 1:
 *
 * Input: root1 = [2,1,4], root2 = [1,0,3]
 * Output: [0,1,1,2,3,4]
 * Example 2:
 *
 * Input: root1 = [0,-10,10], root2 = [5,1,7,0,2]
 * Output: [-10,0,0,1,2,5,7,10]
 * Example 3:
 *
 * Input: root1 = [], root2 = [5,1,7,0,2]
 * Output: [0,1,2,5,7]
 * Example 4:
 *
 * Input: root1 = [0,-10,10], root2 = []
 * Output: [-10,0,10]
 * Example 5:
 *
 * Input: root1 = [1,null,8], root2 = [8,1]
 * Output: [1,1,8,8]
 *
 * Constraints:
 *
 * Each tree has at most 5000 nodes.
 * Each node's value is between [-10^5, 10^5].
 *    Hide Hint #1
 * Traverse the first tree in list1 and the second tree in list2.
 *    Hide Hint #2
 * Merge the two trees in one list and sort it.
 */
public class Day5 {
    public static List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
        List<Integer> l1 = new ArrayList<>();
        List<Integer> l2 = new ArrayList<>();
        List<Integer> result = new ArrayList<>();
        inOrderTraversal(root1, l1);
        inOrderTraversal(root2, l2);
        int index1 = 0;
        int index2 = 0;
        while(index1 < l1.size() || index2 < l2.size()){
            if(index2 == l2.size() || index1 < l1.size() && l1.get(index1) <= l2.get(index2)){
                result.add(l1.get(index1));
                index1++;
            }else if (index2 < l2.size()){
                result.add(l2.get(index2));
                index2++;
            }
        }

        return result;
    }

    private static void inOrderTraversal(TreeNode root, List<Integer> list) {
        if(null == root)
            return;
        inOrderTraversal(root.left, list);
        list.add(root.val);
        inOrderTraversal(root.right, list);
    }

    public static void main(String[] args) {
        System.out.println(getAllElements(TreeNode.createTreeFromArray(new Integer[]{2,1,4}),
                TreeNode.createTreeFromArray(new Integer[]{1,0,3})));
        System.out.println(getAllElements(TreeNode.createTreeFromArray(new Integer[]{0,-10,10}),
                TreeNode.createTreeFromArray(new Integer[]{5,1,7,0,2})));
        System.out.println(getAllElements(TreeNode.createTreeFromArray(new Integer[]{}),
                TreeNode.createTreeFromArray(new Integer[]{5,1,7,0,2})));
        System.out.println(getAllElements(TreeNode.createTreeFromArray(new Integer[]{0,-10,10}),
                TreeNode.createTreeFromArray(new Integer[]{})));
        System.out.println(getAllElements(TreeNode.createTreeFromArray(new Integer[]{1,null,8}),
                TreeNode.createTreeFromArray(new Integer[]{8, 1})));
    }

}
