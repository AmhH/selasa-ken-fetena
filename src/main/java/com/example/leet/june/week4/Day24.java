package com.example.leet.june.week4;

import java.util.HashMap;
import java.util.Map;

/**
 *  Unique Binary Search Trees
 * Given n, how many structurally unique BST's (binary search trees) that store values 1 ... n?
 *
 * Example:
 *
 * Input: 3
 * Output: 5
 * Explanation:
 * Given n = 3, there are a total of 5 unique BST's:
 *
 *    1         3     3      2      1
 *     \       /     /      / \      \
 *      3     2     1      1   3      2
 *     /     /       \                 \
 *    2     1         2                 3
 */
public class Day24 {
    Map<Integer, Integer> map = new HashMap();
    public int numTrees(int n) {
        if(n == 0 || n == 1)
            return 1;
        if(map.containsKey(n))
            return map.get(n);
        int count = 0;
        for(int i = 1; i <= n; i++)
            count += numTrees(i - 1) * numTrees(n - i);
        map.put(n, count);
        return map.get(n);
    }

    public static void main(String[] args) {
        System.out.println(new Day24().numTrees(3));
        System.out.println(new Day24().numTrees(4));
        long start = System.currentTimeMillis();
        System.out.println(new Day24().numTrees(19));
        System.out.println((System.currentTimeMillis()-start)/1000);
    }
}
