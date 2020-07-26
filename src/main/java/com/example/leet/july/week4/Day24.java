package com.example.leet.july.week4;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * All Paths From Source to Target
 * Given a directed, acyclic graph of N nodes.  Find all possible paths from node 0 to node N-1, and return them in
 * any order.
 *
 * The graph is given as follows:  the nodes are 0, 1, ..., graph.length - 1.  graph[i] is a list of all nodes j for
 * which the edge (i, j) exists.
 *
 * Example:
 * Input: [[1,2], [3], [3], []]
 * Output: [[0,1,3],[0,2,3]]
 * Explanation: The graph looks like this:
 * 0--->1
 * |    |
 * v    v
 * 2--->3
 * There are two paths: 0 -> 1 -> 3 and 0 -> 2 -> 3.
 * Note:
 *
 * The number of nodes in the graph will be in the range [2, 15].
 * You can print different paths in any order, but you should keep the order of nodes inside one path.
 */
public class Day24 {

    public static List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> result = new LinkedList<>();

        allPathsSourceTarget(graph, 0, graph.length - 1, new LinkedList<>(), result);
        return result;
    }

    private static void allPathsSourceTarget(int[][] graph, int source, int destination, List<Integer> path,
                                             List<List<Integer>> result) {
        if(source == destination){
            path.add(source);
            result.add(path);
            return;
        }
        path.add(source);

        for(int adj : graph[source]){
            List<Integer> copyPath = new LinkedList<>(path);
            allPathsSourceTarget(graph, adj, destination, copyPath, result);
        }
    }

    public static void main(String[] args) {
        System.out.println(allPathsSourceTarget(new int[][]{{1,2}, {3}, {3}, {}}));
        System.out.println(allPathsSourceTarget(new int[][]{{4,3,1},{3,2,4},{3},{4},{}}));

        System.out.println(new Solution1().allPathsSourceTarget(new int[][]{{1,2}, {3}, {3}, {}}));
        System.out.println(allPathsSourceTarget(new int[][]{{4,3,1},{3,2,4},{3},{4},{}}));
    }

    //2 ms
    class Solution {
        public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
            List<List<Integer>> ans = new ArrayList();
            List<Integer> path = new ArrayList();
            path.add(0);
            backtrack(ans, path, graph);
            return ans;
        }

        public void backtrack(List<List<Integer>> ans, List<Integer> path, int[][] graph) {
            if (path.get(path.size() - 1) == graph.length - 1) {
                ans.add(new ArrayList(path));
                return;
            }

            for (int nei : graph[path.get(path.size() - 1)]) {
                path.add(nei);
                backtrack(ans, path, graph);
                path.remove(path.size() - 1);
            }
        }
    }

    //1 ms
    static class Solution1 {
        List<List<Integer>> ans = new ArrayList<>();

        public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
            List<Integer> path = new ArrayList<>();
            path.add(0);
            dfs(graph, 0, path);
            return ans;
        }

        public void dfs(int[][] graph, int source, List<Integer> path) {
            if (source == graph.length - 1) {
                ans.add(new ArrayList<>(path));
                return;
            }
            for (int i = 0; i < graph[source].length; i++) {
                int adj = graph[source][i];
                path.add(adj);
                dfs(graph, adj, path);
                path.remove(path.size() - 1);
            }
        }
    }
}
