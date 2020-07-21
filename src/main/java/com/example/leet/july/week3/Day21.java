package com.example.leet.july.week3;

import com.example.leet.util.ListNode;

/**
 * Remove Linked List Elements
 * Remove all elements from a linked list of integers that have value val.
 *
 * Example:
 *
 * Input:  1->2->6->3->4->5->6, val = 6
 * Output: 1->2->3->4->5
 */
public class Day21 {

    public static ListNode removeElements(ListNode head, int val) {
        if(head == null){
            return null;
        }
        ListNode node = new ListNode(-1);
        node.next = head;
        head = node;
        while(node.next != null){
            if(node.next.val == val){
                node.next = node.next.next;
            }else {
                node = node.next;
            }
        }

        return head.next;
    }

    public static void main(String[] args) {
        ListNode head = ListNode.createNodeFromArray(new int[]{1, 2, 6, 3, 4, 5, 6});
        ListNode node = removeElements(head, 6);
        node.printAll();
    }

    public ListNode removeElements1(ListNode head, int val) {
        if(head == null) {
            return null;
        }
        ListNode ret = removeElements1(head.next, val);

        if(head.val == val) {
            return ret;
        }

        head.next = ret;
        return head;
    }
}
