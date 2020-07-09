package com.example.leet.july.week2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *3Sum
 *
 * Solution
 * Given an array nums of n integers, are there elements a, b, c in nums such that a + b + c = 0? Find all unique
 * triplets in the array which gives the sum of zero.
 *
 * Note:
 *
 * The solution set must not contain duplicate triplets.
 *
 * Example:
 *
 * Given array nums = [-1, 0, 1, 2, -1, -4],
 *
 * A solution set is:
 * [
 *   [-1, 0, 1],
 *   [-1, -1, 2]
 * ]
 *    Hide Hint #1
 * So, we essentially need to find three numbers x, y, and z such that they add up to the given value. If we fix one
 * of the numbers say x, we are left with the two-sum problem at hand!
 *    Hide Hint #2
 * For the two-sum problem, if we fix one of the numbers, say
 * x
 * , we have to scan the entire array to find the next number
 * y
 * which is
 * value - x
 * where value is the input parameter. Can we change our array somehow so that this search becomes faster?
 *    Hide Hint #3
 * The second train of thought for two-sum is, without changing the array, can we use additional space somehow? Like
 * maybe a hash map to speed up the search?
 */
public class Day8 {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ret = new ArrayList<>();
        Arrays.sort(nums); //asc order

        for (int i=0; i < nums.length-2; i++)
        {
            if(nums[i] > 0 || (i > 0 && nums[i-1]==nums[i]))
                continue;
            int sum = 0 - nums[i];

            int lo=i+1;
            int hi = nums.length-1;
            while (lo<hi)
            {
                if (nums[lo] + nums[hi] > sum)
                {
                    hi--;
                }
                else if (nums[lo] + nums[hi] < sum)
                    lo++;
                else
                {
                    List<Integer> entry = new ArrayList<>();
                    entry.add(nums[i]);
                    entry.add(nums[lo++]);
                    entry.add(nums[hi--]);
                    ret.add(entry);
                    while (lo < nums.length && nums[lo] == nums[lo-1])
                        lo++;
                    while (hi >= 0 && nums[hi] == nums[hi+1])
                        hi--;
                }
            }

        }
        return ret;
    }

    public static void main(String[] args) {
        System.out.println(new Day8().threeSum(new int[]{-1, 0, 1, 2, -1, -4}));
    }
}
