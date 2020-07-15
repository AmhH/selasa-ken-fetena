package com.example.leet.may.week3;

/**
 *  Odd Even Linked List
 *
 * Given a singly linked list, group all odd nodes together followed by the even nodes. Please note here we are talking
 * about the node number and not the value in the nodes.
 *
 * You should try to do it in place. The program should run in O(1) space complexity and O(nodes) time complexity.
 *
 * Example 1:
 *
 * Input: 1->2->3->4->5->NULL
 * Output: 1->3->5->2->4->NULL
 * Example 2:
 *
 * Input: 2->1->3->5->6->4->7->NULL
 * Output: 2->3->6->7->1->5->4->NULL
 * Note:
 *
 * The relative order inside both the even and odd groups should remain as it was in the input.
 * The first node is considered odd, the second node even and so on ...
 */
public class Day16 {
    /**
     * Definition for singly-linked list.
     */
    public static class ListNode {
         int val;
          ListNode next;
          ListNode(int x) { val = x; }
        public void printAll(){
            System.out.print(val + "-> ");
            if (next != null){
                next.printAll();
            }
        }
      }

    public static ListNode oddEvenList(ListNode head) {
        ListNode odd = head;
        ListNode even = odd.next;
        ListNode evenHead = even;

        while(null != even && null != even.next){
            ListNode newOdd = even.next;
            odd.next = newOdd;
            even.next = newOdd.next;
            odd = odd.next;
            even = even.next;
        }

        odd.next = evenHead;
        return head;
    }

    public static void main(String[] args) {
        //1->2->3->4->5
        //2->1->3->5->6->4->7
        ListNode node1 = createNodeFromArray(new int[]{1,2,3,4,5});
        ListNode node2 = createNodeFromArray(new int[]{2,1,3,5,6,4,7});

        oddEvenList(node1).printAll();
        System.out.println();
        oddEvenList(node2).printAll();
    }
    private static ListNode createNodeFromArray(int[] ints) {
        ListNode head = new ListNode(ints[0]);
        ListNode tail = head;
        for(int i = 1; i < ints.length; i++){
            tail.next = new ListNode(ints[i]);
            tail= tail.next;
        }
        return head;
    }
}
