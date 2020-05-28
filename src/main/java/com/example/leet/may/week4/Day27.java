package com.example.leet.may.week4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Possible Bipartition
 * Given a set of N people (numbered 1, 2, ..., N), we would like to split everyone into two groups of any size.
 *
 * Each person may dislike some other people, and they should not go into the same group.
 *
 * Formally, if dislikes[i] = [a, b], it means it is not allowed to put the people numbered a and b into the same group.
 *
 * Return true if and only if it is possible to split everyone into two groups in this way.
 *
 * Example 1:
 *
 * Input: N = 4, dislikes = [[1,2],[1,3],[2,4]]
 * Output: true
 * Explanation: group1 [1,4], group2 [2,3]
 *
 * Example 2:
 *
 * Input: N = 3, dislikes = [[1,2],[1,3],[2,3]]
 * Output: false
 *
 * Example 3:
 *
 * Input: N = 5, dislikes = [[1,2],[2,3],[3,4],[4,5],[1,5]]
 * Output: false
 *
 * Note:
 *
 * 1 <= N <= 2000
 * 0 <= dislikes.length <= 10000
 * 1 <= dislikes[i][j] <= N
 * dislikes[i][0] < dislikes[i][1]
 * There does not exist i != j for which dislikes[i] == dislikes[j].
 */
public class Day27 {

    public static boolean possibleBipartition(int N, int[][] dislikes) {
        List<Integer>[] graph = new List[N];
        for (int i = 0; i < N; i++) graph[i] = new ArrayList<>();
        for (int[] d : dislikes) {
            int a = d[0] - 1, b = d[1] - 1;
            graph[a].add(b);
            graph[b].add(a);
        }
        int[] groupMap = new int[N]; // Map people with the group (-1: None, 0: GroupA, 1: GroupB)
        Arrays.fill(groupMap, -1);
        for (int i = 0; i < N; i++)
            if (groupMap[i] == -1 && !dfs(graph, i, 0, groupMap))
                return false;
        return true;
    }
    static boolean dfs(List<Integer>[] graph, int src, int group, int[] groupMap) {
        if (groupMap[src] == 1 - group) return false; // Found `src` in the competitor group
        if (groupMap[src] == group) return true; // Already visited
        groupMap[src] = group; // Assign `src` to `group`
        for (int v : graph[src])
            if (!dfs(graph, v, 1 - group, groupMap))
                return false;
        return true;
    }

    public static void main(String[] args) {
        System.out.println(possibleBipartition(4, new int[][]{{1,2},{1,3},{2,4}}));
        System.out.println(possibleBipartition(3, new int[][]{{1,2},{1,3},{2,3}}));
        System.out.println(possibleBipartition(5, new int[][]{{1,2},{2,3},{3,4},{4,5},{1,5}}));
    }


}
