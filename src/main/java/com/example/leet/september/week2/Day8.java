package com.example.leet.september.week2;

import com.example.leet.util.TreeNode;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

/**
 * Sum of Root To Leaf Binary Numbers
 * Given a binary tree, each node has value 0 or 1.  Each root-to-leaf path represents a binary number starting with
 * the most significant bit.  For example, if the path is 0 -> 1 -> 1 -> 0 -> 1, then this could represent 01101 in
 * binary, which is 13.
 *
 * For all leaves in the tree, consider the numbers represented by the path from the root to that leaf.
 *
 * Return the sum of these numbers.
 *
 * Example 1:
 *
 * Input: [1,0,1,0,1,0,1]
 * Output: 22
 * Explanation: (100) + (101) + (110) + (111) = 4 + 5 + 6 + 7 = 22
 *
 *
 * Note:
 *
 * The number of nodes in the tree is between 1 and 1000.
 * node.val is 0 or 1.
 * The answer will not exceed 2^31 - 1.
 *    Hide Hint #1
 * Find each path, then transform that path to an integer in base 10.
 */
public class Day8 {

    public static int sumRootToLeaf(TreeNode root) {
        List<String> numbers = new LinkedList<>();
        collectBinary(root, new StringBuilder(), numbers);
        int sum = 0;
        for (String num : numbers)
            sum += base2To10(num);
        return sum;
    }

    private static int base2To10(String num) {
        int baseTen = 0;
        int length = num.length();
        for (int i = 0; i < length; i++) {
            baseTen = baseTen + Character.getNumericValue(num.charAt(i)) * (int)Math.pow(2, length - i - 1);
        }
        return baseTen;
    }

    private static void collectBinary(TreeNode root, StringBuilder current, List<String> numbers) {
        current.append(root.val);
        if(null == root.left && null == root.right){
            numbers.add(current.toString());
            current.deleteCharAt(current.length() - 1);
            return;
        }
        if(null != root.left){
            collectBinary(root.left, current, numbers);
        }
        if(null != root.right){
            collectBinary(root.right, current, numbers);
        }
        current.deleteCharAt(current.length() - 1);
    }

    public static void main(String[] args) {
        TreeNode root = TreeNode.createTreeFromArray(new Integer[]{1, 0, 1, 0, 1, 0, 1});
        TreeNode root2 = TreeNode.createTreeFromArray(new Integer[]{1, 1});
        TreeNode root3 = TreeNode.createTreeFromArray(new Integer[]{0,1,1});
        System.out.println(sumRootToLeaf(root));//22
        System.out.println(sumRootToLeaf(root2));//3
        System.out.println(sumRootToLeaf(root3));//2
    }
}
