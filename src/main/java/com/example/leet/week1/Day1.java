package com.example.leet.week1;

/**
 * 1. Single Number
 * Given a non-empty array of integers, every element appears twice except for one. Find that single one.
 *
 * Note:
 * Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?
 * Example 1:
 * Input: [2,2,1]
 * Output: 1
 *
 * Example 2:
 * Input: [4,1,2,1,2]
 * Output: 4
 */
public class Day1 {

    public int singleNumber(int[] nums) {
        int res = nums[0];
        for (int i = 1; i < nums.length; i++)
            res = res ^ nums[i];

        return res;
    }

    public int singleNumber1(int[] nums) {
        int a = 0;
        for (int i : nums) {
            a ^= i;
        }
        return a;
    }

    public static void main(String[] args) {
        System.out.println(new Day1().singleNumber(new int[] {2,2,1}));
        System.out.println(new Day1().singleNumber(new int[] {4,1,2,1,2}));
        System.out.println(new Day1().singleNumber1(new int[] {2,2,1}));
        System.out.println(new Day1().singleNumber1(new int[] {4,1,2,1,2}));
    }
}
