package com.example.leet.july.week2;

import java.util.ArrayList;
import java.util.List;

/**
 *  Subsets
 * Given a set of distinct integers, nums, return all possible subsets (the power set).
 *
 * Note: The solution set must not contain duplicate subsets.
 *
 * Example:
 *
 * Input: nums = [1,2,3]
 * Output:
 * [
 *   [3],
 *   [1],
 *   [2],
 *   [1,2,3],
 *   [1,3],
 *   [2,3],
 *   [1,2],
 *   []
 * ]
 *
 * https://leetcode.com/problems/subsets/solution/
 */
public class Day11 {
    final int x;
    {
        x = 10;
    }

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> output = new ArrayList<>();
        int n = nums.length;

        for (int i = (int)Math.pow(2, n); i < (int)Math.pow(2, n + 1); ++i) {

            String bitmask = Integer.toBinaryString(i).substring(1);

            List<Integer> curr = new ArrayList<>();
            for (int j = 0; j < n; ++j) {
                if (bitmask.charAt(j) == '1') curr.add(nums[j]);
            }
            output.add(curr);
        }
        return output;
    }

    public static void main(String[] args) {
        System.out.println(new Day11().subsets(new int[]{1,2,3}));
    }

    class Solution {
        public List<List<Integer>> subsets(int[] nums) {
            List<List<Integer>> ans=new ArrayList<>();
            genSubset(0,nums,new ArrayList<>(),ans);
            return ans;
        }

        public void genSubset(int index, int[]nums, List<Integer> curr, List<List<Integer>> ans){
            ans.add(new ArrayList<>(curr));
            for(int i=index;i<nums.length;i++){
                curr.add(nums[i]);
                genSubset(i+1,nums,curr,ans);
                curr.remove(curr.size()-1);
            }
        }
    }

}
