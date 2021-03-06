package com.example.leet.may.week2;

/**
 * Single Element in a Sorted Array
 * Solution
 * You are given a sorted array consisting of only integers where every element appears exactly twice, except for one element which appears exactly once. Find this single element that appears only once.
 *
 * Example 1:
 * Input: [1,1,2,3,3,4,4,8,8]
 * Output: 2
 *
 * Example 2:
 * Input: [3,3,7,7,10,11,11]
 * Output: 10
 *
 * Note: Your solution should run in O(log n) time and O(1) space.
 */
public class Day12 {

    public static int singleNonDuplicate(int[] nums) {
        int single = 0;
        for(int i : nums){
            single ^= i;
        }

        return single;
    }

    public static void main(String[] args) {
        System.out.println(singleNonDuplicate(new int[]{1,1,2,3,3,4,4,8,8}));//2
        System.out.println(singleNonDuplicate(new int[]{3,3,7,7,10,11,11}));//10
    }
}
