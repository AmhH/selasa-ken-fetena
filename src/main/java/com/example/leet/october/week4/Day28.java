package com.example.leet.october.week4;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Summary Ranges
 * You are given a sorted unique integer array nums.
 *
 * Return the smallest sorted list of ranges that cover all the numbers in the array exactly. That is, each element
 * of nums is covered by exactly one of the ranges, and there is no integer x such that x is in one of the ranges but
 * not in nums.
 *
 * Each range [a,b] in the list should be output as:
 *
 * "a->b" if a != b
 * "a" if a == b
 *
 *
 * Example 1:
 *
 * Input: nums = [0,1,2,4,5,7]
 * Output: ["0->2","4->5","7"]
 * Explanation: The ranges are:
 * [0,2] --> "0->2"
 * [4,5] --> "4->5"
 * [7,7] --> "7"
 * Example 2:
 *
 * Input: nums = [0,2,3,4,6,8,9]
 * Output: ["0","2->4","6","8->9"]
 * Explanation: The ranges are:
 * [0,0] --> "0"
 * [2,4] --> "2->4"
 * [6,6] --> "6"
 * [8,9] --> "8->9"
 * Example 3:
 *
 * Input: nums = []
 * Output: []
 * Example 4:
 *
 * Input: nums = [-1]
 * Output: ["-1"]
 * Example 5:
 *
 * Input: nums = [0]
 * Output: ["0"]
 *
 *
 * Constraints:
 *
 * 0 <= nums.length <= 20
 * -231 <= nums[i] <= 231 - 1
 * All the values of nums are unique.
 */
public class Day28 {

    public static List<String> summaryRanges(int[] nums) {
        int length = nums.length;
        List<String> result = new LinkedList<>();
        for (int i = 0; i < length; i++) {
            int num = nums[i];
            while (i < length - 1 && nums[i] + 1 == nums[i + 1]) {
                i++;
            }
            if (num != nums[i]) {
                result.add(num + "->" + nums[i]);
            } else {
                result.add(num + "");
            }
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(summaryRanges(new int[]{0,1,2,4,5,7}));//["0->2","4->5","7"]
        System.out.println(summaryRanges(new int[]{0,2,3,4,6,8,9}));//["0","2->4","6","8->9"]
        System.out.println(summaryRanges(new int[]{}));//[]
        System.out.println(summaryRanges(new int[]{-1}));//["-1"]
        System.out.println(summaryRanges0(new int[]{0}));//["0"]
    }

    public static List<String> summaryRanges0(int[] nums) {
        List<String> list = new ArrayList<>();
        if(null == nums || nums.length == 0)
            return list;
        boolean arrowInserted = false;
        int prev = nums[0];
        StringBuilder str = new StringBuilder();
        str.append(prev);
        for(int i = 1; i < nums.length; i++) {
            if(prev + 1 == nums[i]) {
                if(arrowInserted == false) {
                    str.append("->");
                    arrowInserted = true;
                }
            } else {
                if(arrowInserted)
                    str.append(prev);
                list.add(str.toString());
                str = new StringBuilder();
                str.append(nums[i]);
                arrowInserted = false;
            }
            prev = nums[i];
        }
        if(arrowInserted)
            str.append(prev);
        list.add(str.toString());
        return list;
    }
}
