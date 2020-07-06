package com.example.leet.july.week1;

import java.util.Arrays;

/**
 * Plus One
 * Given a non-empty array of digits representing a non-negative integer, plus one to the integer.
 *
 * The digits are stored such that the most significant digit is at the head of the list, and each element in the
 * array contain a single digit.
 *
 * You may assume the integer does not contain any leading zero, except the number 0 itself.
 *
 * Example 1:
 *
 * Input: [1,2,3]
 * Output: [1,2,4]
 * Explanation: The array represents the integer 123.
 * Example 2:
 *
 * Input: [4,3,2,1]
 * Output: [4,3,2,2]
 * Explanation: The array represents the integer 4321.
 */
public class Day6 {

    public int[] plusOne(int[] digits) {
        if(digits == null || digits.length == 0 || (digits[0] == 0 && digits.length == 1))
            return new int[]{1};
        int curr = 1;
        for (int i = digits.length - 1; i >= 0; i--) {
            int temp = digits[i] + curr;
            curr = temp / 10;
            digits[i] = temp % 10;
        }

        if(curr == 0)
            return digits;
        int[] newDigit = new int[digits.length + 1];
        System.arraycopy(digits, 0, newDigit, 1, digits.length);
        newDigit[0] = curr;
        return newDigit;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Day6().plusOne(new int[]{1,2,3})));
        System.out.println(Arrays.toString(new Day6().plusOne(new int[]{4,3,2,1})));
        System.out.println(Arrays.toString(new Day6().plusOne(new int[]{9,9,9})));
    }

    class Solution {
        public int[] plusOne(int[] digits) {
            if(digits == null || digits.length == 0 || (digits[0] == 0 && digits.length == 1))
                return new int[]{1};
            boolean keepAdding = true;

            for(int i = digits.length - 1; i > 0 && keepAdding; i--){
                if(digits[i] != 9){
                    keepAdding = false;
                    digits[i]++;
                } else{
                    digits[i] = 0;
                }
            }
            if(keepAdding){
                if(digits[0] == 9){
                    int[] ret = new int[digits.length+1];
                    ret[0] = 1;
                    return ret;
                }else{
                    digits[0]++;
                }
            }
            return digits;
        }
    }
}
