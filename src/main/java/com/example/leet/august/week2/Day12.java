package com.example.leet.august.week2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Pascal's Triangle II
 * Given a non-negative index k where k ≤ 33, return the kth index row of the Pascal's triangle.
 *
 * Note that the row index starts from 0.
 *
 * In Pascal's triangle, each number is the sum of the two numbers directly above it.
 *
 * Example:
 *
 * Input: 3
 *      1
 *     1 1
 *    1 2 1
 *   1 3 3 1
 *  1 4 6 4 1
 * 1 5 10 10 5 1
 * Output: [1,3,3,1]
 *
 * Follow up:
 *
 * Could you optimize your algorithm to use only O(k) extra space?
 */
public class Day12 {
    public static List<Integer> getRow(int rowIndex) {
        List<Integer> res = new ArrayList<>();
        for(int i = 0;i<rowIndex+1;i++) {
            res.add(1);
            for(int j=i-1;j>0;j--) {
                res.set(j, res.get(j-1)+res.get(j));
            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(getRow(3));
        System.out.println(getRow(7));
        System.out.println(getRow2(3));
        System.out.println(getRow2(7));
    }

    public static List<Integer> getRow2(int rowIndex) {
        Integer[] result = new Integer[rowIndex + 1];
        Arrays.fill(result, 0);
        result[0] = 1;
        for (int i = 0; i <= rowIndex; i++) {
            for (int j = i; j > 0; j--) {
                result[j] += result[j - 1];
            }
        }
        return Arrays.asList(result);
    }
}
