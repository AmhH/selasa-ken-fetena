package com.example.leet.week2;

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

    public static void main(String[] args) {
        //1,2,3,4,5
        ListNode head =  new ListNode(1);
        ListNode head2 =  new ListNode(2);
        ListNode head3 =  new ListNode(3);
        ListNode head4 =  new ListNode(4);
        ListNode head5 =  new ListNode(5);
        head.next = head2;
        head2.next = head3;
        head3.next = head4;
        head4.next = head5;

        ListNode listNode = middleNode(head);

        while (listNode != null){
            System.out.print(listNode.val + ", ");
            listNode = listNode.next;
        }

        System.out.println("***************");
        //[1,2,3,4,5,6]
        head5.next = new ListNode(6);

        ListNode listNode2 = middleNode(head);

        while (listNode2 != null){
            System.out.print(listNode2.val + ", ");
            listNode2 = listNode2.next;
        }
    }


    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
}

