package com.learn.java.javabase.leecode;

/**
 * @description
 * @author: fangjc
 * @create: 2021-03-25 13:55
 **/

/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode() {}
 * ListNode(int val) { this.val = val; }
 * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

public class RemoveNthFromEnd {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode second = new ListNode(2);
        ListNode third = new ListNode(3);
        ListNode fourth = new ListNode(4);
        ListNode fifth = new ListNode(5);
        head.next = second;
        second.next = third;
        third.next = fourth;
        fourth.next = fifth;
        System.out.println(new RemoveNthFromEnd().removeNthFromEnd2(head, 2));
    }

    public ListNode removeNthFromEnd2(ListNode head, int n) {
        ListNode first = head;
        ListNode dummy = new ListNode(0,head);
        ListNode second=dummy;
        int count = 0;
        while (count < n) {
            first = first.next;
            count++;
        }
        while (first != null) {
            first = first.next;
            second = second.next;
        }
        second.next = second.next.next;

        return dummy.next;
    }

    public ListNode removeNthFromEnd(ListNode head, int n) {
        int count = 0;
        int len = 0;
        ListNode cur = head;
        while (cur != null) {
            len++;
            cur = cur.next;
        }

        cur = head;
        ListNode prev = head;
        int index = len - n;
        if (index == 0) {
            return head.next;
        }
        while (cur != null) {
            if (index == count) {
                ListNode next = cur.next;
                prev.next = next;
                return head;
            } else {
                prev = cur;
                cur = cur.next;
                count++;
            }
        }
        return null;
    }

    static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

}
