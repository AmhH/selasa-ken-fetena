package com.example.leet.may.week4;

import java.util.ArrayList;
import java.util.List;

/**
 * Interval List Intersections
 * Given two lists of closed intervals, each list of intervals is pairwise disjoint and in sorted order.
 *
 * Return the intersection of these two interval lists.
 *
 * (Formally, a closed interval [a, b] (with a <= b) denotes the set of real numbers x with a <= x <= b.
 * The intersection of two closed intervals is a set of real numbers that is either empty, or can be represented as a
 * closed interval.  For example, the intersection of [1, 3] and [2, 4] is [2, 3].)
 *
 * Example 1:
 *
 * Input: A = [[0,2],[5,10],[13,23],[24,25]], B = [[1,5],[8,12],[15,24],[25,26]]
 * Output: [[1,2],[5,5],[8,10],[15,23],[24,24],[25,25]]
 * Reminder: The inputs and the desired output are lists of Interval objects, and not arrays or lists.
 *
 * Note:
 *
 * 0 <= A.length < 1000
 * 0 <= B.length < 1000
 * 0 <= A[i].start, A[i].end, B[i].start, B[i].end < 10^9
 * NOTE: input types have been changed on April 15, 2019. Please reset to default code definition to get new method
 * signature.
 */
public class Day23 {

    public static int[][] intervalIntersection(int[][] A, int[][] B) {
        int i = 0, j = 0;
        List<int[]> response = new ArrayList<>();
        while(i < A.length && j < B.length){
            int l1 = Math.max(A[i][0], B[j][0]);
            int l2 = Math.min(A[i][1], B[j][1]);
            if(A[i][1] < B[j][0] || B[j][1] < A[i][0]){
                l1 = 0;
                l2 = 0;
            }
            if(l1 != 0 || l2 != 0){
                response.add(new int[]{l1, l2});
            }
            if(A[i][1] < B[j][1])
                i++;
            else
                j++;
        }
        return response.toArray(new int[response.size()][]);
    }

    public int[][] intervalIntersection1(int[][] A, int[][] B) {
        if (A.length == 0 || B.length == 0)
            return new int[0][0];
        if (B.length > A.length)
            return intervalIntersection1(B, A);

        ArrayList<int[]> result = new ArrayList<>();
        int i = 0;
        int j = 0;
        while (i < A.length && j < B.length) {
            int[] int1 = A[i];
            int[] int2 = B[j];
            int a = int1[0];
            int c = int2[0];
            int b = int1[1];
            int d = int2[1];
            if (a <= d && a >= c || c >= a && c <= b) {
                result.add(new int[] { Math.max(a, c), Math.min(b, d) });
            }
            if (d < b) {
                j++;
            } else {
                i++;
            }
        }
        return result.toArray(new int[result.size()][2]);
    }

    public int[][] intervalIntersection2(int[][] A, int[][] B) {
        List<int[]> ans = new ArrayList();
        int i = 0;
        int j = 0;
        while (i < A.length && j < B.length) {
            int lo = Math.max(A[i][0], B[j][0]);
            int hi = Math.min(A[i][1], B[j][1]);
            if (lo <= hi) ans.add(new int[]{lo, hi});
            if (A[i][1] < B[j][1])
                i++;
            else
                j++;
        }
        return ans.toArray(new int[ans.size()][]);
    }
}
