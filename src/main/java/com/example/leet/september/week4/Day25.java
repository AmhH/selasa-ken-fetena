package com.example.leet.september.week4;

import java.util.Arrays;

/**
 * Largest Number
 * Given a list of non negative integers, arrange them such that they form the largest number.
 *
 * Example 1:
 *
 * Input: [10,2]
 * Output: "210"
 * Example 2:
 *
 * Input: [3,30,34,5,9]
 * Output: "9534330"
 * Note: The result may be very large, so you need to return a string instead of an integer.
 */
public class Day25 {

    public static String largestNumber(int[] nums) {
        String[] strArray = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            strArray[i] = String.valueOf(nums[i]);
        }

        Arrays.sort(strArray, (a, b) -> (b+a).compareTo(a+b));

        if (strArray[0].equals("0")) {
            return "0";
        }

        String largest = new String();
        for (String numAsStr : strArray) {
            largest += numAsStr;
        }

        return largest;
    }

    public static void main(String[] args) {
        System.out.println(largestNumber(new int[]{10,2}));//210
        System.out.println(largestNumber(new int[]{3,30,34,5,9}));//9534330
    }
}
