package com.example.leet.july.week1;

/**
 * Arranging Coins
 *
 * You have a total of n coins that you want to form in a staircase shape, where every k-th row must have exactly k
 * coins.
 *
 * Given n, find the total number of full staircase rows that can be formed.
 *
 * n is a non-negative integer and fits within the range of a 32-bit signed integer.
 *
 * Example 1:
 *
 * n = 5
 *
 * The coins can form the following rows:
 * ¤
 * ¤ ¤
 * ¤ ¤
 *
 * Because the 3rd row is incomplete, we return 2.
 * Example 2:
 *
 * n = 8
 *
 * The coins can form the following rows:
 * ¤
 * ¤ ¤
 * ¤ ¤ ¤
 * ¤ ¤
 *
 * Because the 4th row is incomplete, we return 3.
 */
public class Day1 {

    public int arrangeCoins(int n) {
        int count = 0;
        int i = 1;
        while(n >= i){
            n -= i;
            count++;
            i++;
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(new Day1().arrangeCoins(5));
        System.out.println(new Day1().new Solution().arrangeCoins(8));
    }

    class Solution {
        public int arrangeCoins(int n) {
            int left = 0;
            int right = n;
            long k;

            long curr;
            while (left <= right) {
                k =(int)(left + (right - left) / 2);
                curr = k * (k + 1) / 2;

                if (curr == n) return (int)k;

                if (n < curr) {
                    right = (int)k - 1;
                } else {
                    left = (int)k + 1;
                }
            }
            return right;
        }
    }

    /**
     * https://leetcode.com/articles/arranging-coins/
     */
    class Solution2 {
        public int arrangeCoins(int n) {
            return (int)(Math.sqrt(2 * (long)n + 0.25) - 0.5);
        }
    }
}
