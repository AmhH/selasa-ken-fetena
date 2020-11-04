package com.example.leet.october.week5;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Number of Longest Increasing Subsequence
 * Given an integer array nums, return the number of longest increasing subsequences.
 *
 *
 * Example 1:
 *
 * Input: nums = [1,3,5,4,7]
 * Output: 2
 * Explanation: The two longest increasing subsequences are [1, 3, 4, 7] and [1, 3, 5, 7].
 * Example 2:
 *
 * Input: nums = [2,2,2,2,2]
 * Output: 5
 * Explanation: The length of longest continuous increasing subsequence is 1, and there are 5 subsequences' length is
 * 1, so output 5.
 *
 *
 *
 * Constraints:
 *
 * 0 <= nums.length <= 2000
 * -106 <= nums[i] <= 106
 */
public class Day30 {

    public static int findNumberOfLIS(int[] nums) {
        int N = nums.length;
        if (N <= 1) return N;
        int[] lengths = new int[N]; //lengths[i] = length of longest ending in nums[i]
        int[] counts = new int[N]; //count[i] = number of longest ending in nums[i]
        Arrays.fill(counts, 1);

        for (int j = 0; j < N; ++j) {
            for (int i = 0; i < j; ++i) if (nums[i] < nums[j]) {
                if (lengths[i] >= lengths[j]) {
                    lengths[j] = lengths[i] + 1;
                    counts[j] = counts[i];
                } else if (lengths[i] + 1 == lengths[j]) {
                    counts[j] += counts[i];
                }
            }
        }

        int longest = 0, ans = 0;
        for (int length: lengths) {
            longest = Math.max(longest, length);
        }
        for (int i = 0; i < N; ++i) {
            if (lengths[i] == longest) {
                ans += counts[i];
            }
        }
        return ans;
    }

    public int findNumberOfLIS2(int[] nums) {
        int size = nums.length;
        if (size == 0) return 0;
        if (size == 1) return 1;

        List<int[]>[] lists = (List<int[]>[]) new ArrayList[size + 1];
        lists[1] = new ArrayList<>();
        lists[1].add(new int[]{nums[0], 1});

        int len = 1;
        for (int i = 1; i < size; i++) {
            int n  = nums[i];
            int l = 1, r = len + 1;
            while (l < r) {
                int mid = l + (r - l) / 2;
                List<int[]> curr = lists[mid];
                if (curr.get(curr.size() - 1)[0] >= n) {
                    r = mid;
                } else {
                    l = mid + 1;
                }
            }

            if (l - 1 == len) {
                lists[++len] = new ArrayList<>();
            }
            //System.out.println(l);
            int count = 0;
            if (l - 1 > 0) {
                List<int[]> pre = lists[l - 1];
                int hi = -1, lo = pre.size() - 1;
                while (lo > hi) {
                    int mi = lo + (hi - lo) / 2;
                    if (pre.get(mi)[0] >= n) {
                        hi = mi;
                    } else {
                        lo = mi - 1;
                    }
                }
                count = pre.get(pre.size() - 1)[1] - (lo >= 0 ? pre.get(lo)[1] : 0);
            } else count = 1;

            List<int[]> list = lists[l];
            count = count + (list.size() == 0 ? 0 : list.get(list.size() - 1)[1]);
            list.add(new int[]{n, count});
        }

        return lists[len].get(lists[len].size() - 1)[1];
    }

    public static void main(String[] args) {
        System.out.println(findNumberOfLIS(new int[]{1,3,5,4,7}));//2
        System.out.println(findNumberOfLIS(new int[]{2,2,2,2,2}));//5
    }
}
