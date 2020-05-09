package com.example.leet.may.week2;

/**
 * Check If It Is a Straight Line
 * You are given an array coordinates, coordinates[i] = [x, y], where [x, y] represents the coordinate of a point.
 * Check if these points make a straight line in the XY plane.
 *
 * Example 1:
 *
 * Input: coordinates = [[1,2],[2,3],[3,4],[4,5],[5,6],[6,7]]
 * Output: true
 * Example 2:
 *
 * Input: coordinates = [[1,1],[2,2],[3,4],[4,5],[5,6],[7,7]]
 * Output: false
 *
 * Constraints:
 *
 * 2 <= coordinates.length <= 1000
 * coordinates[i].length == 2
 * -10^4 <= coordinates[i][0], coordinates[i][1] <= 10^4
 * coordinates contains no duplicate point.
 *    Hide Hint #1
 * If there're only 2 points, return true.
 *    Hide Hint #2
 * Check if all other points lie on the line defined by the first 2 points.
 *    Hide Hint #3
 * Use cross product to check collinearity.
 */
public class Day8 {
    public boolean checkStraightLine(int[][] coordinates) {
        int[] point1 = coordinates[1];
        int[] point2 = coordinates[0];
        float gSlope = slope(point1, point2);

        for (int i = 1; i < coordinates.length; i++) {
            int[] p1 = coordinates[i];
            int[] p2 = coordinates[0];
            float slop = slope(p1, p2);
            if (gSlope != slop) return false;
        }
        return true;
    }

    private float slope(int[] p1, int[] p2) {
        if ((p1[0] - p2[0]) == 0) return 0;
        return (float)(p2[1] - p1[1]) / (p2[0] - p1[0]);
    }
}
