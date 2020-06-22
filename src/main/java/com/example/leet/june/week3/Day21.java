package com.example.leet.june.week3;

import java.util.Arrays;

/**
 * Dungeon Game
 * The demons had captured the princess (P) and imprisoned her in the bottom-right corner of a dungeon. The dungeon
 * consists of M x N rooms laid out in a 2D grid. Our valiant knight (K) was initially positioned in the top-left
 * room and must fight his way through the dungeon to rescue the princess.
 *
 * The knight has an initial health point represented by a positive integer. If at any point his health point drops
 * to 0 or below, he dies immediately.
 *
 * Some of the rooms are guarded by demons, so the knight loses health (negative integers) upon entering these rooms;
 * other rooms are either empty (0's) or contain magic orbs that increase the knight's health (positive integers).
 *
 * In order to reach the princess as quickly as possible, the knight decides to move only rightward or downward in
 * each step.
 *
 *
 *
 * Write a function to determine the knight's minimum initial health so that he is able to rescue the princess.
 *
 * For example, given the dungeon below, the initial health of the knight must be at least 7 if he follows the
 * optimal path RIGHT-> RIGHT -> DOWN -> DOWN.
 *
 * -2 (K)	-3	3
 * -5	-10	1
 * 10	30	-5 (P)
 *
 *
 * Note:
 *
 * The knight's health has no upper bound.
 * Any room can contain threats or power-ups, even the first room the knight enters and the bottom-right room where
 * the princess is imprisoned.
 */
public class Day21 {

    public static int calculateMinimumHP(int[][] dungeon) {
        int[][] dp = new int[dungeon.length + 1][dungeon[0].length + 1];
        for(int i = 0; i < dungeon.length + 1; i++) Arrays.fill(dp[i], -1);

        return mhr(dungeon, 0, 0, dp);
    }

    private static int mhr(int[][] arr, int i, int j, int[][] dp){
        if(dp[i][j] != -1) return dp[i][j];
        if(i == arr.length - 1 && j == arr[0].length - 1) return arr[i][j] > 0 ? 1 : Math.abs(arr[i][j]) + 1;
        if(i == arr.length || j == arr[0].length) return Integer.MAX_VALUE;

        return dp[i][j] = Math.max(1, Math.min(mhr(arr, i + 1, j, dp), mhr(arr, i, j + 1, dp)) - arr[i][j]);
    }

    public static void main(String[] args) {
        System.out.println(calculateMinimumHP(new int[][]{{-2, -3, 3}, {-5, -10, 1}, {10, 30, -5}}));
    }

    class Solution {
        public int calculateMinimumHP(int[][] dungeon) {
            return mhr(dungeon, 0, 0);
        }

        int mhr(int[][] arr, int i, int j){
            if(i == arr.length - 1 && j == arr[0].length - 1) return arr[i][j] > 0 ? 1 : Math.abs(arr[i][j]) + 1;
            if(i == arr.length || j == arr[0].length) return Integer.MAX_VALUE;

            return Math.max(1, Math.min(mhr(arr, i + 1, j), mhr(arr, i, j + 1)) - arr[i][j]);
        }
    }

    public int calculateMinimumHP2(int[][] dungeon) {
        int n = dungeon.length;
        int m = dungeon[0].length;
        int[] dp = new int[m];

        for (int i = n - 1; i >= 0; i--) {
            for (int j = m - 1; j >= 0; j--) {
                if (i + 1 == n && j + 1 == m) {
                    dp[j] = Math.max(1 - dungeon[i][j], 1);
                    continue;
                }

                if (i + 1 == n) {
                    dp[j] = Math.max(dp[j + 1] - dungeon[i][j], 1);
                } else if (j + 1 == m) {
                    dp[j] = Math.max(dp[j] - dungeon[i][j], 1);
                } else {
                    int right = Math.max(dp[j + 1] - dungeon[i][j], 1);
                    int down = Math.max(dp[j] - dungeon[i][j], 1);
                    dp[j] = Math.min(right, down);
                }
            }
        }

        return dp[0];
    }

    class Solution2 {
        public int calculateMinimumHP(int[][] dungeon) {
            if(dungeon == null || dungeon.length==0 || dungeon[0]==null || dungeon[0].length==0) {
                return 0;
            }
            int m = dungeon.length, n = dungeon[0].length;

            int[][] dp = new int[m][n];
            dp[m-1][n-1] = Math.max(1-dungeon[m-1][n-1], 1);

            return dfs(dungeon, dp, 0, 0);
        }

        private int dfs(int[][] dungeon, int[][] dp, int x, int y) {
            int m = dungeon.length;
            int n = dungeon[0].length;

            if(x == m || y == n) return Integer.MAX_VALUE/2;
            if(dp[x][y] > 0) return dp[x][y];

            int right = Math.max(dfs(dungeon, dp, x, y+1) - dungeon[x][y], 1);
            int down = Math.max(dfs(dungeon, dp, x+1, y) - dungeon[x][y], 1);

            dp[x][y] = Math.min(right, down);

            return dp[x][y];

        }
    }
}
