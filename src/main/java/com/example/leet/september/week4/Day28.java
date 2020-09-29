package com.example.leet.september.week4;

/**
 * Subarray Product Less Than K
 * Your are given an array of positive integers nums.
 *
 * Count and print the number of (contiguous) subarrays where the product of all the elements in the subarray is less
 * than k.
 *
 * Example 1:
 * Input: nums = [10, 5, 2, 6], k = 100
 * Output: 8
 * Explanation: The 8 subarrays that have product less than 100 are: [10], [5], [2], [6], [10, 5], [5, 2], [2, 6],
 * [5, 2, 6].
 * Note that [10, 5, 2] is not included as the product of 100 is not strictly less than k.
 * Note:
 *
 * 0 < nums.length <= 50000.
 * 0 < nums[i] < 1000.
 * 0 <= k < 10^6.
 *    Hide Hint #1
 * For each j, let opt(j) be the smallest i so that nums[i] * nums[i+1] * ... * nums[j] is less than k. opt is an
 * increasing function.
 */
public class Day28 {

    public static int numSubarrayProductLessThanK(int[] nums, int k) {
        if (k <= 1) return 0;
        int product = 1;
        int result = 0;
        int l = 0;
        for (int i = 0; i < nums.length; i++) {
            product *= nums[i];
            while (product >= k) {
                product /= nums[l++];
            }
            result += i - l + 1;
        }
        return result;
    }

    public static int numSubarrayProductLessThanK1(int[] nums, int k) {
        int res = 0;
        int start = 0;
        int prod = 1;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] >= k) {
                start = i + 1;
                prod = 1;
            } else {
                prod *= nums[i];
                while (prod >= k ) {
                    prod /= nums[start];
                    start++;
                }
                res += i - start + 1;
            }
        }
        return res;
    }
    public static void main(String[] args) {
        System.out.println(numSubarrayProductLessThanK(new int[]{10, 5, 2, 6}, 100));//[5, 2, 6]
        System.out.println(numSubarrayProductLessThanK1(new int[]{10, 5, 2, 6}, 100));//[5, 2, 6]
    }
}
