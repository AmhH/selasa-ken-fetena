package com.example.leet.october.week5;

/**
 * Number of Longest Increasing Subsequence
 * Given an integer array nums, return the number of longest increasing subsequences.
 *
 *
 * Example 1:
 *
 * Input: nums = [1,3,5,4,7]
 * Output: 2
 * Explanation: The two longest increasing subsequences are [1, 3, 4, 7] and [1, 3, 5, 7].
 * Example 2:
 *
 * Input: nums = [2,2,2,2,2]
 * Output: 5
 * Explanation: The length of longest continuous increasing subsequence is 1, and there are 5 subsequences' length is
 * 1, so output 5.
 *
 *
 *
 * Constraints:
 *
 * 0 <= nums.length <= 2000
 * -106 <= nums[i] <= 106
 */
public class Day30 {

    public static int findNumberOfLIS(int[] nums) {

    }

    public static void main(String[] args) {
        System.out.println(findNumberOfLIS(new int[]{1,3,5,4,7}));//2
        System.out.println(findNumberOfLIS(new int[]{2,2,2,2,2}));//5
    }
}
