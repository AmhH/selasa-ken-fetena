package com.example.leet.may.week5;

import java.util.Map;

/**
 * Edit Distance
 * Given two words word1 and word2, find the minimum number of operations required to convert word1 to word2.
 *
 * You have the following 3 operations permitted on a word:
 *
 * Insert a character
 * Delete a character
 * Replace a character
 * Example 1:
 *
 * Input: word1 = "horse", word2 = "ros"
 * Output: 3
 * Explanation:
 * horse -> rorse (replace 'h' with 'r')
 * rorse -> rose (remove 'r')
 * rose -> ros (remove 'e')
 * Example 2:
 *
 * Input: word1 = "intention", word2 = "execution"
 * Output: 5
 * Explanation:
 * intention -> inention (remove 't')
 * inention -> enention (replace 'i' with 'e')
 * enention -> exention (replace 'n' with 'x')
 * exention -> exection (replace 'n' with 'c')
 * exection -> execution (insert 'u')
 */
public class Day31 {

    public static int minDistance(String word1, String word2) {
        int M = word1.length();
        int N = word2.length();
        int dp[][] = new int[M + 1][N + 1];
        if (M * N == 0)
            return M + N;

        for (int i = 0; i <= M; i++) {
            dp[i][0] = i;
        }
        for (int i = 0; i <= N; i++) {
            dp[0][i] = i;
        }

        for (int i = 1; i <= M; i++) {
            for (int j = 1; j <= N; j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.min(dp[i - 1][j], Math.min(dp[i][j - 1], dp[i - 1][j - 1])) + 1;
                }
            }
        }
        return dp[M][N];
    }

    public static void main(String[] args) {
        System.out.println(minDistance("horse", "ros"));
        System.out.println(minDistance("intention", "execution"));
    }

    public int minDistance2(String word1, String word2) {
        int n = word1.length();
        int m = word2.length();
        if (n == 0 || m == 0) {
            return Math.max(n, m);
        }
        int[] dp = new int[n+1];
        for (int i = 0; i <= n; i++) {
            dp[i] = n - i;
        }
        for (int i = m - 1; i >= 0; i--) {
            int rightMost = m - i;
            for (int j = n - 1; j >= 0; j--) {
                int ops = 0;
                if (word1.charAt(j) != word2.charAt(i)) {
                    ops = Math.min(rightMost, dp[j+1]);
                    ops = Math.min(ops, dp[j]);
                    ops += 1;
                } else {
                    ops = dp[j+1];
                }
                dp[j+1] = rightMost;
                rightMost = ops;
            }
            dp[0] = rightMost;
        }
        return dp[0];
    }

    /**
     * 2ms
     */
    class Solution{
        char[] w1, w2;
        int[][] memo;
        public int minDistance(String word1, String word2){
            w1 = word1.toCharArray();
            w2 = word2.toCharArray();
            memo = new int[w1.length][w2.length];

            return f(w1.length -1, w2.length -1);
        }

        private int f(int i, int j) {
            if(i < 0) return j + 1;
            if(j < 0) return i + 1;
            if(memo[i][j] > 0)
                return memo[i][j];
            if(w1[i] == w2[j])
                return memo[i][j] = f(i - 1, j - 1);
            return memo[i][j] = 1 + Math.min(Math.min(f(i - 1, j), f(i, j - 1)), f(i -1, j - 1));
        }
    }
}
