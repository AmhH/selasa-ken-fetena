package com.example.leet.nadew;

import com.example.leet.util.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Given two non-empty binary trees s and t, check whether tree t has exactly the same structure and node values with
 * a subtree of s. A subtree of s is a tree consists of a node in s and all of this node's descendants. The tree s
 * could also be considered as a subtree of itself.
 *
 * Example 1:
 * Given tree s:
 *
 *      3
 *     / \
 *    4   5
 *   / \
 *  1   2
 * Given tree t:
 *    4
 *   / \
 *  1   2
 * Return true, because t has the same structure and node values with a subtree of s.
 *
 *
 * Example 2:
 * Given tree s:
 *
 *      3
 *     / \
 *    4   5
 *   / \
 *  1   2
 *     /
 *    0
 * Given tree t:
 *    4
 *   / \
 *  1   2
 * Return false.
 *
 */
public class SameStructure {

    public boolean isSubtree(TreeNode s, TreeNode t) {
        return traverse(s,t);
    }

    private boolean equals(TreeNode x,TreeNode y) {
        if(x==null && y==null)
            return true;
        if(x==null || y==null)
            return false;
        return x.val==y.val && equals(x.left,y.left) && equals(x.right,y.right);
    }

    private boolean traverse(TreeNode s,TreeNode t) {
        return  s!=null && ( equals(s,t) || traverse(s.left,t) || traverse(s.right,t));
    }

    public static void main(String[] args) {
        TreeNode s = TreeNode.createTreeFromArray(new int[]{4, 4, 5, 1, 2});
        TreeNode t = TreeNode.createTreeFromArray(new int[]{4, 1,2});
        TreeNode s1 = TreeNode.createTreeFromArray(new int[]{3, 4, 5, 1, 2, 0, 0, 0, 0, 3, 0});

        System.out.println(new SameStructure().isSubtree(s, t));
        System.out.println(new SameStructure().isSubtree(s1, t));

        System.out.println("**************************");

        System.out.println(new SameStructure().isSubtree1(s, t));
        System.out.println(new SameStructure().isSubtree1(s1, t));
    }

    public boolean isSubtree1(TreeNode s, TreeNode t) {
        if(s == null || t == null) return s == t;
        return isSubtree1(s.left, t) || isSubtree1(s.right,t) || validate(s, t);
    }
    public boolean validate(TreeNode s, TreeNode t){
        if(s == null || t == null) return s == t;
        return (s.val == t.val) && validate(s.left, t.left) && validate(s.right, t.right);
    }
}
