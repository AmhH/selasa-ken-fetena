package com.example.leet.october.week1;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Remove Covered Intervals
 * Given a list of intervals, remove all intervals that are covered by another interval in the list.
 *
 * Interval [a,b) is covered by interval [c,d) if and only if c <= a and b <= d.
 *
 * After doing so, return the number of remaining intervals.
 *
 *
 *
 * Example 1:
 *
 * Input: intervals = [[1,4],[3,6],[2,8]]
 * Output: 2
 * Explanation: Interval [3,6] is covered by [2,8], therefore it is removed.
 * Example 2:
 *
 * Input: intervals = [[1,4],[2,3]]
 * Output: 1
 * Example 3:
 *
 * Input: intervals = [[0,10],[5,12]]
 * Output: 2
 * Example 4:
 *
 * Input: intervals = [[3,10],[4,10],[5,11]]
 * Output: 2
 * Example 5:
 *
 * Input: intervals = [[1,2],[1,4],[3,4]]
 * Output: 1
 *
 *
 * Constraints:
 *
 * 1 <= intervals.length <= 1000
 * intervals[i].length == 2
 * 0 <= intervals[i][0] < intervals[i][1] <= 10^5
 * All the intervals are unique.
 *    Hide Hint #1
 * How to check if an interval is covered by another?
 *    Hide Hint #2
 * Compare each interval to all others and check if it is covered by any interval.
 */
public class Day4 {
    public static int removeCoveredIntervals(int[][] intervals) {
        int res = 0, left = -1, right = -1;
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));
        for (int[] v : intervals) {
            if (v[0] > left && v[1] > right) {
                left = v[0];
                ++res;
            }
            right = Math.max(right, v[1]);
        }
        return res;
    }

    public static int removeCoveredIntervals1(int[][] intervals) {
        int len = intervals.length;
        for (int i = 0; i < intervals.length - 1; i++) {
            if (intervals[i] == null)
                continue;
            int a = intervals[i][0], b = intervals[i][1];
            for (int j = i + 1; j < intervals.length; j++) {
                if (intervals[j] == null)
                    continue;
                int c = intervals[j][0], d = intervals[j][1];
                if (c <= a && b <= d) {
                    //  被包围
                    len--;
                    break;
                } else if (c >= a && b >= d) {
                    //  包围其他
                    intervals[j] = null;
                    len--;
                }
            }
        }
        return len;
    }
    public static void main(String[] args) {
        System.out.println(removeCoveredIntervals(new int[][]{{1,4},{3,6},{2,8}}));//2
        System.out.println(removeCoveredIntervals(new int[][]{{1,4},{2,3}}));//1
        System.out.println(removeCoveredIntervals(new int[][]{{0,10},{5,12}}));//2
        System.out.println(removeCoveredIntervals(new int[][]{{3,10},{4,10},{5,11}}));//2
        System.out.println(removeCoveredIntervals1(new int[][]{{1,2},{1,4},{3,4}}));//1
    }
}
