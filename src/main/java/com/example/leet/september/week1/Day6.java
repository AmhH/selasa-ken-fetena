package com.example.leet.september.week1;

/**
 * Image Overlap
 * Two images A and B are given, represented as binary, square matrices of the same size.  (A binary matrix has only
 * 0s and 1s as values.)
 *
 * We translate one image however we choose (sliding it left, right, up, or down any number of units), and place it
 * on top of the other image.  After, the overlap of this translation is the number of positions that have a 1 in
 * both images.
 *
 * (Note also that a translation does not include any kind of rotation.)
 *
 * What is the largest possible overlap?
 *
 * Example 1:
 *
 * Input: A = [[1,1,0],
 *             [0,1,0],
 *             [0,1,0]]
 *        B = [[0,0,0],
 *             [0,1,1],
 *             [0,0,1]]
 * Output: 3
 * Explanation: We slide A to right by 1 unit and down by 1 unit.
 * Notes:
 *
 * 1 <= A.length = A[0].length = B.length = B[0].length <= 30
 * 0 <= A[i][j], B[i][j] <= 1
 */
public class Day6 {
    protected static int shiftAndCount(int x, int y, int[][] M, int[][] R) {
        int count = 0;
        int r = 0;
        // count the cells of ones in the overlapping zone.
        for (int row = y; row < M.length; ++row) {
            int c = 0;
            for (int col = x; col < M.length; ++col) {
                if (M[row][col] == 1 && M[row][col] == R[r][c])
                    count += 1;
                c += 1;
            }
            r += 1;
        }
        return count;
    }

    public static int largestOverlap(int[][] A, int[][] B) {
        int maxOverlaps = 0;

        for (int y = 0; y < A.length; ++y)
            for (int x = 0; x < A.length; ++x) {
                // move one of the matrice up and left and vice versa.
                // (equivalent to move the other matrix down and right)
                maxOverlaps = Math.max(maxOverlaps, shiftAndCount(x, y, A, B));
                maxOverlaps = Math.max(maxOverlaps, shiftAndCount(x, y, B, A));
            }

        return maxOverlaps;
    }

    public static void main(String[] args) {
        int[][] a = {{1,1,0},
                    {0,1,0},
                    {0,1,0}};
        int[][] b = {{0,0,0},
                    {0,1,1},
                    {0,0,1}};
        System.out.println(largestOverlap(a, b));
    }

    public int largestOverlap1(int[][] a, int[][] b) {
        return Math.max(find(a, b, 0, 0, new boolean[a.length][a[0].length]), find(b, a, 0, 0, new boolean[a.length][a[0].length]));
    }

    private int find(int[][] a, int[][] b, int posi, int posj, boolean[][] mem) {
        if(posi < 0 || posi >= a.length || posj < 0 || posj >= a[0].length) {
            return 0;
        }
        if(mem[posi][posj]) {
            return 0;
        }
        mem[posi][posj] = true;
        int max = count(a, b, posi, posj);
        max = Math.max(max, find(a, b, posi + 1, posj, mem));
        max = Math.max(max, find(a, b, posi, posj + 1, mem));
        return max;
    }

    private int count(int[][] a, int[][] b, int posi, int posj) {
        int cnt = 0;
        for(int i = posi; i < a.length; i++) {
            for(int j = posj; j < a[i].length; j++) {
                //if(a[i][j] + b[i - posi][j - posj] == 2) {
                cnt += (a[i][j] + b[i - posi][j - posj]) >> 1;
                //}
            }
        }
        return cnt;
    }
}
