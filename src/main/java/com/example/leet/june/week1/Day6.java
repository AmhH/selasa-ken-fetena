package com.example.leet.june.week1;

import java.util.*;

/**
 * Queue Reconstruction by Height
 * Suppose you have a random list of people standing in a queue. Each person is described by a pair of integers (h, k),
 * where h is the height of the person and k is the number of people in front of this person who have a height greater
 * than or equal to h. Write an algorithm to reconstruct the queue.
 *
 * Note:
 * The number of people is less than 1,100.
 *
 * Example
 *
 * Input:
 * [[7,0], [4,4], [7,1], [5,0], [6,1], [5,2]]
 *
 * Output:
 * [[5,0], [7,0], [5,2], [6,1], [4,4], [7,1]]
 *
 *    Hide Hint #1
 * What can you say about the position of the shortest person?
 * If the position of the shortest person is i, how many people would be in front of the shortest person?
 *
 *    Hide Hint #2
 * Once you fix the position of the shortest person, what can you say about the position of the second shortest person?
 */
public class Day6 {

    /**
     * Arrays.sort(people, Comparator.comparing((int[] e) -> e[0])
     *                     .reversed().thenComparing((int[] e) -> e[1]));
     * @param people
     * @return
     */
    public static int[][] reconstructQueue(int[][] people) {

        Arrays.sort(people, (a, b) -> a[0] == b[0] ? a[1] - b[1] : b[0] - a[0]);
        List<int[]> res = new ArrayList<>();
        for(int[] p : people){
            res.add(p[1], p);
        }
        int n = people.length;
        return res.toArray(new int[n][2]);
    }

    public static void main(String[] args) {
        System.out.println(Arrays.deepToString(reconstructQueue(new int[][]{{7,0}, {4,4}, {7,1}, {5,0}, {6,1}, {5,2}})));
        System.out.println(Arrays.deepToString(new Day6().reconstructQueue2(new int[][]{{7,0}, {4,4}, {7,1}, {5,0}, {6,1}, {5,2}})));
        System.out.println(Arrays.deepToString(new Day6().reconstructQueue3(new int[][]{{7,0}, {4,4}, {7,1}, {5,0}, {6,1}, {5,2}})));
    }

    public class Node implements Comparable<Node> {
        int ht;
        int id;
        Node(int h,int i) {
            ht=h;
            id=i;
        }
        public int compareTo(Node n) {
            if(n.ht!=this.ht) {
                return n.ht-this.ht;
            }
            return this.id-n.id;
        }
    }
    public int[][] reconstructQueue2(int[][] people) {
        PriorityQueue<Node> pq=new PriorityQueue();
        for(int i=0;i<people.length;i++) {
            pq.add(new Node(people[i][0],people[i][1]));
        }
        ArrayList<Node> rv=new ArrayList();
        while(pq.size()!=0) {
            Node n=pq.remove();
            int id=n.id;
            if(id>rv.size()) {
                rv.add(n);
            }
            else {
                rv.add(id,n);
            }

        }
        int r[][]=new int[people.length][2];
        for(int i=0;i<people.length;i++) {
            Node n=rv.get(i);
            r[i][0]=n.ht;
            r[i][1]=n.id;
        }
        return r;
    }

    public int[][] reconstructQueue3(int[][] people) {
        if (people == null || people.length == 0) {
            return new int[0][0];
        }
        // in order of height -> pos
        Queue<int[]> heap = new PriorityQueue<>(people.length, (a, b) -> {
            int result = Integer.compare(b[0], a[0]);
            return result == 0 ? Integer.compare(a[1], b[1]) : result;
        });
        for (int[] person : people) {
            heap.offer(person);
        }
        List<int[]> result = new ArrayList<>();
        while (!heap.isEmpty()) {
            int[] curr = heap.poll();
            result.add(curr[1], curr);
        }
        return result.toArray(new int[people.length][2]);
    }
}
