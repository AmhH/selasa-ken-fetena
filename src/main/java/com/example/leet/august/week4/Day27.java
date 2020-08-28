package com.example.leet.august.week4;

import java.util.Arrays;
import java.util.TreeMap;

/**
 * Find Right Interval
 * Given a set of intervals, for each of the interval i, check if there exists an interval j whose start point is
 * bigger than or equal to the end point of the interval i, which can be called that j is on the "right" of i.
 *
 * For any interval i, you need to store the minimum interval j's index, which means that the interval j has the
 * minimum start point to build the "right" relationship for interval i. If the interval j doesn't exist, store -1
 * for the interval i. Finally, you need output the stored value of each interval as an array.
 *
 * Note:
 *
 * You may assume the interval's end point is always bigger than its start point.
 * You may assume none of these intervals have the same start point.
 *
 * Example 1:
 * Input: [ [1,2] ]
 * Output: [-1]
 *
 * Explanation: There is only one interval in the collection, so it outputs -1.
 *
 * Example 2:
 * Input: [ [3,4], [2,3], [1,2] ]
 * Output: [-1, 0, 1]
 *
 * Explanation: There is no satisfied "right" interval for [3,4].
 * For [2,3], the interval [3,4] has minimum-"right" start point;
 * For [1,2], the interval [2,3] has minimum-"right" start point.
 *
 * Example 3:
 * Input: [ [1,4], [2,3], [3,4] ]
 * Output: [-1, 2, -1]
 *
 * Explanation: There is no satisfied "right" interval for [1,4] and [3,4].
 * For [2,3], the interval [3,4] has minimum-"right" start point.
 * NOTE: input types have been changed on April 15, 2019. Please reset to default code definition to get new method
 * signature.
 */
public class Day27 {
    public static int[] findRightInterval(int[][] intervals) {
        int n = intervals.length;
        if (n == 1)
            return new int[]{-1};

        TreeMap<Integer, Integer> map = new TreeMap();
        for (int i = 0; i < n; i++) {
            map.put(intervals[i][0], i);
        }

        int[] result = new int[n];
        for (int i = 0; i < n; i++) {
            Integer key = map.ceilingKey(intervals[i][1]);
            result[i] = key == null ? -1 : map.get(key);
        }

        return result;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(findRightInterval(new int[][]{{1,2}})));
        System.out.println(Arrays.toString(findRightInterval(new int[][]{{3,4},{2,3},{1,2}})));
        System.out.println(Arrays.toString(findRightInterval2(new int[][]{{1,4},{2,3},{3,4}})));
    }

    public static int[] findRightInterval2(int[][] intervals) {
        int minStartPoint = Integer.MAX_VALUE;
        int maxEndPoint = Integer.MIN_VALUE;

        for (int i = 0; i < intervals.length; i++) {
            minStartPoint = Math.min(minStartPoint, intervals[i][0]);
            maxEndPoint = Math.max(maxEndPoint, intervals[i][1]);
        }

        int[] buckets = new int[maxEndPoint - minStartPoint + 1];
        Arrays.fill(buckets, -1);

        for (int i = 0; i < intervals.length; i++) {
            buckets[intervals[i][0] - minStartPoint] = i;
        }

        for (int i = buckets.length - 2; i > -1; i--) {
            if (buckets[i] == -1) {
                buckets[i] = buckets[i + 1];
            }
        }

        int[] rightIntervals = new int[intervals.length];

        for (int i = 0; i < intervals.length; i++) {
            rightIntervals[i] = buckets[intervals[i][1] - minStartPoint];
        }

        return rightIntervals;
    }
}
