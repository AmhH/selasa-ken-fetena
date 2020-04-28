package com.example.leet.week4;

/**
 * Maximal Square
 * Given a 2D binary matrix filled with 0's and 1's, find the largest square containing only 1's and return its area.
 *
 * Example:
 *
 * Input:
 *
 * 1 0 1 0 0
 * 1 0 1 1 1
 * 1 1 1 1 1
 * 1 0 0 1 0
 *
 * Output: 4
 * https://leetcode.com/articles/maximal-square/
 */
public class Day27 {


    public int maximalSquare(char[][] matrix) {
        int size = 1;
        for(int i = 0; i < matrix.length; i++)
        {
            for(int j = 0; j < matrix[0].length; j++)
            {
                if(matrix[i][j] == '1')
                {
                    while(isSquare(matrix, i, j, size))
                    {
                        size++;
                    }
                }
            }
        }
        return (size-1)*(size-1);
    }

    private boolean isSquare(char[][] matrix, int currRow, int currCol, int size)
    {
        int row = currRow + size; // ending row of square + 1 is equal to this value
        int col = currCol + size;
        if(row > matrix.length || col > matrix[0].length)
        {
            return false;
        }
        for(int i = currRow; i < row; i++)
        {
            for(int j = currCol; j < col; j++)
            {
                if(matrix[i][j] != '1')
                {
                    return false;
                }
            }
        }
        return true;
    }

    public int maximalSquare2(char[][] matrix) {
        if (matrix == null || matrix.length == 0) return 0;
        int size = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == '1') {
                    while (isSquare(matrix, i, j, size)) {
                        size++;
                    }
                }
            }
        }
        return size * size;
    }

    public boolean isSquare2(char[][] matrix, int curRow, int curCol, int size) {
        int row = curRow + size;
        int col = curCol + size;
        if (row >= matrix.length || col >= matrix[0].length) {
            return false;
        }
        for (int i = curRow; i <= row; i++) {
            for (int j = curCol; j <= col; j++) {
                if (matrix[i][j] != '1') return false;
            }
        }
        return true;
    }
}
