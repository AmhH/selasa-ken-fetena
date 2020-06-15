package com.example.leet.june.week2;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 *  Cheapest Flights Within K Stops
 * There are n cities connected by m flights. Each flight starts from city u and arrives at v with a price w.
 *
 * Now given all the cities and flights, together with starting city src and the destination dst, your task is to
 * find the cheapest price from src to dst with up to k stops. If there is no such route, output -1.
 *
 * Example 1:
 * Input:
 * n = 3, edges = [[0,1,100],[1,2,100],[0,2,500]]
 * src = 0, dst = 2, k = 1
 * Output: 200
 * Explanation:
 * The graph looks like this:
 *
 *
 * The cheapest price from city 0 to city 2 with at most 1 stop costs 200, as marked red in the picture.
 * Example 2:
 * Input:
 * n = 3, edges = [[0,1,100],[1,2,100],[0,2,500]]
 * src = 0, dst = 2, k = 0
 * Output: 500
 * Explanation:
 * The graph looks like this:
 *
 *
 * The cheapest price from city 0 to city 2 with at most 0 stop costs 500, as marked blue in the picture.
 *
 *
 * Constraints:
 *
 * The number of nodes n will be in range [1, 100], with nodes labeled from 0 to n - 1.
 * The size of flights will be in range [0, n * (n - 1) / 2].
 * The format of each flight will be (src, dst, price).
 * The price of each flight will be in the range [1, 10000].
 * k is in the range of [0, n - 1].
 * There will not be any duplicated flights or self cycles.
 */
public class Day14 {

    public static int findCheapestPrice(int n, int[][] flights, int src, int dst, int K) {
        int[][] arr = new int[n][n];
        for(int[] f : flights){
            arr[f[0]][f[1]] = f[2];
        }
        PriorityQueue<int[]> heap = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        heap.offer(new int[]{0, src, K+1});
        while(!heap.isEmpty()){
            int[] cur = heap.poll();
            int price = cur[0];
            int place = cur[1];
            int remainStops = cur[2];

            if(place == dst)
                return price;
            if(remainStops > 0){
                for(int i = 0; i < n; i++){
                    if(arr[place][i] > 0){
                        heap.offer(new int[]{price + arr[place][i], i, remainStops - 1});
                    }
                }
            }
        }

        return -1;
    }

    public static void main(String[] args) {

        /**
         * n = 3, edges = [[0,1,100],[1,2,100],[0,2,500]]
         *   src = 0, dst = 2, k = 1
         *    n = 3, edges = [[0,1,100],[1,2,100],[0,2,500]]
         *  * src = 0, dst = 2, k = 0
         */

        System.out.println(findCheapestPrice(3, new int[][]{{0,1,100}, {1,2,100}, {0,2,500}},0, 2, 1));
        System.out.println(findCheapestPrice(3, new int[][]{{0,1,100}, {1,2,100}, {0,2,500}},0, 2, 0));
    }
    class Solution {
        public int findCheapestPrice(int n, int[][] flights, int src, int dst, int K) {
            // construct cost adjacency matrix
            int[][] flightInfo = new int[n][n];
            for (int[] f : flights){
                flightInfo[f[0]][f[1]] = f[2];
            }
            // shortest steps array
            int[] currentStops = new int[n];
            // shortest distance array
            int[] dist = new int[n];
            Arrays.fill(currentStops, Integer.MAX_VALUE);
            Arrays.fill(dist, Integer.MAX_VALUE);
            dist[src] = 0;
            currentStops[src] = 0;
            // PQ to store edges to be processed: node-cost-stops
            PriorityQueue<Integer[]> minHeap = new PriorityQueue<Integer[]>((a, b) -> a[1]-b[1]);
            minHeap.offer(new Integer[]{src, 0, 0});
            while(!minHeap.isEmpty()){
                Integer[] cur = minHeap.poll();
                int node = cur[0], cost = cur[1], stops = cur[2];
                // If destination is reached, return the cost to get here
                if (node == dst) return cost;
                // If there are no more steps left, continue
                if (stops > K) continue;
                // Examine and relax all neighboring edges if possible
                for(int i = 0; i < flightInfo.length; i++){
                    if (flightInfo[node][i] > 0){
                        if (cost+flightInfo[node][i] < dist[i]){
                            minHeap.offer(new Integer[]{i, cost+flightInfo[node][i], stops+1});
                            dist[i] = cost+flightInfo[node][i];
                        }else if (stops + 1 <= currentStops[i]){
                            minHeap.offer(new Integer[]{i, cost+flightInfo[node][i], stops+1});
                            currentStops[i] = stops;
                        }
                    }
                }
            }
            return dist[dst] == Integer.MAX_VALUE ? -1: dist[dst];
        }
    }

    class Solution2 {
        public int findCheapestPrice(int n, int[][] flights, int src, int dst, int K) {
            int[] prices = new int[n];
            Arrays.fill(prices, Integer.MAX_VALUE);
            prices[src] = 0;
            for (int i = 0; i <= K; i++) {
                int[] temp = Arrays.copyOf(prices, n);
                for (int[] flight : flights) {
                    int cur = flight[0], next = flight[1], price = flight[2];
                    if (prices[cur] == Integer.MAX_VALUE) continue;
                    temp[next] = Math.min(temp[next], prices[cur] + price);
                }
                prices = temp;
            }
            return prices[dst] == Integer.MAX_VALUE ? -1 : prices[dst];
        }
    }
}
