package com.example.leet.june.week4;

/**
 * Single Number II
 * Given a non-empty array of integers, every element appears three times except for one, which appears exactly once.
 * Find that single one.
 *
 * Note:
 *
 * Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?
 *
 * Example 1:
 *
 * Input: [2,2,3,2]
 * Output: 3
 * Example 2:
 *
 * Input: [0,1,0,1,0,1,99]
 * Output: 99
 */
public class Day22 {

    public static int singleNumber(int[] nums) {
        int ones = 0, twos = 0, not_threes;
        for(int n : nums) {
            twos |= (ones & n);
            ones ^= n;
            not_threes = ~(ones & twos);
            ones &= not_threes;
            twos &= not_threes;
        }

        return ones;
    }

    public static void main(String[] args) {
        System.out.println(singleNumber(new int[]{2,2,3,2}));
        System.out.println(singleNumber(new int[]{0,1,0,1,0,1,99}));
    }
}
