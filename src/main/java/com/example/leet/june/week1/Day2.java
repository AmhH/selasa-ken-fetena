package com.example.leet.june.week1;

import com.example.leet.util.ListNode;

/**
 * Delete Node in a Linked List
 * Write a function to delete a node (except the tail) in a singly linked list, given only access to that node.
 *
 * Given linked list -- head = [4,5,1,9], which looks like following:
 *
 * Example 1:
 *
 * Input: head = [4,5,1,9], node = 5
 * Output: [4,1,9]
 * Explanation: You are given the second node with value 5, the linked list should become 4 -> 1 -> 9 after calling your function.
 * Example 2:
 *
 * Input: head = [4,5,1,9], node = 1
 * Output: [4,5,9]
 * Explanation: You are given the third node with value 1, the linked list should become 4 -> 5 -> 9 after calling your function.
 *
 *
 * Note:
 *
 * The linked list will have at least two elements.
 * All of the nodes' values will be unique.
 * The given node will not be the tail and it will always be a valid node of the linked list.
 * Do not return anything from your function.
 */
public class Day2 {

    public static void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }

    public static void main(String[] args) {
          //head = [4,5,1,9], node = 5
        //head = [4,5,1,9], node = 1
        ListNode n4 = new ListNode(4);
        ListNode n5 = new ListNode(5);
        ListNode n1 = new ListNode(1);
        ListNode n9 = new ListNode(9);

        n4.next = n5;
        n5.next = n1;
        n1.next = n9;

        ListNode head1 = n4;
        while(head1 != null){
            System.out.print(head1.val + ", ");
            head1 = head1.next;
        }
        System.out.println();
        System.out.println("***************");
        deleteNode(n5);

        ListNode head = n4;
        while(head != null){
            System.out.print(head.val + ", ");
            head = head.next;
        }

    }
}
