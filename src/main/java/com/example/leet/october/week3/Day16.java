package com.example.leet.october.week3;

/**
 * Search a 2D Matrix
 * Write an efficient algorithm that searches for a value in an m x n matrix. This matrix has the following properties:
 *
 * Integers in each row are sorted from left to right.
 * The first integer of each row is greater than the last integer of the previous row.
 *
 *
 * Example 1:
 *  1   3   5   7
 *  10  11  16  20
 *  23  30  34  50
 * Input: matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,50]], target = 3
 * Output: true
 * Example 2:
 *  1   3   5   7
 *  10  11  16  20
 *  23  30  34  50
 * Input: matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,50]], target = 13
 * Output: false
 * Example 3:
 *
 * Input: matrix = [], target = 0
 * Output: false
 *
 *
 * Constraints:
 *
 * m == matrix.length
 * n == matrix[i].length
 * 0 <= m, n <= 100
 * -104 <= matrix[i][j], target <= 104
 */
public class Day16 {
    public static boolean searchMatrix(int[][] matrix, int target) {
        if(matrix.length == 0 || matrix[0].length == 0) return false;
        int m = matrix.length, n = matrix[0].length;
        int start = 0, end = m * n - 1;
        while(start <= end) {
            int mid = start + (end - start) / 2;
            if(matrix[mid / n][mid % n] == target) return true;
            else if(matrix[mid / n][mid % n] < target) start = mid + 1;
            else end = mid - 1;
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(searchMatrix(new int[][]{{1,3,5,7},{10,11,16,20},{23,30,34,50}}, 3));//true
        System.out.println(searchMatrix(new int[][]{{1,3,5,7},{10,11,16,20},{23,30,34,50}}, 13));//false
        System.out.println(searchMatrix(new int[][]{}, 0));//false
    }
}
