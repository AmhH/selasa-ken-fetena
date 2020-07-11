package com.example.leet.july.week2;

import java.util.Stack;

/**
 * Flatten a Multilevel Doubly Linked List
 * You are given a doubly linked list which in addition to the next and previous pointers, it could have a child
 * pointer, which may or may not point to a separate doubly linked list. These child lists may have one or more
 * children of their own, and so on, to produce a multilevel data structure, as shown in the example below.
 *
 * Flatten the list so that all the nodes appear in a single-level, doubly linked list. You are given the head of the
 * first level of the list.
 *
 *
 *
 * Example 1:
 *
 * Input: head = [1,2,3,4,5,6,null,null,null,7,8,9,10,null,null,11,12]
 * Output: [1,2,3,7,8,11,12,9,10,4,5,6]
 * Explanation:
 *
 * The multilevel linked list in the input is as follows:
 *
 *
 *
 * After flattening the multilevel linked list it becomes:
 *
 *
 * Example 2:
 *
 * Input: head = [1,2,null,3]
 * Output: [1,3,2]
 * Explanation:
 *
 * The input multilevel linked list is as follows:
 *
 *   1---2---NULL
 *   |
 *   3---NULL
 * Example 3:
 *
 * Input: head = []
 * Output: []
 *
 *
 * How multilevel linked list is represented in test case:
 *
 * We use the multilevel linked list from Example 1 above:
 *
 *  1---2---3---4---5---6--NULL
 *          |
 *          7---8---9---10--NULL
 *              |
 *              11--12--NULL
 * The serialization of each level is as follows:
 *
 * [1,2,3,4,5,6,null]
 * [7,8,9,10,null]
 * [11,12,null]
 * To serialize all levels together we will add nulls in each level to signify no node connects to the upper node of
 * the previous level. The serialization becomes:
 *
 * [1,2,3,4,5,6,null]
 * [null,null,7,8,9,10,null]
 * [null,11,12,null]
 * Merging the serialization of each level and removing trailing nulls we obtain:
 *
 * [1,2,3,4,5,6,null,null,null,7,8,9,10,null,null,11,12]
 *
 *
 * Constraints:
 *
 * Number of Nodes will not exceed 1000.
 * 1 <= Node.val <= 10^5
 */
public class Day10 {

    public Node flatten(Node head) {
        if(head == null || (head.next == null && head.child == null))
            return head;
        Stack<Node> stack = new Stack<>();
        Node temp = head;
        while (temp != null || !stack.isEmpty()){
            if(temp.child != null){
                if(temp.next != null)
                    stack.push(temp.next);
                temp.next = temp.child;
                temp.child.prev = temp;
                temp.child = null;
            }else if(temp.next == null && !stack.isEmpty()){
                temp.next = stack.pop();
                temp.next.prev = temp;
            }
            temp = temp.next;
        }
        return head;
    }

    public static void main(String[] args) {
        /**
         * [1,2,3,4,5,6,null]
         * [7,8,9,10,null]
         * [11,12,null]
         */
        Node l1 = createNode(new int[]{1,2,3,4,5,6});
        Node l2 = createNode(new int[]{7,8,9,10});
        Node l3 = createNode(new int[]{11,12});
        attachNode(l2, l3, 1);
        attachNode(l1, l2, 2);
        System.out.println("Hello");
        Node flatten = new Day10().flatten(l1);
        System.out.println("Done");

        while (flatten != null){
            System.out.print(flatten.val + " ");
            if(flatten.child != null)
                System.err.println("WRONG");
            flatten = flatten.next;
        }

    }

    private static void attachNode(Node parent, Node child, int index) {
        while (--index >= 0){
            parent = parent.next;
        }

        parent.child = child;
    }

    public static Node createNode(int[] array){
        Node head = new Node(array[0]);
        Node tail = head;
        for (int i = 1; i < array.length; i++) {
            Node node = new Node(array[i]);
            tail.next = node;
            node.prev = tail;
            tail = tail.next;
        }

        return head;
    }
    /*
// Definition for a Node.
*/
static class Node {
    public int val;
    public Node prev;
    public Node next;
    public Node child;
    public Node(int val){
        this.val = val;
    }
}

    class Solution {
        public Node flatten(Node head) {
            if (head == null) return head;
            Node current = head;
            while (current != null) {
                if (current.child == null) {
                    current = current.next;
                    continue;
                }
                Node temp = current.child;
                while (temp.next != null)
                    temp = temp.next;
                temp.next = current.next;  // Connect child tail with current.next, if it is not null
                if (current.next != null) current.next.prev = temp; // if current.next is not null then change the prev of current.next to temp
                // Connect node with current.child, and remove current.child make it null
                current.next = current.child;
                current.child.prev = current;
                current.child = null;
            }
            return head;
        }
    }

    class Solution1 {
        public Node flatten(Node head) {
            return dfs(head);
        }

        Node dfs(Node node){
            if(node == null) return null;
            Node next = node.next;
            Node child = dfs(node.child);
            node.child = null;
            if(child!=null){
                node.next = child;
                child.prev = node;
                while(child.next!=null) child = child.next;
                child.next = dfs(next);
                if(child.next!=null) child.next.prev = child;
            } else {
                node.next = dfs(next);
            }

            return node;
        }
    }

}
