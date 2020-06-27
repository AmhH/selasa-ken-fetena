package com.example.leet.june.week4;

/**
 * Perfect Squares
 * Given a positive integer n, find the least number of perfect square numbers (for example, 1, 4, 9, 16, ...) which
 * sum to n.
 *
 * Example 1:
 *
 * Input: n = 12
 * Output: 3
 * Explanation: 12 = 4 + 4 + 4.
 * Example 2:
 *
 * Input: n = 13
 * Output: 2
 * Explanation: 13 = 4 + 9.
 * https://www.youtube.com/watch?v=dOOzOsfj31I
 */
public class Day27 {

    public static int numSquares(int n) {
        int[] dp = new int[n+1];
        for (int i = 1; i <= n; i++) {
            int min = i;
            int j = 1;
            int square = 1;
            while (square <= i){
                min = Math.min(min, 1 + dp[i-square]);
                j++;
                square = j * j;
            }
            dp[i] = min;
        }
        return dp[n];
    }

    public static void main(String[] args) {
        System.out.println(numSquares(12));
        System.out.println(numSquares(13));
    }

    class Solution {

        protected boolean isSquare(int n) {
            int sq = (int) Math.sqrt(n);
            return n == sq * sq;
        }

        public int numSquares(int n) {
            // four-square and three-square theorems.
            while (n % 4 == 0)
                n /= 4;
            if (n % 8 == 7)
                return 4;

            if (this.isSquare(n))
                return 1;
            // enumeration to check if the number can be decomposed into sum of two squares.
            for (int i = 1; i * i <= n; ++i) {
                if (this.isSquare(n - i * i))
                    return 2;
            }
            // bottom case of three-square theorem.
            return 3;
        }
    }
}
