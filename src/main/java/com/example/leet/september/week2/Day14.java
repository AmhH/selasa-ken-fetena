package com.example.leet.september.week2;

import java.util.Arrays;

/**
 * House Robber
 * You are a professional robber planning to rob houses along a street. Each house has a certain amount of money
 * stashed, the only constraint stopping you from robbing each of them is that adjacent houses have security system
 * connected and it will automatically contact the police if two adjacent houses were broken into on the same night.
 *
 * Given a list of non-negative integers representing the amount of money of each house, determine the maximum amount
 * of money you can rob tonight without alerting the police.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [1,2,3,1]
 * Output: 4
 * Explanation: Rob house 1 (money = 1) and then rob house 3 (money = 3).
 *              Total amount you can rob = 1 + 3 = 4.
 * Example 2:
 *
 * Input: nums = [2,7,9,3,1]
 * Output: 12
 * Explanation: Rob house 1 (money = 2), rob house 3 (money = 9) and rob house 5 (money = 1).
 *              Total amount you can rob = 2 + 9 + 1 = 12.
 *
 *
 * Constraints:
 *
 * 0 <= nums.length <= 100
 * 0 <= nums[i] <= 400
 */
public class Day14 {
    public static int rob(int[] nums) {
        int[] memo = new int[nums.length];
        Arrays.fill(memo, -1);
        return rob(nums, 0, memo);
    }

    private static int rob(int[] nums, int index, int[] memo) {
        if(index >= nums.length)
            return 0;
        if(memo[index] > -1)
            return memo[index];
        int with = nums[index] + rob(nums, index+2, memo);
        int withOut = rob(nums, index+1, memo);
        int max = Math.max(with, withOut);
        memo[index] = max;
        return max;
    }

    public static int rob0(int[] nums) {
        if(nums.length == 0) return 0;
        if(nums.length == 1) return nums[0];
        if(nums.length == 2) return Math.max(nums[0], nums[1]);

        int pMax = 0;
        int cMax = 0;
        for(int n = 0; n < nums.length; n++){
            int temp = cMax;
            cMax = Math.max(pMax + nums[n], cMax);
            pMax = temp;
        }

        return cMax;
    }

    public static void main(String[] args) {
        System.out.println(rob(new int[]{1,2,3,1}));//4
        System.out.println(rob(new int[]{2,7,9,3,1}));//12
        System.out.println(rob(new int[]{2,7,9,8,1}));//15
        System.out.println(rob(new int[]{2,1,1,2}));//4
        System.out.println(rob0(new int[]{2,1,1,2}));//4
    }
}
