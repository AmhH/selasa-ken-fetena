package com.example.leet.august.week1;

import java.util.ArrayList;
import java.util.List;

/**
 * Find All Duplicates in an Array
 * Given an array of integers, 1 ≤ a[i] ≤ n (n = size of array), some elements appear twice and others appear once.
 *
 * Find all the elements that appear twice in this array.
 *
 * Could you do it without extra space and in O(n) runtime?
 *
 * Example:
 * Input:
 * [4,3,2,7,8,2,3,1]
 *
 * Output:
 * [2,3]
 */
public class Day6 {

    public static List<Integer> findDuplicates(int[] nums) {
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < nums.length; ++i) {
            int index = Math.abs(nums[i])-1;
            if (nums[index] < 0)
                res.add(Math.abs(index+1));
            nums[index] = -nums[index];
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(findDuplicates(new int[]{4,3,2,7,8,2,3,1}));
        System.out.println(findDuplicates1(new int[]{4,3,2,7,8,2,3,1}));
    }

    public static List<Integer> findDuplicates1(int[] nums) {
        int[] arr = new int[nums.length + 1];

        List<Integer> list = new ArrayList<>();
        for (int num : nums) {
            arr[num]++;
        }
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > 1)
                list.add(i);
        }
        return list;
    }
}
