package com.example.leet.practice;

import com.example.leet.util.ListNode;

/**
 * Merge two sorted linked lists and return it as a new sorted list. The new list should be made by splicing together
 * the nodes of the first two lists.
 *
 * Example:
 *
 * Input: 1->2->4, 1->3->4
 * Output: 1->1->2->3->4->4
 */
public class MergeTwoSortedList {

    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1 == null) return l2;
        if(l2 == null) return l1;
        if(l1.val < l2.val){
            l1.next = mergeTwoLists(l1.next, l2);
            return l1;
        } else{
            l2.next = mergeTwoLists(l1, l2.next);
            return l2;
        }
    }

    public static void main(String[] args) {
        ListNode node1 = mergeTwoLists(ListNode.createNodeFromArray(new int[]{1, 2, 4}),
                ListNode.createNodeFromArray(new int[]{1, 3, 4}));
        ListNode node2 = mergeTwoLists2(ListNode.createNodeFromArray(new int[]{1, 3, 4}),
                ListNode.createNodeFromArray(new int[]{1, 2, 4}));
        System.out.println(node1 + " " + node2);
    }

    public static ListNode mergeTwoLists2(ListNode l1, ListNode l2) {
        ListNode preHead = new ListNode(0);
        ListNode last = preHead;

        while(l1 != null && l2 != null) {
            if(l1.val > l2.val) {
                last.next = l2;
                l2 = l2.next;
            } else {
                last.next = l1;
                l1 = l1.next;
            }
            last = last.next;
        }

        if(l1 == null) {
            last.next = l2;
        } else {
            last.next = l1;
        }

        return preHead.next;
    }
}
