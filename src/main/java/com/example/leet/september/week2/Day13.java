package com.example.leet.september.week2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Insert Interval
 * Given a set of non-overlapping intervals, insert a new interval into the intervals (merge if necessary).
 *
 * You may assume that the intervals were initially sorted according to their start times.
 *
 * Example 1:
 *
 * Input: intervals = [[1,3],[6,9]], newInterval = [2,5]
 * Output: [[1,5],[6,9]]
 * Example 2:
 *
 * Input: intervals = [[1,2],[3,5],[6,7],[8,10],[12,16]], newInterval = [4,8]
 * Output: [[1,2],[3,10],[12,16]]
 * Explanation: Because the new interval [4,8] overlaps with [3,5],[6,7],[8,10].
 * NOTE: input types have been changed on April 15, 2019. Please reset to default code definition to get new method
 * signature.
 */
public class Day13 {

    public static int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> result = new ArrayList<>();
        int i = 0;
        int start = newInterval[0];
        int end = newInterval[1];


        while (i < intervals.length && intervals[i][1] < start) {
            result.add(intervals[i++]);
        }

        while (i < intervals.length && intervals[i][0] <= end) {
            start = Math.min(start, intervals[i][0]);
            end = Math.max(end, intervals[i][1]);
            i++;
        }
        result.add(new int[]{start,end});

        while (i < intervals.length) result.add(intervals[i++]);
        return result.toArray(new int[result.size()][]);
    }

    public static void main(String[] args) {
        System.out.println(Arrays.deepToString(insert(new int[][]{{1,3},{6,9}}, new int[] {2, 5})));//[[1,5],[6,9]]
        System.out.println(Arrays.deepToString(insert(new int[][]{{1,2},{3,5},{6,7},{8,10},{12,16}},
                new int[] {4, 8})));//[[1,2],[3,10],[12,16]]
    }

    class Solution {
        public int[][] insert(int[][] intervals, int[] newInterval) {
            // find overlap
            int removeLeft = -1;
            int removeRight = -1;
            int start = newInterval[0];
            int end = newInterval[1];
            for (int i = 0; i < intervals.length; i++) {
                if (start <= intervals[i][1] &&
                        (end >= intervals[i][0])) {
                    start = Math.min(start, intervals[i][0]);
                    end = Math.max(end, intervals[i][1]);
                    if (removeLeft < 0) {
                        removeLeft = i;
                    }
                    removeRight = i;
                }
            }

            // final intervals
            if (removeLeft >= 0) {
                int newLen = intervals.length + 1 - (removeRight - removeLeft + 1);
                int[][] newIntervals = new int[newLen][2];
                int intervalsI = 0;
                for (int j = 0; j < newLen; j++) {
                    if ((intervalsI >= removeLeft && intervalsI <= removeRight)) {
                        while (intervalsI >= removeLeft && intervalsI <= removeRight) {
                            intervalsI++;
                        }
                        newIntervals[j] = new int[]{start, end};
                    } else {
                        newIntervals[j] = intervals[intervalsI];
                        intervalsI++;
                    }

                }
                return newIntervals;
                // empty intervals
            } else if (intervals.length == 0) {
                return new int[][]{newInterval};
                // if no overlap just insert
            } else {
                int newLen = intervals.length + 1;
                int[][] newIntervals = new int[newLen][2];
                int intervalsI = 0;
                boolean inserted = false;
                for (int h = 0; h < newLen; h++) {
                    if ((intervalsI >= intervals.length) || !inserted && intervals[intervalsI][0] > start) {
                        newIntervals[h] = newInterval;
                        inserted = true;
                    }else {
                        newIntervals[h] = intervals[intervalsI];
                        intervalsI++;
                    }
                }

                return newIntervals;
            }
        }

    }
}
