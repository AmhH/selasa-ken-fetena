package com.example.leet.april.week4;

import java.util.HashMap;
import java.util.Map;

/**
 * Subarray Sum Equals K
 * Given an array of integers and an integer k, you need to find the total number of continuous subarrays whose absoluteSum
 * equals to k.
 *
 * Example 1:
 * Input:nums = [1,1,1], k = 2
 * Output: 2
 * Note:
 * The length of the array is in range [1, 20,000].
 * The range of numbers in the array is [-1000, 1000] and the range of the integer k is [-1e7, 1e7].
 *
 *    Hide Hint #1
 * Will Brute force work here? Try to optimize it.
 *
 *    Hide Hint #2
 * Can we optimize it by using some extra space?
 *
 *    Hide Hint #3
 * What about storing absoluteSum frequencies in a hash table? Will it be useful?
 *
 *    Hide Hint #4
 * absoluteSum(i,j)=absoluteSum(0,j)-absoluteSum(0,i), where absoluteSum(i,j) represents the absoluteSum of all the elements from index i to j-1. Can we use
 * this property to optimize it.
 */
public class Day22 {

        //Prefix Sum + Hash Table - O(n) time, O(n) space (37ms beats 40.49%)

        public static int subarraySum(int[] nums, int k) {
            if (nums == null || nums.length == 0){
                return 0;
            }
            int sum = 0;
            int count = 0;
            Map<Integer, Integer> map = new HashMap<>();
            map.put(0, 1);
            for (int i = 0; i < nums.length; i++) {
                sum += nums[i];
                if (map.containsKey(sum - k)) {
                    count += map.get(sum - k);
                }
                map.put(sum, map.getOrDefault(sum, 0) + 1);
            }
            return count;

        }

        //Another implementation - Prefix Sum + Hash Table - O(n) time, O(n)
        public static int subarraySum2(int[] nums, int k) {
            if (nums == null || nums.length == 0) return 0;
            int sum = 0;
            int count = 0;
            Map<Integer, Integer> map = new HashMap<>();
            for (int i = 0; i < nums.length; i++) {
                sum += nums[i];
                if (sum == k) {
                    count++;
                }
                if (map.containsKey(sum - k)) {
                    count += map.get(sum - k);
                }
                map.put(sum, map.getOrDefault(sum, 0) + 1);
            }
            return count;
        }

    public static void main(String[] args) {
        System.out.println(subarraySum(new int[]{1,1,1}, 2));
        System.out.println(subarraySum2(new int[]{1,1,1}, 2));
    }
}
