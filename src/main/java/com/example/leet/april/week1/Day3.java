package com.example.leet.april.week1;

/**
 * Maximum Subarray
 * Given an integer array nums, find the contiguous subarray (containing at least one number) which has the largest
 * absoluteSum and return its absoluteSum.
 * <p>
 * Example:
 * <p>
 * Input: [-2,1,-3,4,-1,2,1,-5,4],
 * Output: 6
 * Explanation: [4,-1,2,1] has the largest absoluteSum = 6.
 * Follow up:
 * <p>
 * If you have figured out the O(n) solution, try coding another solution using the divide and conquer approach,
 * which is more subtle.
 */
public class Day3 {

    public static int maxSubArray(int[] nums) {
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            int temp = 0;
            for (int j = i; j < nums.length; j++) {
                temp += nums[j];
                if (temp > max) {
                    max = temp;
                }
            }
        }

        return max;
    }

    static int maxSubArraySum(int a[]) {
        int size = a.length;
        int max_so_far = Integer.MIN_VALUE, max_ending_here = 0;

        for (int i = 0; i < size; i++) {
            max_ending_here = max_ending_here + a[i];
            if (max_so_far < max_ending_here)
                max_so_far = max_ending_here;
            if (max_ending_here < 0)
                max_ending_here = 0;
        }
        return max_so_far;
    }

    static int maxSubArraySum2(int nums[]) {
        int max = nums[0];
        int current = nums[0];

        for (int i = 1; i < nums.length; i++) {
            current = Math.max(nums[i], current + nums[i]);
            max = Math.max(max, current);
        }
        return max;
    }

    public static int maxSubArrayBetter(int[] nums) {
        if (nums.length == 0) return 0;
        if (nums.length == 1) return nums[0];
        return dfs(nums, 0, nums.length - 1);
    }

    public static int dfs(int[] nums, int left, int right) {
        if (left >= right) return nums[left];
        int mid = left + (right - left) / 2;
        int L = dfs(nums, left, mid - 1);
        int R = dfs(nums, mid + 1, right);
        int t = nums[mid];
        int max = t;
        for (int i = mid - 1; i >= left; i--) {
            t += nums[i];
            max = Math.max(t, max);
        }
        t = max;
        for (int i = mid + 1; i <= right; i++) {
            t += nums[i];
            max = Math.max(t, max);
        }
        int M = max;
        return Math.max(Math.max(L, R), M);
    }

    public static void main(String[] args) {
      /*  System.out.println(maxSubArray(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4}));
        System.out.println(maxSubArray(new int[]{-2, -3, 4, -1, -2, 1, 5, -3}));
        System.out.println(maxSubArraySum(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4}));
        System.out.println(maxSubArraySum(new int[]{-2, -3, 4, -1, -2, 1, 5, -3}));
        System.out.println("*****************");
        System.out.println(maxSubArraySum2(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4}));
        System.out.println(maxSubArraySum2(new int[]{-2, -3, 4, -1, -2, 1, 5, -3}));

        System.out.println(maxSubArrayBetter(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4}));*/
        System.out.println(maxSubArrayBetter(new int[]{-2, -3, 4, -1, -2, 1, 5, -3}));
    }
}
