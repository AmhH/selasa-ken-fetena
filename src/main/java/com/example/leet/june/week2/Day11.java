package com.example.leet.june.week2;

import java.util.Arrays;

/**
 *  Sort Colors
 * Given an array with n objects colored red, white or blue, sort them in-place so that objects of the same color are
 * adjacent, with the colors in the order red, white and blue.
 *
 * Here, we will use the integers 0, 1, and 2 to represent the color red, white, and blue respectively.
 *
 * Note: You are not suppose to use the library's sort function for this problem.
 *
 * Example:
 *
 * Input: [2,0,2,1,1,0]
 * Output: [0,0,1,1,2,2]
 * Follow up:
 *
 * A rather straight forward solution is a two-pass algorithm using counting sort.
 * First, iterate the array counting number of 0's, 1's, and 2's, then overwrite array with total number of 0's, then
 * 1's and followed by 2's.
 * Could you come up with a one-pass algorithm using only constant space?
 */
public class Day11 {

    public static void sortColors(int[] nums) {
        if(nums.length <= 1)
            return;
        int index = 0;
        int start = 0;
        int end = nums.length - 1;

        while(index <= end && start <= end){
            if(nums[index] == 0){
                nums[index] = nums[start];
                nums[start] = 0;
                index++;
                start++;
            }else if(nums[index] == 2){
                nums[index] = nums[end];
                nums[end] = 2;
                end--;
            }else{
                index++;
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = {2,0,2,1,1,0};
        int[] nums1 = {2,0,1};
        sortColors(nums);
        sortColors2(nums1);
        System.out.println(Arrays.toString(nums));
        System.out.println(Arrays.toString(nums1));
    }

    public static void sortColors2(int[] nums) {
        int i = 0;
        int left = -1;
        int right = nums.length ;
        while(i < right) {

            if(nums[i] == 0) {
                left++;
                swap(nums, i, left);
                i++;
            }
            else if(nums[i] == 2) {
                right--;
                swap(nums, i, right);
            }
            else
                i++;

        }
    }
    public static void swap(int[ ] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
