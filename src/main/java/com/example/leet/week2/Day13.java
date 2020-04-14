package com.example.leet.week2;

import java.util.HashMap;
import java.util.Map;

/**
 * Contiguous Array
 * Given a binary array, find the maximum length of a contiguous subarray with equal number of 0 and 1.
 *
 * Example 1:
 * Input: [0,1]
 * Output: 2
 * Explanation: [0, 1] is the longest contiguous subarray with equal number of 0 and 1.
 * Example 2:
 * Input: [0,1,0]
 * Output: 2
 * Explanation: [0, 1] (or [1, 0]) is a longest contiguous subarray with equal number of 0 and 1.
 * Note: The length of the given binary array will not exceed 50,000.
 */
public class Day13 {
    /**
     * Naive solution, try every combination of lengths and positions in the array, save the max. This triggers the
     * TimeLimit and fails:
     */

    public int findMaxLength1(int[] nums) {
        int nZeros;
        int nOnes;
        int maxLength = 0;
        for(int i=0; i<nums.length; i++) {
            nZeros=0;
            nOnes=0;
            for(int j=i; j<nums.length; j++) {
                if(nums[j] == 0)
                    nZeros++;
                else
                    nOnes++;
                if( nZeros == nOnes )
                    maxLength = Math.max(maxLength, nZeros*2 );
            }
        }
        return maxLength;
    }

    /**
     * Classic solution using HashMap. For every 1 we sum 1, for every 0 we sum -1. We keep every different sum we have
     * seen in a HashMap. If we ever see the current sum in the HashMap, it means that there were equal number of zeros
     * and ones in between the current index i and the index in the HashMap, because only the sum of the same number of
     * 1's and -1's would make the sum equal again. So the difference between those two indexes is a candidate for a max.
     */
    public int findMaxLength2(int[] nums) {
        int sum = 0;
        int max = 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i] == 0 ? -1 : 1;
            if(map.containsKey(sum))
                max = Math.max(max, i-map.get(sum));
            else
                map.put(sum, i);
        }
        return max;
    }

    /**
     * This is the answer your interviewer wants, and you can't get a better complexity than this, O(n).
     *
     * But you are competitive and this only gets a 20 ms better than 79%. How can we make it faster?
     *
     * Why use the "heavy" HashMap when the key can only go from - nums.length to nums.length (when all 0's or all 1's)
     * . Let's use an array, and map the negative sums to positive indexes.
     */
    public int findMaxLength(int[] nums) {
        int sum = 0;
        int max = 0;
        Integer[] map = new Integer[nums.length*2+1];
        map[nums.length] = -1;
        for (int i = 0; i < nums.length; i++) {
            int index = nums[i] == 0 ? nums.length - --sum : nums.length - ++sum;
            if(map[index] != null)
                max = Math.max(max, i- map[index]);
            else
                map[index] = i;
        }
        return max;
    }
}
