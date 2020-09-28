package com.example.leet.september.week4;

import java.util.*;

/**
 * Evaluate Division
 * You are given equations in the format A / B = k, where A and B are variables represented as strings, and k is a
 * real number (floating-point number). Given some queries, return the answers. If the answer does not exist, return
 * -1.0.
 *
 * The input is always valid. You may assume that evaluating the queries will result in no division by zero and there
 * is no contradiction.
 *
 *
 *
 * Example 1:
 *
 * Input: equations = [["a","b"],["b","c"]], values = [2.0,3.0], queries = [["a","c"],["b","a"],["a","e"],["a","a"],
 * ["x","x"]]
 * Output: [6.00000,0.50000,-1.00000,1.00000,-1.00000]
 * Explanation:
 * Given: a / b = 2.0, b / c = 3.0
 * queries are: a / c = ?, b / a = ?, a / e = ?, a / a = ?, x / x = ?
 * return: [6.0, 0.5, -1.0, 1.0, -1.0 ]
 * Example 2:
 *
 * Input: equations = [["a","b"],["b","c"],["bc","cd"]], values = [1.5,2.5,5.0], queries = [["a","c"],["c","b"],
 * ["bc","cd"],["cd","bc"]]
 * Output: [3.75000,0.40000,5.00000,0.20000]
 * Example 3:
 *
 * Input: equations = [["a","b"]], values = [0.5], queries = [["a","b"],["b","a"],["a","c"],["x","y"]]
 * Output: [0.50000,2.00000,-1.00000,-1.00000]
 *
 *
 * Constraints:
 *
 * 1 <= equations.length <= 20
 * equations[i].length == 2
 * 1 <= equations[i][0], equations[i][1] <= 5
 * values.length == equations.length
 * 0.0 < values[i] <= 20.0
 * 1 <= queries.length <= 20
 * queries[i].length == 2
 * 1 <= queries[i][0], queries[i][1] <= 5
 * equations[i][0], equations[i][1], queries[i][0], queries[i][1] consist of lower case English letters and digits.
 *   Hide Hint #1
 * Do you recognize this as a graph problem?
 */
public class Day27 {

     static class Node{
        String key;
        double val;

         public Node(String key, double val) {
             this.key = key;
             this.val = val;
         }
     }
    public static double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        Map<String, List<Node>> graph = buildGraph(equations, values);
        int size = queries.size();
        double[] result = new double[size];
        for (int i = 0; i < size; i++) {
            result[i] = dfs(queries.get(i).get(0), queries.get(i).get(1), new HashSet<>(), graph);
        }
        return result;
    }

    private static double dfs(String src, String dst, Set<Object> visited, Map<String, List<Node>> graph) {
        if(!(graph.containsKey(src) && graph.containsKey(dst)))
            return -1.0;
        if(src.equals(dst))
            return 1.0;

        visited.add(src);
        for(Node node : graph.get(src)) {
            if(!visited.contains(node.key)) {
                double ans = dfs(node.key, dst, visited, graph);
                if(ans != -1.0)
                    return ans * node.val;
            }
        }

        return -1.0;
    }

    private static Map<String, List<Node>> buildGraph(List<List<String>> equations, double[] values) {
        Map<String, List<Node>> graph = new HashMap();
        for (int i = 0; i < values.length; i++) {
            String src = equations.get(i).get(0);
            String dest = equations.get(i).get(1);
            graph.computeIfAbsent(src, k -> new ArrayList()).add(new Node(dest, values[i]));
            graph.computeIfAbsent(dest, k -> new ArrayList()).add(new Node(src, 1 / values[i]));
        }
        return graph;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(calcEquation(Arrays.asList(Arrays.asList("a","b"), Arrays.asList("b","c")),
                new double[]{2.0, 3.0}, Arrays.asList(Arrays.asList("a","c"),Arrays.asList("b","a"),
                        Arrays.asList("a","e"),Arrays.asList("a","a"), Arrays.asList("x","x")))));//Output: [6.00000,
        // 0.50000,-1.00000,1.00000,-1.00000]

        System.out.println(Arrays.toString(calcEquation(Arrays.asList(Arrays.asList("a","b"),Arrays.asList("b","c"), Arrays.asList("bc","cd")),
                new double[]{1.5,2.5,5.0}, Arrays.asList(Arrays.asList("a","c"),Arrays.asList("c","b"),Arrays.asList("bc","cd"),
        Arrays.asList("cd", "bc")))));//[3.75000,0.40000,5.00000,0.20000]

        System.out.println(Arrays.toString(calcEquation(Collections.singletonList(Arrays.asList("a","b")),
                new double[]{0.5},
                Arrays.asList(Arrays.asList("a","b"),Arrays.asList("b","a"),Arrays.asList("a","c"),Arrays.asList("x",
                        "y")))));
        //[0.50000,2.00000,-1.00000,-1.00000]
    }
}
