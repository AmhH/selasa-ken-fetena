package com.example.leet.october.week3;

import java.util.*;

/**
 * Clone Graph
 * Given a reference of a node in a connected undirected graph.
 *
 * Return a deep copy (clone) of the graph.
 *
 * Each node in the graph contains a val (int) and a list (List[Node]) of its neighbors.
 *
 * class Node {
 *     public int val;
 *     public List<Node> neighbors;
 * }
 *
 *
 * Test case format:
 *
 * For simplicity sake, each node's value is the same as the node's index (1-indexed). For example, the first node
 * with val = 1, the second node with val = 2, and so on. The graph is represented in the test case using an
 * adjacency list.
 *
 * Adjacency list is a collection of unordered lists used to represent a finite graph. Each list describes the set of
 * neighbors of a node in the graph.
 *
 * The given node will always be the first node with val = 1. You must return the copy of the given node as a
 * reference to the cloned graph.
 *
 *
 *
 * Example 1:
 *  1 - 2
 *  |   |
 *  3 - 4
 * can't return the same graph
 *
 *
 * Input: adjList = [[2,4],[1,3],[2,4],[1,3]]
 * Output: [[2,4],[1,3],[2,4],[1,3]]
 * Explanation: There are 4 nodes in the graph.
 * 1st node (val = 1)'s neighbors are 2nd node (val = 2) and 4th node (val = 4).
 * 2nd node (val = 2)'s neighbors are 1st node (val = 1) and 3rd node (val = 3).
 * 3rd node (val = 3)'s neighbors are 2nd node (val = 2) and 4th node (val = 4).
 * 4th node (val = 4)'s neighbors are 1st node (val = 1) and 3rd node (val = 3).
 * Example 2:
 *      1
 *
 * Input: adjList = [[]]
 * Output: [[]]
 * Explanation: Note that the input contains one empty list. The graph consists of only one node with val = 1 and it
 * does not have any neighbors.
 * Example 3:
 *  1 - 2
 * Input: adjList = []
 * Output: []
 * Explanation: This an empty graph, it does not have any nodes.
 * Example 4:
 *
 *
 * Input: adjList = [[2],[1]]
 * Output: [[2],[1]]
 *
 *
 * Constraints:
 *
 * 1 <= Node.val <= 100
 * Node.val is unique for each node.
 * Number of Nodes will not exceed 100.
 * There is no repeated edges and no self-loops in the graph.
 * The Graph is connected and all nodes can be visited starting from the given node.
 */
public class Day20 {

    // Definition for a Node.
    public static class Node {
        public int val;
        public List<Node> neighbors;

        public Node() {
            val = 0;
            neighbors = new ArrayList<>();
        }

        public Node(int val) {
            this.val = val;
            this.neighbors = new ArrayList<>();
        }

        public Node(int val, ArrayList<Node> neighbors) {
            this.val = val;
            this.neighbors = neighbors;
        }
    }

    //BFS
    public Node cloneGraph(Node node) {
        if (node == null) return null;
        Queue<Node> queue = new LinkedList<>();
        queue.add(node);
        Map<Node, Node> map = new HashMap<>();
        map.put(node, new Node(node.val));
        while (!queue.isEmpty()) {
            Node current = queue.poll();
            for (Node neighbor : current.neighbors) {
                if (!map.containsKey(neighbor)) {
                    map.put(neighbor, new Node(neighbor.val));
                    queue.add(neighbor);
                }
                map.get(current).neighbors.add(map.get(neighbor));
            }
        }

        return map.get(node);
    }

    //DFS
    class Solution {
        private Map<Node, Node> map = new HashMap();
        public Node cloneGraph(Node node) {
            if(node == null)
                return null;
            if(map.containsKey(node))
                return map.get(node);
            Node root = new Node(node.val);
            map.put(node, root);
            for(Node ng : node.neighbors)
                root.neighbors.add(cloneGraph(ng));
            return root;
        }
    }

    class SolutionOther {
        public Node cloneGraph(Node node) {
            if(node == null){
                return null;
            }
            //Use bfs to get all graph nodes
            List<Node> nodes = getNodes(node);
            if(nodes.isEmpty()){
                return new Node(node.val);
            }

            //Use a map to store original node and copy node
            Map<Node, Node> map = new HashMap<>();
            //copy node first
            for(Node cur : nodes){
                map.put(cur, new Node(cur.val));
            }
            //copy neighbors
            for(Node cur : nodes){
                Node newNode = map.get(cur);
                for(Node neighbor : cur.neighbors){
                    newNode.neighbors.add(map.get(neighbor));
                }
            }

            return map.get(node);
        }

        private List<Node> getNodes(Node node){
            Queue<Node> queue = new LinkedList<>();
            Set<Node> set = new HashSet<>();
            queue.offer(node);

            while(!queue.isEmpty()){
                Node cur = queue.poll();
                for(Node neighbor : cur.neighbors){
                    if(!set.contains(neighbor)){
                        queue.offer(neighbor);
                        set.add(neighbor);
                    }
                }
            }

            return new ArrayList<>(set);
        }
    }
}
