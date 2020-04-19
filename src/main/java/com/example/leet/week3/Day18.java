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
        int xlen = grid.length;
        if(xlen == 0) return 0;
        int ylen = grid[0].length;
        //using grid as dp grid
        for(int i=1;i<xlen;i++) {
            grid[i][0]+=grid[i-1][0];
        }
        for(int i=1;i<ylen;i++) {
            grid[0][i]+=grid[0][i-1];
        }
        for(int i=1;i<xlen;i++){
            for(int j=1; j<ylen;j++) {
                grid[i][j] += Math.min(grid[i-1][j], grid[i][j-1]);
            }
        }
        return grid[xlen-1][ylen-1];
    }

    public static void main(String[] args) {

    }
}
