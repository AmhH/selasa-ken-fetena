package com.example.leet.week1;

import java.util.Arrays;

/**
 * Move Zeroes
 * Given an array nums, write a function to move all 0's to the end of it while maintaining the relative order of
 * the non-zero elements.
 *
 * Example:
 *
 * Input: [0,1,0,3,12]
 * Output: [1,3,12,0,0]
 * Note:
 *
 * You must do this in-place without making a copy of the array.
 * Minimize the total number of operations.
 */
public class Day4 {

    public static void moveZeroes(int[] nums) {
        for(int i=0, nz=0; i < nums.length ; i++) {
            if (nums[i] != 0) {
                if (nz != i) {
                    nums[nz] = nums[i];
                    nums[i] = 0;
                }
                nz++;
            }
        }
    }

    public static void main(String[] args) {
        int[] nums1 = {0,1,0,3,12};
        int[] nums2 = {0,0,0,3,12,0,3};
        int[] nums3 = {5,1,6,3,12};
        int[] nums4 = {5,1,6,3,12,0,0};
        moveZeroes(nums1);
        System.out.println(Arrays.toString(nums1));
        moveZeroes(nums2);
        System.out.println(Arrays.toString(nums2));
        moveZeroes(nums3);
        System.out.println(Arrays.toString(nums3));
        moveZeroes(nums4);
        System.out.println(Arrays.toString(nums4));
        moveZeroes(nums4);
        System.out.println(Arrays.toString(nums4));

    }
}
