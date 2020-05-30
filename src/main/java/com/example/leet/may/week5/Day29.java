package com.example.leet.may.week5;

import java.util.ArrayList;
import java.util.List;

/**
 * Course Schedule
 * There are a total of numCourses courses you have to take, labeled from 0 to numCourses-1.
 *
 * Some courses may have prerequisites, for example to take course 0 you have to first take course 1, which is expressed as a pair: [0,1]
 *
 * Given the total number of courses and a list of prerequisite pairs, is it possible for you to finish all courses?
 *
 *
 *
 * Example 1:
 *
 * Input: numCourses = 2, prerequisites = [[1,0]]
 * Output: true
 * Explanation: There are a total of 2 courses to take.
 *              To take course 1 you should have finished course 0. So it is possible.
 * Example 2:
 *
 * Input: numCourses = 2, prerequisites = [[1,0],[0,1]]
 * Output: false
 * Explanation: There are a total of 2 courses to take.
 *              To take course 1 you should have finished course 0, and to take course 0 you should
 *              also have finished course 1. So it is impossible.
 *
 *
 * Constraints:
 *
 * The input prerequisites is a graph represented by a list of edges, not adjacency matrices. Read more about how a graph is represented.
 * You may assume that there are no duplicate edges in the input prerequisites.
 * 1 <= numCourses <= 10^5
 *
 *    Hide Hint #1
 * This problem is equivalent to finding if a cycle exists in a directed graph. If a cycle exists, no topological ordering exists and therefore it will be impossible to take all courses.
 *
 *    Hide Hint #2
 * Topological Sort via DFS (https://class.coursera.org/algo-003/lecture/52)
 *  - A great video tutorial (21 minutes) on Coursera explaining the basic concepts of Topological Sort.
 *
 *   Hide Hint #3
 * Topological sort could also be done via BFS (http://en.wikipedia.org/wiki/Topological_sorting#Algorithms).
 */
public class Day29 {
    //https://leetcode.com/problems/course-schedule/discuss/658296/Java-Cycle-in-a-graph-or-100-faster-or-Diagrams
    List<Integer>[] graph;
    boolean[] visited;
    boolean[] explored;
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        //  creating adjacency list representation of the graph
        graph = new ArrayList[numCourses];
        for(int i = 0; i < numCourses; i++){
            graph[i] = new ArrayList<>();
        }
        for(int i = 0; i < prerequisites.length; i++){
            graph[prerequisites[i][0]].add(prerequisites[i][1]);
        }

        visited = new boolean[numCourses];
        explored = new boolean[numCourses];
        for(int i = 0; i < numCourses; i++){
            if(!visited[i]){
                if(isCyclic(i)){
                    return false;
                }
            }
        }

        return true;
    }

    boolean isCyclic(int u){
        visited[u] = true;
        for(Integer v : graph[u]){
            if(!visited[v]){
                if(isCyclic(v)){
                    return true;
                }
            }
            else if(!explored[v]){
                return true;
            }
        }
        // explored all the adjacent vertices for vertex "u" and thus marking "u" as explored
        explored[u] = true;
        return false;
    }
    /**
     * 2nd
     */

    public boolean canFinish2(int numCourses, int[][] prerequisites) {
        ArrayList[] graph = new ArrayList[numCourses];
        for(int i=0;i<numCourses;i++){
            graph[i] = new ArrayList();
        }
        int[] visited = new int[numCourses];
        //0 not visited, 1 visiting, 2 visited
        for(int i =0; i < prerequisites.length; i++){
            graph[prerequisites[i][1]].add(prerequisites[i][0]);
        }
        for(int i = 0; i < numCourses; i++){
            if(!canFinish2(graph,visited, i)) return false;
        }
        return true;
    }
    public boolean canFinish2(ArrayList[] graph, int[] visited, int curr){
        if(visited[curr] == 1) return false;
        if(visited[curr] == 2) return true;
        visited[curr] = 1;
        for(int i = 0; i < graph[curr].size(); i++){
            if(!canFinish2(graph, visited, (int)graph[curr].get(i))) return false;
        }
        visited[curr] = 2;
        return true;
    }
}
