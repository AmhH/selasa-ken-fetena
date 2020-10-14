package com.example.leet.util;

/**
 * Definition for singly-linked list.
 */
public class ListNode {
    public int val;
    public ListNode next;

    public ListNode() {
    }

    public ListNode(int x) {
        val = x;
    }

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    public void printAll() {
        System.out.print(val);
        if (next != null) {
            System.out.print("->");
            next.printAll();
        }
    }

    public static ListNode createNodeFromArray(int[] ints) {
        ListNode head = new ListNode(ints[0]);
        ListNode tail = head;
        for(int i = 1; i < ints.length; i++){
            tail.next = new ListNode(ints[i]);
            tail= tail.next;
        }
        return head;
    }
}
