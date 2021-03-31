package com.learn.java.javabase.leecode;

/**
 * @description
 * @author: fangjc
 * @create: 2021-03-30 19:33
 **/
public class IsPalindrome {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode second = new ListNode(0);
        ListNode third = new ListNode(0);
        ListNode fourth = new ListNode(1);
        head.next = second;
        second.next = third;
        //third.next = fourth;
        System.out.println(new IsPalindrome().isPalindrome(head));
    }

    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) {
            return true;
        }
        ListNode curr = head;
        int count = 0;
        while (curr != null) {
            curr = curr.next;
            count++;
        }
        ListNode half = null;
        ListNode second = null;
        //half = getHalf(head, count);
        half = getFirstEndHalf(head);
        second = getSecond(half.next, count);
        ListNode firstNext = head;
        ListNode secondNext = second;

        while (firstNext != null && secondNext != null) {
            if (firstNext.val == secondNext.val) {
                firstNext = firstNext.next;
                secondNext = secondNext.next;
            } else {
                return false;
            }
        }

        return true;
    }

    private ListNode getSecond(ListNode head, int count) {

        head = reverseList(head);
        return head;
    }
    //用count判断
    private ListNode getHalf(ListNode head, int count) {
        int len = count / 2;
        int subCount = 0;
        ListNode current = head;
        while (current != null && subCount < len - 1) {
            current = current.next;
            subCount++;

        }
        return current;
    }
    //并没有用count好理解
    private ListNode getFirstEndHalf(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;

        }
        return slow;

    }


    private ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode prev = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }
}
