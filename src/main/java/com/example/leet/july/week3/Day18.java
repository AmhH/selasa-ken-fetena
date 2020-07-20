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
 * Solution: https://leetcode.com/articles/course-schedule-ii/
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

    class Solution {
        public int[] findOrder(int numCourses, int[][] prerequisites) {
            //1.construct graph
            int[] indegree = new int[numCourses];
            List<Integer> [] neighs = new ArrayList[numCourses];
            for(int i = 0; i < numCourses; i++){
                neighs[i] = new ArrayList<>();
            }
            for(int pair = 0; pair < prerequisites.length; pair++){
                indegree[prerequisites[pair][0]] += 1;
                neighs[prerequisites[pair][1]].add(prerequisites[pair][0]);
            }
            //2. bfs
            int count = 0;
            int[] ans = new int[numCourses];
            Queue<Integer> q = new LinkedList<>();
            for(int i = 0; i < numCourses; i++){
                if( indegree[i] == 0){
                    q.offer(i);
                }
            }
            while(q.size() != 0){
                int finish = q.poll();
                ans[count] = finish;
                count++;
                for(int neigh: neighs[finish]){
                    indegree[neigh] -= 1;
                    if(indegree[neigh] == 0){
                        q.offer(neigh);
                    }
                }
            }
            if(count != numCourses){
                ans = new int[0];
            }
            return ans;
        }
    }

    class Solution1 {
        int[] visited;
        int[] result;
        int[] courses;
        int[] next;
        int[] course;
        int index = 0;

        public int[] findOrder(int numCourses, int[][] prerequisites) {
            visited = new int[numCourses]; //all 0s at first, 0: untouched
            result = new int[numCourses];
            courses = new int[numCourses];
            Arrays.fill(courses, -1);
            next = new int[prerequisites.length];
            course = new int[prerequisites.length];

            for (int i = 0; i < prerequisites.length; ++i) {
                next[i] = courses[prerequisites[i][0]];
                courses[prerequisites[i][0]] = i;
                course[i] = prerequisites[i][1];
            }

            for (int i = 0; i < numCourses; ++i) {
                if (cycle(i)) {
                    return new int[0];//has cycle: return empty array
                }
            }

            return result;
        }

        private boolean cycle(int num) {
            if (visited[num] > 0) return visited[num] == 1;
            visited[num] = 1; //touched
            for (int i = courses[num]; i != -1; i = next[i]) {
                if (cycle(course[i])) {
                    return true;//will have cycle
                }
            }
            visited[num] = 2; //checked
            result[index++] = num;
            return false; //will not form cycle
        }
    }

    public class Solution2 {

         int WHITE = 1;
         int GRAY = 2;
         int BLACK = 3;

        boolean isPossible;
        Map<Integer, Integer> color;
        Map<Integer, List<Integer>> adjList;
        List<Integer> topologicalOrder;

        private void init(int numCourses) {
            this.isPossible = true;
            this.color = new HashMap<>();
            this.adjList = new HashMap<>();
            this.topologicalOrder = new ArrayList<>();

            // By default all vertces are WHITE
            for (int i = 0; i < numCourses; i++) {
                this.color.put(i, WHITE);
            }
        }

        private void dfs(int node) {

            // Don't recurse further if we found a cycle already
            if (!this.isPossible) {
                return;
            }

            // Start the recursion
            this.color.put(node, GRAY);

            // Traverse on neighboring vertices
            for (Integer neighbor : this.adjList.getOrDefault(node, new ArrayList<>())) {
                if (this.color.get(neighbor) == WHITE) {
                    this.dfs(neighbor);
                } else if (this.color.get(neighbor) == GRAY) {
                    // An edge to a GRAY vertex represents a cycle
                    this.isPossible = false;
                }
            }

            // Recursion ends. We mark it as black
            this.color.put(node, BLACK);
            this.topologicalOrder.add(node);
        }

        public int[] findOrder(int numCourses, int[][] prerequisites) {

            this.init(numCourses);

            // Create the adjacency list representation of the graph
            for (int i = 0; i < prerequisites.length; i++) {
                int dest = prerequisites[i][0];
                int src = prerequisites[i][1];
                List<Integer> lst = adjList.getOrDefault(src, new ArrayList<>());
                lst.add(dest);
                adjList.put(src, lst);
            }

            // If the node is unprocessed, then call dfs on it.
            for (int i = 0; i < numCourses; i++) {
                if (this.color.get(i) == WHITE) {
                    this.dfs(i);
                }
            }

            int[] order;
            if (this.isPossible) {
                order = new int[numCourses];
                for (int i = 0; i < numCourses; i++) {
                    order[i] = this.topologicalOrder.get(numCourses - i - 1);
                }
            } else {
                order = new int[0];
            }

            return order;
        }

    }

}
