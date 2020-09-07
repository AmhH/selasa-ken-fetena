package com.example.leet.nadew;

import java.util.ArrayList;
import java.util.List;

/**
 * Generate all permutations of a given array. Return a list of all permutations
 *
 * E.g.  a = [1, 2, 3] => [[1,2,3], [1,3,2], [2,1,3], [2,3,1], [3, 1, 2], [3,2,1]]
 * https://leetcode.com/problems/permutations/discuss/18239/A-general-approach-to-backtracking-questions-in-Java-(Subsets-Permutations-Combination-Sum-Palindrome-Partioning)
 */
public class Permutation {

    public static List<List<Integer>> permute(int[] nums) {
        if (nums == null || nums.length == 0)
            return new ArrayList<>();

        List<List<Integer>> finalResult = new ArrayList<>();
        permute(nums, finalResult, new ArrayList<>(), new boolean[nums.length]);
        return finalResult;
    }

    private static void permute(int[] nums, List<List<Integer>> finalResult, List<Integer> currResult, boolean[] used) {

        if (currResult.size() == nums.length) {
            finalResult.add(new ArrayList<>(currResult));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (used[i])
                continue;
            currResult.add(nums[i]);
            used[i] = true;
            permute(nums, finalResult, currResult, used);
            used[i] = false;
            currResult.remove(currResult.size() - 1);
        }
    }

    public static void main(String[] args) {
        System.out.println(permute(new int[]{1, 2, 3}));
    }
}
