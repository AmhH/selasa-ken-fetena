package com.example.leet.august.week5;

import java.util.*;

/**
 * Largest Component Size by Common Factor
 * Given a non-empty array of unique positive integers A, consider the following graph:
 *
 * There are A.length nodes, labelled A[0] to A[A.length - 1];
 * There is an edge between A[i] and A[j] if and only if A[i] and A[j] share a common factor greater than 1.
 * Return the size of the largest connected component in the graph.
 *
 *
 *
 * Example 1:
 *
 * Input: [4,6,15,35]
 * Output: 4
 *
 * Example 2:
 *
 * Input: [20,50,9,63]
 * Output: 2
 *
 * Example 3:
 *
 * Input: [2,3,6,7,4,12,21,39]
 * Output: 8
 *
 * Note:
 *
 * 1 <= A.length <= 20000
 * 1 <= A[i] <= 100000
 */
public class Day30 {

    int[] par;
    int[] cnt;
    private int find(int i) {
        if (i == par[i]) return i;
        return par[i] = find(par[i]);
    }
    private void union(int i, int j) {
        int pi = find(i);
        int pj = find(j);
        if (pi == pj) return ;
        par[pi] = pj;
        cnt[pj] += cnt[pi];
    }
    public int largestComponentSize(int[] A) {
        int N = A.length;
        par = new int[N];
        cnt = new int[N];
        Map<Integer, Set<Integer>> prime2Idx = new HashMap<>();
        for (int i = 0; i < N; i++) {
            int d = 2, x = A[i];
            while (d * d <= x) {
                if (x % d == 0) {
                    while (x % d == 0) x /= d;
                    prime2Idx.putIfAbsent(d, new HashSet<>());
                    prime2Idx.get(d).add(i);
                }
                d++;
            }
            if (x > 1) {
                prime2Idx.putIfAbsent(x, new HashSet<>());
                prime2Idx.get(x).add(i);
            }
        }
        for (int i = 0; i < N; i++) par[i] = i;
        Arrays.fill(cnt, 1);
        int max = 1;
        for (Set<Integer> s : prime2Idx.values()) {
            int fir = s.iterator().next();
            for (int idx : s) {
                union(idx, fir);
                max = Math.max(cnt[find(idx)],max);
            }
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println(new Day30().largestComponentSize(new int[]{4,6,15,35}));
        System.out.println(new Day30().largestComponentSize(new int[]{20,50,9,63}));
        System.out.println(new Day30().largestComponentSize(new int[]{2,3,6,7,4,12,21,39}));
    }

}
