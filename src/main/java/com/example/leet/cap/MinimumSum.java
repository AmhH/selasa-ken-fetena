package com.example.leet.cap;

import java.util.PriorityQueue;

public class MinimumSum {
    public static int minimumSum(int[] num, int k){
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> b - a);
        int sum = 0;
        for (int i : num){
            sum += i;
            maxHeap.offer(i);
        }

        while (k > 0){
            int max = maxHeap.poll();
            int ceil = (int) Math.ceil(max / 2.0);
            sum -= (max - ceil);
            maxHeap.offer(ceil);
            k--;
        }
        return sum;
    }

    public static void main(String[] args) {
        System.out.println(minimumSum(new int[]{10, 20, 7}, 4));
        System.out.println(minimumSum(new int[]{2}, 1));
        System.out.println(minimumSum(new int[]{2, 3}, 1));
        System.out.println(minimumSum(new int[]{100, 4}, 4));
    }
}
