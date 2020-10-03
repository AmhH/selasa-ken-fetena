package com.example.leet.october.week1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * Combination Sum
 * Given an array of distinct integers candidates and a target integer target, return a list of all unique
 * combinations of candidates where the chosen numbers sum to target. You may return the combinations in any order.
 *
 * The same number may be chosen from candidates an unlimited number of times. Two combinations are unique if the
 * frequency of at least one of the chosen numbers is different.
 *
 *
 *
 * Example 1:
 *
 * Input: candidates = [2,3,6,7], target = 7
 * Output: [[2,2,3],[7]]
 * Explanation:
 * 2 and 3 are candidates, and 2 + 2 + 3 = 7. Note that 2 can be used multiple times.
 * 7 is a candidate, and 7 = 7.
 * These are the only two combinations.
 * Example 2:
 *
 * Input: candidates = [2,3,5], target = 8
 * Output: [[2,2,2,2],[2,3,3],[3,5]]
 * Example 3:
 *
 * Input: candidates = [2], target = 1
 * Output: []
 * Example 4:
 *
 * Input: candidates = [1], target = 1
 * Output: [[1]]
 * Example 5:
 *
 * Input: candidates = [1], target = 2
 * Output: [[1,1]]
 *
 *
 * Constraints:
 *
 * 1 <= candidates.length <= 30
 * 1 <= candidates[i] <= 200
 * All elements of candidates are distinct.
 * 1 <= target <= 500
 */
public class Day2 {

    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new LinkedList<>();
        Arrays.sort(candidates);
        backTrack(result, new LinkedList<>(), candidates, target, 0);
        return result;
    }

    private static void backTrack(List<List<Integer>> result, List<Integer> temp, int[] candidates, int target,
                                  int index) {
        if(target == 0){
            result.add(new LinkedList<>(temp));
            return;
        }

        for (int i = index; i < candidates.length; i++) {
            if(candidates[i] > target)
                break;
            temp.add(candidates[i]);
            backTrack(result, temp, candidates, target - candidates[i], i);
            temp.remove(temp.size() - 1);
        }
    }

    public static void main(String[] args) {
        System.out.println(combinationSum(new int[]{2,3,6,7}, 7));//[[2,2,3],[7]]
        System.out.println(combinationSum(new int[]{2,3,5}, 8));//[[2,2,2,2],[2,3,3],[3,5]]
        System.out.println(combinationSum(new int[]{2}, 1));//[]
        System.out.println(combinationSum(new int[]{1}, 1));//[[1]]
        System.out.println(combinationSum(new int[]{1}, 2));//[[1,1]]
    }
}
