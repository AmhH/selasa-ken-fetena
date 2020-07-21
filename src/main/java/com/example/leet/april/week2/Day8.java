package com.example.leet.april.week2;

import com.example.leet.util.ListNode;

/**
 * Middle of the Linked List
 * Given a non-empty, singly linked list with head node head, return a middle node of linked list.
 *
 * If there are two middle nodes, return the second middle node.
 *
 * Example 1:
 *
 * Input: [1,2,3,4,5]
 * Output: Node 3 from this list (Serialization: [3,4,5])
 * The returned node has value 3.  (The judge's serialization of this node is [3,4,5]).
 * Note that we returned a ListNode object ans, such that:
 * ans.val = 3, ans.next.val = 4, ans.next.next.val = 5, and ans.next.next.next = NULL.
 * Example 2:
 *
 * Input: [1,2,3,4,5,6]
 * Output: Node 4 from this list (Serialization: [4,5,6])
 * Since the list has two middle nodes with values 3 and 4, we return the second one.
 *
 * Note:
 *
 * The number of nodes in the given list will be between 1 and 100.
 */
public class Day8 {

    public static ListNode middleNode(ListNode head) {
        ListNode temp = head;
        int count = 0;
        while(temp != null){
            count++;
            temp = temp.next;
        }

        int middle = count / 2;
        int i = 0;
        while (i < middle){
            head = head.next;
            i++;
        }
        return head;
    }

    public static ListNode middleNode2(ListNode head) { // O(len) O(1)
        ListNode fakeHead = new ListNode(-1);
        fakeHead.next = head;
        ListNode ln0 = fakeHead;
        ListNode ln1 = fakeHead;
        while (ln1.next != null && ln1.next.next != null) {
            ln0 = ln0.next;
            ln1 = ln1.next.next;
        }
        return ln0.next;
    }

    public static void main(String[] args) {
        //1,2,3,4,5
        ListNode head = ListNode.createNodeFromArray(new int[]{1,2,3,4,5});


        ListNode listNode = middleNode2(head);

        while (listNode != null){
            System.out.print(listNode.val + ", ");
            listNode = listNode.next;
        }

        System.out.println("***************");
        //[1,2,3,4,5,6,7,8]
        head = ListNode.createNodeFromArray(new int[]{1,2,3,4,5,6,7,8});

        ListNode listNode2 = middleNode2(head);

        while (listNode2 != null){
            System.out.print(listNode2.val + ", ");
            listNode2 = listNode2.next;
        }
    }

}

