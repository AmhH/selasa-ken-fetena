package com.example.leet.october.week2;

/**
 * Binary Search
 * Given a sorted (in ascending order) integer array nums of n elements and a target value, write a function to
 * search target in nums. If target exists, then return its index, otherwise return -1.
 *
 *
 * Example 1:
 *
 * Input: nums = [-1,0,3,5,9,12], target = 9
 * Output: 4
 * Explanation: 9 exists in nums and its index is 4
 *
 * Example 2:
 *
 * Input: nums = [-1,0,3,5,9,12], target = 2
 * Output: -1
 * Explanation: 2 does not exist in nums so return -1
 *
 *
 * Note:
 *
 * You may assume that all elements in nums are unique.
 * n will be in the range [1, 10000].
 * The value of each element in nums will be in the range [-9999, 9999].
 */
public class Day8 {
    public static int search(int[] nums, int target) {
        return search(nums, target, 0, nums.length - 1);
    }

    private static int search(int[] nums, int target, int left, int right) {
        int mid = (right - left)/ 2 + left;
        if(target == nums[mid])
            return mid;
        if(target == nums[left])
            return left;
        if(target == nums[right])
            return right;
        if(target < nums[mid] && target > nums[left])
            return search(nums, target, left, mid);
        if (target  > nums[mid] && target < nums[right])
            return search(nums, target, mid + 1, right);
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(search(new int[]{-1,0,3,5,9,12}, 9));
        System.out.println(search2(new int[]{-1,0,3,5,9,12}, 2));
        System.out.println(search2(new int[]{0,5}, 5));
    }

    public static int search2(int[] nums, int target) {

        int l = 0, r = nums.length - 1;
        int result = -1;

        while( l <= r ) {
            int mid = l + (r - l)/2;
            if(nums[mid] < target) {
                l = mid + 1;
            }else if(nums[mid] == target){
                result = mid;
                return result;
            }else {
                r = mid - 1;
            }
        }
        return result;
    }
}
