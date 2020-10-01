package com.example.leet.september.week5;

import java.util.HashSet;
import java.util.Set;

/**
 * First Missing Positive
 * Given an unsorted integer array, find the smallest missing positive integer.
 *
 * Example 1:
 *
 * Input: [1,2,0]
 * Output: 3
 * Example 2:
 *
 * Input: [3,4,-1,1]
 * Output: 2
 * Example 3:
 *
 * Input: [7,8,9,11,12]
 * Output: 1
 * Follow up:
 *
 * Your algorithm should run in O(n) time and uses constant extra space.
 *
 *    Hide Hint #1
 * Think about how you would solve the problem in non-constant space. Can you apply that logic to the existing space?
 *    Hide Hint #2
 * We don't care about duplicates or non-positive integers
 *    Hide Hint #3
 * Remember that O(2n) = O(n)
 */
public class Day30 {
    public static int firstMissingPositive(int[] nums) {
        int i = 0, n = nums.length;
        while (i < n) {
            // If the current value is in the range of (0,length) and it's not at its correct position,
            // swap it to its correct position.
            // Else just continue;
            if (nums[i] >= 0 && nums[i] < n && nums[nums[i]] != nums[i])
                swap(nums, i, nums[i]);
            else
                i++;
        }
        int k = 1;

        // Check from k=1 to see whether each index and value can be corresponding.
        while (k < n && nums[k] == k)
            k++;

        // If it breaks because of empty array or reaching the end. K must be the first missing number.
        if (n == 0 || k < n)
            return k;
        else   // If k is hiding at position 0, K+1 is the number.
            return nums[0] == k ? k + 1 : k;

    }

    private static void swap(int[] nums, int i, int j) {
        nums[i] = nums[j];
        nums[j] = j;
    }

    public static void main(String[] args) {
        System.out.println(firstMissingPositive(new int[]{1,2,0}));//3
        System.out.println(firstMissingPositive(new int[]{3,4,-1,1}));//2
        System.out.println(firstMissingPositive(new int[]{7,8,9,11,12}));//1
    }
}
