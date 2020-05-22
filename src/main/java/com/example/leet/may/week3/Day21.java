package com.example.leet.may.week3;

/**
 * Count Square Submatrices with All Ones
 * Given a m * n matrix of ones and zeros, return how many square submatrices have all ones.
 *
 * Example 1:
 *
 * Input: matrix =
 * [
 *   [0,1,1,1],
 *   [1,1,1,1],
 *   [0,1,1,1]
 * ]
 * Output: 15
 * Explanation:
 * There are 10 squares of side 1.
 * There are 4 squares of side 2.
 * There is  1 square of side 3.
 * Total number of squares = 10 + 4 + 1 = 15.
 * Example 2:
 *
 * Input: matrix =
 * [
 *   [1,0,1],
 *   [1,1,0],
 *   [1,1,0]
 * ]
 * Output: 7
 * Explanation:
 * There are 6 squares of side 1.
 * There is 1 square of side 2.
 * Total number of squares = 6 + 1 = 7.
 *
 * Constraints:
 *
 * 1 <= arr.length <= 300
 * 1 <= arr[0].length <= 300
 * 0 <= arr[i][j] <= 1
 *    Hide Hint #1
 * Create an additive table that counts the sum of elements of submatrix with the superior corner at (0,0).
 *    Hide Hint #2
 * Loop over all subsquares in O(n^3) and check if the sum make the whole array to be ones, if it checks then add 1
 * to the answer.
 */
public class Day21 {

    public int countSquares(int[][] matrix) {
        int mat[][] = new int[matrix.length + 1][matrix[0].length + 1];
        int sum = 0;

        /**  We can do Dynamic Programming by saving how many
            Squares can be formed using the bottom right corner
            element.
        */

        for(int i = 1; i <= matrix.length; i++)
            for(int j = 1; j <= matrix[0].length; j++)
                if(matrix[i - 1][j - 1] != 0)
                    sum += (mat[i][j] = Math.min(Math.min(mat[i - 1][j], mat[i][j - 1]), mat[i - 1][j - 1]) + 1);


        /**
        Workin on the first example:
        ===========================
        Matrix =
        [0,1,1,1],
        [1,1,1,1],
        [0,1,1,1]
        ===========================
        mat after algorithm =
        [0,0,0,0,0],
        [0,0,1,1,1],
        [0,1,1,2,2],
        [0,0,1,2,3]
        ===========================
        After summing all indicies, now we get the correct answer!
        */

        return sum;
    }

    public int countSquares1(int[][] M)
    {
        int R=M.length;
        if(R==0)
            return 0;
        int C=M[0].length;
        int S=0;

        for(int i=R-1;i>=0;i--)
        {
            for(int j=C-1;j>=0;j--)
            {
                if(i!=R-1 && j!=C-1 && M[i][j]!=0)
                    M[i][j]=Math.min(M[i+1][j+1],Math.min(M[i+1][j],M[i][j+1]))+1;
                S+=M[i][j];
            }
        }

        return S;
    }

    public int countSquares2(int[][] A) {
        int res = 0;
        for (int i = 0; i < A.length; ++i) {
            for (int j = 0; j < A[0].length; ++j) {
                if (A[i][j] > 0 && i > 0 && j > 0) {
                    A[i][j] = Math.min(A[i - 1][j - 1], Math.min(A[i - 1][j], A[i][j - 1])) + 1;
                }
                res += A[i][j];
            }
        }
        return res;
    }

    public int countSquares3(int[][] matrix) {
        //use cumulative sum array
        int m = matrix.length;
        int n = matrix[0].length;
        int count = matrix[0][0];
        for(int i = 1;i<m;i++){
            count += matrix[i][0];
        }
        for(int j = 1;j<n;j++){
            count += matrix[0][j];
        }
        for(int i =1;i<m;i++){
            for(int j =1;j<n;j++){
                if(matrix[i][j] !=0){
                    matrix[i][j] = Math.min(matrix[i-1][j-1],Math.min(matrix[i-1][j],matrix[i][j-1]))+1;
                    count += matrix[i][j];
                }
            }
        }
        return count;
    }
}
