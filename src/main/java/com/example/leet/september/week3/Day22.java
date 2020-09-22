package com.example.leet.september.week3;

import java.util.ArrayList;
import java.util.List;

/**
 * Majority Element II
 * Given an integer array of size n, find all elements that appear more than ⌊ n/3 ⌋ times.
 *
 * Note: The algorithm should run in linear time and in O(1) space.
 *
 * Example 1:
 *
 * Input: [3,2,3]
 * Output: [3]
 * Example 2:
 *
 * Input: [1,1,1,3,3,2,2,2]
 * Output: [1,2]
 *    Hide Hint #1
 * How many majority elements could it possibly have?
 * Do you have a better hint? Suggest it!
 */
public class Day22 {
    public static List<Integer> majorityElement(int[] nums) {
        int c1 = 0;
        int c2 = 0;
        Integer candidate1 = null;
        Integer candidate2 = null;

        for (int i : nums){
            if(null != candidate1 && candidate1.equals(i)){
                c1++;
            }else if(null != candidate2 && candidate2.equals(i)){
                c2++;
            }else if(c1 == 0){
                candidate1 = i;
                c1++;
            }else if(c2 == 0){
                candidate2 = i;
                c2++;
            }else {
                c1--;
                c2--;
            }
        }

        List<Integer> list = new ArrayList<>();
        c1 = 0;
        c2 = 0;
        for (int i : nums){
            if(null != candidate1 && candidate1.equals(i)) c1++;
            if(null != candidate2 && candidate2.equals(i)) c2++;
        }

        int n = nums.length;
        if (c1 > n/3) list.add(candidate1);
        if (c2 > n/3) list.add(candidate2);

        return list;
    }

    public static void main(String[] args) {
        System.out.println(majorityElement(new int[]{3,2,3}));//[3]
        System.out.println(majorityElement(new int[]{1,1,1,3,3,2,2,2}));//[1,2]
        System.out.println(majorityElement(new int[]{1,2}));//[1,2]
    }
}
