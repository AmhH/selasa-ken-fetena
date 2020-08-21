package com.example.leet.august.week3;

import com.example.leet.util.ListNode;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Reorder List
 * Given a singly linked list L: L0→L1→…→Ln-1→Ln,
 * reorder it to: L0→Ln→L1→Ln-1→L2→Ln-2→…
 *
 * You may not modify the values in the list's nodes, only nodes itself may be changed.
 *
 * Example 1:
 *
 * Given 1->2->3->4, reorder it to 1->4->2->3.
 * Example 2:
 *
 * Given 1->2->3->4->5, reorder it to 1->5->2->4->3.
 */
public class Day20 {
    public static void reorderList(ListNode head) {
        if(null == head || null == head.next)
            return;
        Deque<ListNode> stack = new ArrayDeque<>();
        ListNode slow = head;
        ListNode fast = head;
        while (null!= fast && null != fast.next){
            slow = slow.next;
            fast = fast.next.next;
        }
        while (null != slow){
            stack.push(slow);
            slow = slow.next;
        }
        ListNode node = head;
        while (!stack.isEmpty()){
            ListNode temp = stack.poll();
            temp.next = node.next;
            node.next = temp;
            node = temp.next;
        }
        node.next = null;
    }

    public static void main(String[] args) {
        ListNode listNode1 = ListNode.createNodeFromArray(new int[]{1, 2, 3, 4});
        ListNode listNode2 = ListNode.createNodeFromArray(new int[]{1, 2, 3, 4, 5});
        reorderList(listNode1);
        reorderList2(listNode2);
        System.out.println();
    }

    public static void reorderList2(ListNode head) {
        if (head == null) return;

        // find the middle of linked list [Problem 876]
        // in 1->2->3->4->5->6 find 4
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // reverse the second part of the list [Problem 206]
        // convert 1->2->3->4->5->6 into 1->2->3->4 and 6->5->4
        // reverse the second half in-place
        ListNode prev = null, curr = slow, tmp;
        while (curr != null) {
            tmp = curr.next;

            curr.next = prev;
            prev = curr;
            curr = tmp;
        }

        // merge two sorted linked lists [Problem 21]
        // merge 1->2->3->4 and 6->5->4 into 1->6->2->5->3->4
        ListNode first = head, second = prev;
        while (second.next != null) {
            tmp = first.next;
            first.next = second;
            first = tmp;

            tmp = second.next;
            second.next = first;
            second = tmp;
        }
    }
}
