package com.example.leet.september.week3;

/**
 * Car Pooling
 * You are driving a vehicle that has capacity empty seats initially available for passengers.  The vehicle only
 * drives east (ie. it cannot turn around and drive west.)
 * <p>
 * Given a list of trips, trip[i] = [num_passengers, start_location, end_location] contains information about the
 * i-th trip: the number of passengers that must be picked up, and the locations to pick them up and drop them off.
 * The locations are given as the number of kilometers due east from your vehicle's initial location.
 * <p>
 * Return true if and only if it is possible to pick up and drop off all passengers for all the given trips.
 * <p>
 * Example 1:
 * <p>
 * Input: trips = [[2,1,5],[3,3,7]], capacity = 4
 * Output: false
 * Example 2:
 * <p>
 * Input: trips = [[2,1,5],[3,3,7]], capacity = 5
 * Output: true
 * Example 3:
 * <p>
 * Input: trips = [[2,1,5],[3,5,7]], capacity = 3
 * Output: true
 * Example 4:
 * <p>
 * Input: trips = [[3,2,7],[3,7,9],[8,3,9]], capacity = 11
 * Output: true
 * <p>
 * Constraints:
 * <p>
 * trips.length <= 1000
 * trips[i].length == 3
 * 1 <= trips[i][0] <= 100
 * 0 <= trips[i][1] < trips[i][2] <= 1000
 * 1 <= capacity <= 100000
 * <p>
 * Hide Hint #1
 * Sort the pickup and dropoff events by location, then process them in order.
 */
public class Day21 {
    public static boolean carPooling(int[][] trips, int capacity) {
        int[] timestamp = new int[1001];
        for (int[] trip : trips) {
            timestamp[trip[1]] += trip[0];
            timestamp[trip[2]] -= trip[0];
        }
        int ued_capacity = 0;
        for (int number : timestamp) {
            ued_capacity += number;
            if (ued_capacity > capacity) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(carPooling(new int[][]{{2,1,5},{3,3,7}}, 4));//false
        System.out.println(carPooling(new int[][]{{2,1,5},{3,3,7}}, 5));//true
        System.out.println(carPooling0(new int[][]{{2,1,5},{3,5,7}}, 3));//true
        System.out.println(carPooling0(new int[][]{{3,2,7},{3,7,9},{8,3,9}}, 11));//true
    }

    public static boolean carPooling0(int[][] trips, int capacity) {
        int st = Integer.MAX_VALUE;
        int end = Integer.MIN_VALUE;
        for (int i = 0; i < trips.length; i++) {
            int[] trip = trips[i];
            st = (st < trip[1]) ? st : trip[1];
            end = (end > trip[2]) ? end : trip[2];
        }

        int[] delta = new int[end + 1];
        for (int i = 0; i < trips.length; i++) {
            int[] trip = trips[i];
            int c = trip[0];
            int s = trip[1];
            int e = trip[2];

            delta[s] = delta[s] + c;
            delta[e] = delta[e] - c;
        }

        int runningSum = 0;
        for (int i = st; i < end; i++) {
            runningSum = runningSum + delta[i];
            if (runningSum > capacity) {
                return false;
            }
        }
        return true;
    }

}
