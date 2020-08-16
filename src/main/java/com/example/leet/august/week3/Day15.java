package com.example.leet.august.week3;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Non-overlapping Intervals
 * Given a collection of intervals, find the minimum number of intervals you need to remove to make the rest of the
 * intervals non-overlapping.
 *
 * Example 1:
 *
 * Input: [[1,2],[2,3],[3,4],[1,3]]
 * Output: 1
 * Explanation: [1,3] can be removed and the rest of intervals are non-overlapping.
 * Example 2:
 *
 * Input: [[1,2],[1,2],[1,2]]
 * Output: 2
 * Explanation: You need to remove two [1,2] to make the rest of intervals non-overlapping.
 * Example 3:
 *
 * Input: [[1,2],[2,3]]
 * Output: 0
 * Explanation: You don't need to remove any of the intervals since they're already non-overlapping.
 *
 * Note:
 *
 * You may assume the interval's end point is always bigger than its start point.
 * Intervals like [1,2] and [2,3] have borders "touching" but they don't overlap each other.
 */
public class Day15 {

    public static int eraseOverlapIntervals(int[][] intervals) {
        if(null == intervals || intervals.length < 2)
            return 0;
        Arrays.sort(intervals, (a, b) -> a[1] == b[1] ? b[0] - a[0] : a[1] - b[1]);
        int boarder = Integer.MIN_VALUE;
        int count = 0;
        for (int i = 0; i < intervals.length; i++) {
            if (boarder > intervals[i][0])
                count++;
            else
                boarder = intervals[i][1];
        }

        return count;
    }

    public static int eraseOverlapIntervals1(int[][] intervals) {
        if (intervals.length == 0) {
            return 0;
        }
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));
        int[] last = intervals[0];
        int count = 0;
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] >= last[1]) {
                last = intervals[i];
            } else if (intervals[i][0] < last[1]) {
                count++;
                last[1] = Math.min(last[1], intervals[i][1]);
            }
        }
        return count;
    }

    public int eraseOverlapIntervals0(int[][] intervals) {
        if(intervals.length == 0) return 0;
        Arrays.sort(intervals, new myComparator());
        int end = intervals[intervals.length-1][0];
        int count = 1;
        for(int i = intervals.length-2; i >= 0; i--){
            if(end >= intervals[i][1]){
                end = intervals[i][0];
                count++;
            }
        }
        return intervals.length - count;
    }

    class myComparator implements Comparator<int[]>{
        public int compare(int[] a, int[] b){
            return a[0] - b[0];
        }
    }

    public static void main(String[] args) {
        System.out.println(eraseOverlapIntervals(new int[][]{{1,2},{2,3},{3,4},{1,3}}));
        System.out.println(eraseOverlapIntervals(new int[][]{{1,2},{1,2},{1,2}}));
        System.out.println(eraseOverlapIntervals(new int[][]{{1,2},{2,3}}));
        System.out.println(eraseOverlapIntervals(new int[][]{{1,100},{11,22},{1,11},{2,12}}));
        System.out.println(eraseOverlapIntervals1(new int[][]{{1,100},{11,22},{1,11},{2,12}}));
    }
}
