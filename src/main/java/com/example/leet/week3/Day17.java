package com.example.leet.week3;

import java.util.Arrays;

/**
 * Number of Islands
 * Given a 2d grid map of '1's (land) and '0's (water), count the number of islands. An island is surrounded by water
 * and is formed by connecting adjacent lands horizontally or vertically. You may assume all four edges of the grid are
 * all surrounded by water.
 *
 * Example 1:
 *
 * Input:
 * 11110
 * 11010
 * 11000
 * 00000
 *
 * Output: 1
 * Example 2:
 *
 * Input:
 * 11000
 * 11000
 * 00100
 * 00011
 *
 * Output: 3
 */
public class Day17 {
    /**
     * https://www.geeksforgeeks.org/find-number-of-islands/
     * @param grid zd array
     * @return number of islands
     */
    public static int numIslands(char[][] grid) {
        if(grid == null || grid.length == 0 || grid[0].length == 0)
            return 0;
        else{
            int R = grid.length;
            int C = grid[0].length;
            int i, j, count = 0;

            for(i = 0; i < R; i++){
                for(j = 0; j < C; j++){
                    if(grid[i][j] == '1'){
                        dfs(grid, i, j, R, C);
                        ++count;
                    }

                }
            }

            return count;
        }
    }

    private static void dfs(char[][] grid, int x, int y, int R, int C){
        if(x >= 0 && x < R && y >= 0 && y < C && grid[x][y] == '1'){
            grid[x][y] = '2';
            dfs(grid, x + 1, y, R, C);
            dfs(grid, x - 1, y, R, C);
            dfs(grid, x, y + 1, R, C);
            dfs(grid, x, y - 1, R, C);
        }
    }


}
