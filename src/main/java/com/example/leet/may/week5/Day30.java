package com.example.leet.may.week5;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * K Closest Points to Origin
 * We have a list of points on the plane.  Find the K closest points to the origin (0, 0).
 *
 * (Here, the distance between two points on a plane is the Euclidean distance.)
 *
 * You may return the answer in any order.  The answer is guaranteed to be unique (except for the order that it is in.)
 *
 * Example 1:
 *
 * Input: points = [[1,3],[-2,2]], K = 1
 * Output: [[-2,2]]
 * Explanation:
 * The distance between (1, 3) and the origin is sqrt(10).
 * The distance between (-2, 2) and the origin is sqrt(8).
 * Since sqrt(8) < sqrt(10), (-2, 2) is closer to the origin.
 * We only want the closest K = 1 points from the origin, so the answer is just [[-2,2]].
 *
 * Example 2:
 *
 * Input: points = [[3,3],[5,-1],[-2,4]], K = 2
 * Output: [[3,3],[-2,4]]
 * (The answer [[-2,4],[3,3]] would also be accepted.)
 *
 *
 * Note:
 *
 * 1 <= K <= points.length <= 10000
 * -10000 < points[i][0] < 10000
 * -10000 < points[i][1] < 10000
 */
public class Day30 {
    public static int[][] kClosest(int[][] points, int K) {
        PriorityQueue<int[]> minHeap = new PriorityQueue<>(Comparator.comparingInt(a -> a[0])); // int[] will store distance square and the x, y cordinates of point
        for (int i = 0; i < points.length; i++) {
            minHeap.add(new int[]{points[i][0] * points[i][0] + points[i][1] * points[i][1], points[i][0], points[i][1]});
        }
        int[][] result = new int[K][2];
        int i = 0;
        while (i < K) {
            int[] item = minHeap.poll();
            result[i][0] = item[1];
            result[i][1] = item[2];
            i++;
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.deepToString(kClosest(new int[][] {{1,3},{-2,2}}, 1)));
        System.out.println(Arrays.deepToString(kClosest(new int[][] {{3,3},{5,-1},{-2,4}}, 2)));
    }
}
