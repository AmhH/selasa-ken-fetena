package com.example.leet.october.week1;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

/**
 * Number of Recent Calls
 * You have a RecentCounter class which counts the number of recent requests within a certain time frame.
 * <p>
 * Implement the RecentCounter class:
 * <p>
 * RecentCounter() Initializes the counter with zero recent requests.
 * int ping(int t) Adds a new request at time t, where t represents some time in milliseconds, and returns the number
 * of requests that has happened in the past 3000 milliseconds (including the new request). Specifically, return the
 * number of requests that have happened in the inclusive range [t - 3000, t].
 * It is guaranteed that every call to ping uses a strictly larger value of t than the previous call.
 * <p>
 * Example 1:
 * <p>
 * Input
 * ["RecentCounter", "ping", "ping", "ping", "ping"]
 * [[], [1], [100], [3001], [3002]]
 * Output
 * [null, 1, 2, 3, 3]
 * <p>
 * Explanation
 * RecentCounter recentCounter = new RecentCounter();
 * recentCounter.ping(1);     // requests = [1], range is [-2999,1], return 1
 * recentCounter.ping(100);   // requests = [1, 100], range is [-2900,100], return 2
 * recentCounter.ping(3001);  // requests = [1, 100, 3001], range is [1,3001], return 3
 * recentCounter.ping(3002);  // requests = [1, 100, 3001, 3002], range is [2,3002], return 3
 * <p>
 * Constraints:
 * <p>
 * 1 <= t <= 109
 * Each test case will call ping with strictly increasing values of t.
 * At most 104 calls will be made to ping.
 */
public class Day1 {
    static class RecentCounter {

        private static final int TIME = 3000;
        private PriorityQueue<Integer> minHeap;

        public RecentCounter() {
            minHeap = new PriorityQueue<>(Comparator.comparingInt(a -> a));
        }

        public int ping(int t) {
            minHeap.offer(t);
            while (minHeap.peek() <= (t - TIME))
                minHeap.poll();
            return minHeap.size();
        }
    }

    /**
     * Your RecentCounter object will be instantiated and called as such:
     * RecentCounter obj = new RecentCounter();
     * int param_1 = obj.ping(t);
     */

    public static void main(String[] args) {
        //[1], [100], [3001], [3002]
        RecentCounter counter = new RecentCounter();
        System.out.println(counter.ping(1));//1
        System.out.println(counter.ping(100));//2
        System.out.println(counter.ping(3001));//3
        System.out.println(counter.ping(3002));//3
        System.out.println("++++++++++++++++++++++++++++++++++++++++++");
        RecentCounter counter1 = new RecentCounter();
        System.out.println(counter1.ping(642));//1
        System.out.println(counter1.ping(1849));//2
        System.out.println(counter1.ping(4921));//1
        System.out.println(counter1.ping(5936));//2
        System.out.println(counter1.ping(5957));//3
    }

    class RecentCounter1 {
        List<Integer> nums = new ArrayList<>();
        int start = 0, end=0;

        public RecentCounter1() {
        }

        public int ping(int t) {
            nums.add(t);
            end=nums.size()-1;

            while(t-nums.get(start)>3000) {
                start++;
            }

            return end-start+1;
        }
    }
}
