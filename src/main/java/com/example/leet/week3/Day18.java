package com.example.leet.week3;

/**
 * Minimum Path Sum
 * Given a m x n grid filled with non-negative numbers, find a path from top left to bottom right which minimizes the sum of all numbers along its path.
 *
 * Note: You can only move either down or right at any point in time.
 *
 * Example:
 *
 * Input:
 * [
 *   [1,3,1],
 *   [1,5,1],
 *   [4,2,1]
 * ]
 * Output: 7
 * Explanation: Because the path 1→3→1→1→1 minimizes the sum.
 */
public class Day18 {

    public static int minPathSum(int[][] grid) {
        int row = grid.length;
        if(row == 0) return 0;
        int column = grid[0].length;

        for(int i=1;i<row;i++) {
            grid[i][0]+=grid[i-1][0];
        }
        for(int i=1;i<column;i++) {
            grid[0][i]+=grid[0][i-1];
        }
        for(int i=1;i<row;i++){
            for(int j=1; j<column;j++) {
                grid[i][j] += Math.min(grid[i-1][j], grid[i][j-1]);
            }
        }
        return grid[row-1][column-1];
    }

    public int minPathSum2(int[][] grid) {
        if(grid == null || grid.length == 0) return 0;
        int m = grid.length;
        int n = grid[0].length;
        int[][] dp = new int[m][n];
        dp[0][0] = grid[0][0];
        for(int j = 1; j < n; j++)
            dp[0][j] = dp[0][j-1] + grid[0][j];
        for(int i = 1; i < m; i++)
            dp[i][0] = dp[i-1][0] + grid[i][0];
        for(int i = 1; i < m; i++){
            for(int j = 1; j < n; j++){
                dp[i][j] = Math.min(dp[i-1][j], dp[i][j-1]) + grid[i][j];
            }
        }
        return dp[m-1][n-1];
    }

    public int minPathSum3(int[][] grid) {
        if(grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }

        int m = grid.length, n = grid[0].length;
        int[] dp = new int[n + 1];

        // row 0, dp[0] 不用单独赋值 就是一开始的0就行
        for(int j = 1; j <= n; j++) {
            dp[j] = dp[j - 1] + grid[0][j - 1];
        }

        // row 1 -> row (m - 1)
        dp[0] = Integer.MAX_VALUE; /*KEY: 防止从左边走到dp[1]*/
        for(int i = 1; i < m; i++) {
            for(int j = 1; j <= n; j++) {
                dp[j] = Math.min(dp[j - 1], dp[j]) + grid[i][j - 1];
            }
        }

        return dp[n];
    }

    public static void main(String[] args) {
        int [][] grid = new int[][]{
                {1, 3, 1},
                {1, 5, 1},
                {4, 2, 1}
        };

        System.out.println(minPathSum(grid));
    }
}
