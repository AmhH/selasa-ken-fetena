package com.example.leet.october.week1;

import com.example.leet.util.ListNode;

/**
 * Rotate List
 * Given a linked list, rotate the list to the right by k places, where k is non-negative.
 *
 * Example 1:
 *
 * Input: 1->2->3->4->5->NULL, k = 2
 * Output: 4->5->1->2->3->NULL
 * Explanation:
 * rotate 1 steps to the right: 5->1->2->3->4->NULL
 * rotate 2 steps to the right: 4->5->1->2->3->NULL
 * Example 2:
 *
 * Input: 0->1->2->NULL, k = 4
 * Output: 2->0->1->NULL
 * Explanation:
 * rotate 1 steps to the right: 2->0->1->NULL
 * rotate 2 steps to the right: 1->2->0->NULL
 * rotate 3 steps to the right: 0->1->2->NULL
 * rotate 4 steps to the right: 2->0->1->NULL
 */
public class Day7 {
    public ListNode rotateRight(ListNode head, int k) {
        if(null == head || k == 0){
            return head;
        }
        ListNode node = head;
        int length = 1;
        while (null != node.next){
            length++;
            node = node.next;
        }

        k %= length;
        node.next = head;
        for (int i = 0; i < length - k; i++) {
            node = node.next;
        }
        head = node.next;
        node.next = null;

        return head;
    }
}
