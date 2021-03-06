package com.example.leet.october.week3;

/**
 * Minimum Domino Rotations For Equal Row
 * In a row of dominoes, A[i] and B[i] represent the top and bottom halves of the ith domino.  (A domino is a tile
 * with two numbers from 1 to 6 - one on each half of the tile.)
 *
 * We may rotate the ith domino, so that A[i] and B[i] swap values.
 *
 * Return the minimum number of rotations so that all the values in A are the same, or all the values in B are the same.
 *
 * If it cannot be done, return -1.
 *
 *
 *
 * Example 1:
 *
 *
 * Input: A = [2,1,2,4,2,2], B = [5,2,6,2,3,2]
 * Output: 2
 * Explanation:
 * The first figure represents the dominoes as given by A and B: before we do any rotations.
 * If we rotate the second and fourth dominoes, we can make every value in the top row equal to 2, as indicated by
 * the second figure.
 * Example 2:
 *
 * Input: A = [3,5,1,2,3], B = [3,6,3,3,4]
 * Output: -1
 * Explanation:
 * In this case, it is not possible to rotate the dominoes to make one row of values equal.
 *
 *
 * Constraints:
 *
 * 2 <= A.length == B.length <= 2 * 104
 * 1 <= A[i], B[i] <= 6
 */
public class Day19 {

    public static int minDominoRotations(int[] A, int[] B) {
        if (A.length != B.length) { return -1; }
        int[] countA = new int[7]; // countA[i] records the occurrence of i in A.
        int[] countB = new int[7]; // countB[i] records the occurrence of i in B.
        int[] same = new int[7]; // same[k] records the occurrence of k, where k == A[i] == B[i].
        for (int i = 0; i < A.length; ++i) {
            ++countA[A[i]];
            ++countB[B[i]];
            if (A[i] == B[i]) { ++same[A[i]]; }
        }
        for (int i = 1; i < 7; ++i) {
            if (countA[i] + countB[i] - same[i] >= A.length) {
                return Math.min(countA[i], countB[i]) - same[i];
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(minDominoRotations(new int[]{2,1,2,4,2,2}, new int[]{5,2,6,2,3,2}));//2
        System.out.println(minDominoRotations(new int[]{3,5,1,2,3}, new int[]{3,6,3,3,4}));//-1
    }

    public int minDominoRotations2(int[] A, int[] B) {
        int res = A.length+1;
        if(A[0] == B[0]){
            res = Math.min(helper(A, B, 1, A[0]), helper(B, A, 1, A[0]));
        }else{
            // use A[0] && rotate to A
            res = Math.min(res, helper(A, B, 1, A[0]));
            // use A[0] && rotate to B
            res = Math.min(res, 1+helper(B, A, 1, A[0]));
            // use B[0] && rotate to A
            res = Math.min(res, 1+helper(A, B, 1, B[0]));
            // use B[0] && rotate to B
            res = Math.min(res, helper(B, A, 1, B[0]));
        }

        return res > A.length ? -1 : res;
    }

    public int helper(int[] A, int[] B, int idx, int val){
        int cnt = 0;
        for(int i=idx; i<A.length; i++){
            if(A[i] == val) ;
            else if(B[i] != val) return A.length+1;
            else cnt++;
        }
        return cnt;

    }
}
