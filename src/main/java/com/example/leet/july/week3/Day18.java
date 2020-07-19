package com.example.leet.july.week3;

import java.util.*;

/**
 * Course Schedule II
 * There are a total of n courses you have to take, labeled from 0 to n-1.
 *
 * Some courses may have prerequisites, for example to take course 0 you have to first take course 1, which is
 * expressed as a pair: [0,1]
 *
 * Given the total number of courses and a list of prerequisite pairs, return the ordering of courses you should take
 * to finish all courses.
 *
 * There may be multiple correct orders, you just need to return one of them. If it is impossible to finish all
 * courses, return an empty array.
 *
 * Example 1:
 *
 * Input: 2, [[1,0]]
 * Output: [0,1]
 * Explanation: There are a total of 2 courses to take. To take course 1 you should have finished
 *              course 0. So the correct course order is [0,1] .
 * Example 2:
 *
 * Input: 4, [[1,0],[2,0],[3,1],[3,2]]
 * Output: [0,1,2,3] or [0,2,1,3]
 * Explanation: There are a total of 4 courses to take. To take course 3 you should have finished both
 *              courses 1 and 2. Both courses 1 and 2 should be taken after you finished course 0.
 *              So one correct course order is [0,1,2,3]. Another correct ordering is [0,2,1,3] .
 * Note:
 *
 * The input prerequisites is a graph represented by a list of edges, not adjacency matrices. Read more about how a
 * graph is represented.
 * You may assume that there are no duplicate edges in the input prerequisites.
 *    Hide Hint #1
 * This problem is equivalent to finding the topological order in a directed graph. If a cycle exists, no topological
 * ordering exists and therefore it will be impossible to take all courses.
 *    Hide Hint #2
 * Topological Sort via DFS - A great video tutorial (21 minutes) on Coursera
 * (https://class.coursera.org/algo-003/lecture/52) explaining the basic concepts of
 * Topological Sort.
 *    Hide Hint #3
 * Topological sort could also be done via BFS.{http://en.wikipedia.org/wiki/Topological_sorting#Algorithms)}
 */
public class Day18 {
    public static int[] findOrder(int numCourses, int[][] prerequisites) {
        if(prerequisites.length == 0){
            int[] result = new int[numCourses];
            for (int i = 0; i < numCourses; i++) {
                result[i] = i;
            }
            return result;
        }
        Map<Integer, Integer> inDegree = new HashMap<>();
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for (int i = 0; i < numCourses; i++) {
            inDegree.putIfAbsent(i, 0);
        }

        for(int[] dependency : prerequisites){
            List<Integer> list = graph.getOrDefault(dependency[0], new ArrayList<>());
            list.add(dependency[1]);
            graph.put(dependency[0], list);
            inDegree.put(dependency[1], inDegree.getOrDefault(dependency[1], 0)+1);
        }

        Queue<Integer> queue = new LinkedList<>();
        int[] result = new int[numCourses];
        int index = numCourses;

        for (Map.Entry<Integer, Integer> inEntry : inDegree.entrySet()) {
            if(inEntry.getValue() == 0)
                queue.offer(inEntry.getKey());
        }

        while(!queue.isEmpty()){
            Integer node = queue.poll();
            result[--index] = node;
            for(Integer child : graph.getOrDefault(node, new ArrayList<>())){
                inDegree.put(child, inDegree.get(child) - 1);
                if(inDegree.get(child).equals(0))
                    queue.add(child);
            }
        }

        if(index == 0)
            return result;


        return new int[] {};
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(findOrder(1, new int[][]{})));
        System.out.println(Arrays.toString(findOrder(2, new int[][]{{1,0}})));
        System.out.println(Arrays.toString(findOrder(4, new int[][]{{1,0},{2,0},{3,1},{3,2}})));
    }


}
