package com.example.leet.may.week4;

/**
 * Uncrossed Lines
 * We write the integers of A and B (in the order they are given) on two separate horizontal lines.
 *
 * Now, we may draw connecting lines: a straight line connecting two numbers A[i] and B[j] such that:
 *
 * A[i] == B[j];
 * The line we draw does not intersect any other connecting (non-horizontal) line.
 * Note that a connecting lines cannot intersect even at the endpoints: each number can only belong to one connecting line.
 *
 * Return the maximum number of connecting lines we can draw in this way.
 *
 * Example 1:
 *
 * Input: A = [1,4,2], B = [1,2,4]
 * Output: 2
 * Explanation: We can draw 2 uncrossed lines as in the diagram.
 * We cannot draw 3 uncrossed lines, because the line from A[1]=4 to B[2]=4 will intersect the line from A[2]=2 to B[1]=2.
 *
 * Example 2:
 *
 * Input: A = [2,5,1,2,5], B = [10,5,2,1,5,2]
 * Output: 3
 *
 * Example 3:
 *
 * Input: A = [1,3,7,1,7,5], B = [1,9,2,5,1]
 * Output: 2
 *
 * Note:
 *
 * 1 <= A.length <= 500
 * 1 <= B.length <= 500
 * 1 <= A[i], B[i] <= 2000
 *    Hide Hint #1
 * Think dynamic programming. Given an oracle dp(i,j) that tells us how many lines A[i:], B[j:] [the sequence A[i],
 * A[i+1], ... and B[j], B[j+1], ...] are uncrossed, can we write this as a recursion?
 */
public class Day25 {
    public static int maxUncrossedLines(int[] A, int[] B) {
        int[][] dp = new int[2][B.length + 1];

        int flag = 1;
        for(int i = A.length - 1; i >= 0; i--){
            for(int j = B.length - 1; j >= 0; j--){
                dp[flag][j] = (A[i] == B[j]
                        ? dp[flag ^ 1][j + 1] + 1
                        : Math.max(dp[flag][j + 1], dp[flag ^ 1][j]));
            }
            flag ^= 1;
        }

        return dp[flag ^ 1][0];
    }

    public static void main(String[] args) {
        System.out.println(maxUncrossedLines(new int[]{1,4,2}, new int[]{1,2,4}));
        System.out.println(maxUncrossedLines(new int[]{2,5,1,2,5}, new int[]{10,5,2,1,5,2}));
        System.out.println(maxUncrossedLines(new int[]{1,3,7,1,7,5}, new int[]{1,9,2,5,1}));
    }

    public int maxUncrossedLines1(int[] A, int[] B) {
        int[] mx = new int[B.length];
        int[] cm = new int[B.length];
        for(int i = 0; i < A.length; i++){
            for(int j = 0; j < B.length; j++){
                cm[j] = Math.max((j == 0 ? 0 : cm[j - 1]), mx[j]);
            }

            //System.out.println(Arrays.toString(cm) + " sa");
            for(int j = 0; j < B.length; j++){
                if(A[i] == B[j]){
                    mx[j] = Math.max((j == 0 ? 0 : cm[j - 1]) + 1, mx[j]);
                }
            }


            // System.out.println(Arrays.toString(mx));
        }

        int ans = 0;

        for(int i = 0; i < B.length; i++){
            ans = Math.max(ans, mx[i]);
        }
        return ans;

    }
}
