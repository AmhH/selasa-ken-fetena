package com.example.leet.july.week1;

/**
 *  Island Perimeter
 * You are given a map in form of a two-dimensional integer grid where 1 represents land and 0 represents water.
 *
 * Grid cells are connected horizontally/vertically (not diagonally). The grid is completely surrounded by water, and
 * there is exactly one island (i.e., one or more connected land cells).
 *
 * The island doesn't have "lakes" (water inside that isn't connected to the water around the island). One cell is a
 * square with side length 1. The grid is rectangular, width and height don't exceed 100. Determine the perimeter of
 * the island.
 *
 *
 *
 * Example:
 *
 * Input:
 * [[0,1,0,0],
 *  [1,1,1,0],
 *  [0,1,0,0],
 *  [1,1,0,0]]
 *
 * Output: 16
 *
 * Explanation: The perimeter is the 16 yellow stripes in the image below:
 */
public class Day7 {

    public int islandPerimeter(int[][] grid) {
        int perimeter = 0;
        if(grid == null || grid.length == 0)
            return perimeter;
        for (int row = 0; row < grid.length; row++) {
            for (int column = 0; column < grid[0].length; column++) {
                if(grid[row][column] == 1){
                    perimeter += 4;
                    if(row > 0) perimeter -= grid[row - 1][column];
                    if (row < grid.length - 1) perimeter -= grid[row + 1][column];
                    if(column > 0) perimeter -= grid[row][column - 1];
                    if (column < grid[0].length - 1) perimeter -= grid[row][column + 1];
                }
            }
        }

        return perimeter;
    }

    public static void main(String[] args) {
        System.out.println(new Day7().islandPerimeter(new int[][]{
                    {0,1,0,0},
                    {1,1,1,0},
                    {0,1,0,0},
                    {1,1,0,0}}));
    }

    class Solution {
        public int islandPerimeter(int[][] grid) {
            int rows = grid.length;
            int cols = grid[0].length;

            int result = 0;
            for (int r = 0; r < rows; r++) {
                for (int c = 0; c < cols; c++) {
                    if (grid[r][c] == 1) {
                        result += 4;

                        if (r > 0 && grid[r-1][c] == 1) {
                            result -= 2;
                        }

                        if (c > 0 && grid[r][c-1] == 1) {
                            result -= 2;
                        }
                    }
                }
            }

            return result;
        }
    }
}
