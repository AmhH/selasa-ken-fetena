package com.example.leet.july.week3;

import java.util.*;

/**
 * Top K Frequent Elements
 * Given a non-empty array of integers, return the k most frequent elements.
 *
 * Example 1:
 *
 * Input: nums = [1,1,1,2,2,3], k = 2
 * Output: [1,2]
 * Example 2:
 *
 * Input: nums = [1], k = 1
 * Output: [1]
 * Note:
 *
 * You may assume k is always valid, 1 ≤ k ≤ number of unique elements.
 * Your algorithm's time complexity must be better than O(n log n), where n is the array's size.
 * It's guaranteed that the answer is unique, in other words the set of the top k frequent elements is unique.
 * You can return the answer in any order.
 */
public class Day17 {

    public static int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i : nums){
            map.put(i, map.getOrDefault(i, 0) + 1);
        }
        PriorityQueue<Integer[]> maxHeap = new PriorityQueue<>((a, b) -> b[1] - a[1]);
        map.forEach((key, value) -> maxHeap.offer(new Integer[]{key, value}));
        int[] list = new int[k];
        while(k > 0){
            list[--k] = (maxHeap.poll()[0]);
        }

        return list;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(topKFrequent(new int[]{1,1,1,2,2,3}, 2)));
        System.out.println(Arrays.toString(topKFrequent(new int[]{1,1,1,2,2,3}, 1)));
        System.out.println(Arrays.toString(topKFrequent(new int[]{1}, 1)));
    }
}
