package com.example.leet.july.week4;

/**
 * Find Minimum in Rotated Sorted Array II
 * Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.
 *
 * (i.e.,  [0,1,2,4,5,6,7] might become  [4,5,6,7,0,1,2]).
 *
 * Find the minimum element.
 *
 * The array may contain duplicates.
 *
 * Example 1:
 *
 * Input: [1,3,5]
 * Output: 1
 * Example 2:
 *
 * Input: [2,2,2,0,1]
 * Output: 0
 * Note:
 *
 * This is a follow up problem to Find Minimum in Rotated Sorted Array.
 * Would allow duplicates affect the run-time complexity? How and why?
 */
public class Day25 {

    public static int findMin(int[] nums) {
        int min = nums[0];
        for (int val : nums) {
            if (min > val) {
                min = val;
            }
        }

        return min;
    }

    public static void main(String[] args) {
        System.out.println(findMin(new int[]{1,3,5}));
        System.out.println(findMin(new int[]{2,2,2,0,1}));
        System.out.println(findMin(new int[]{4,5,6,7,0,1,2}));
        System.out.println(findMin(new int[]{1,1}));
    }

    public int findMin1(int[] nums) {
        int lo =0;
        int n = nums.length;
        int hi = n-1;
        int min = nums[lo];
        while(lo<hi){
            while(lo <hi && lo <n-2 && nums[lo]==nums[lo+1] ){
                lo = lo+1;
            }
            while(lo<hi && hi >=1 && nums[hi]== nums[hi-1]){
                hi = hi-1;
            }
            int mid = lo +(hi-lo)/2;
            if(mid-1>=0 && mid+1<=n-1 && nums[mid]<nums[mid-1]&& nums[mid]>nums[mid+1]){
                return nums[mid];
            }
            if(nums[mid]<nums[hi]){
                hi = mid;
            } else {
                lo = mid+1;
            }


        }
        return nums[lo];

    }
}
