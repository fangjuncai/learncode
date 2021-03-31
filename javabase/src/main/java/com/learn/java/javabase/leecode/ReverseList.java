package com.learn.java.javabase.leecode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * @description
 * @author: fangjc
 * @create: 2021-03-30 13:51
 * <p>
 * 输入: 1->2->3->4->5->NULL
 * 输出: 5->4->3->2->1->NULL
 **/
public class ReverseList {
    public static void main(String[] args) {
        LinkedList<String> linkedList = new LinkedList<>();
        Collections.reverse(linkedList);
        ListNode head = new ListNode(1);
        ListNode second = new ListNode(2);
        ListNode third = new ListNode(3);
        head.next = second;
        second.next = third;
        ListNode current = head;
        while (current != null) {
            System.out.println(current.val);
            current = current.next;
        }
        head = new ReverseList().reverseList2(head);
        current = head;
        while (current != null) {
            System.out.println(current.val);
            current = current.next;
        }
    }

    public ListNode reverseList(ListNode head) {
        List<ListNode> listNodes = new ArrayList<>();
        if (head == null || head.next == null) {
            return head;
        }
        ListNode current = head;
        //新的值 并不是严格反转链表
        while (current != null) {
            listNodes.add(new ListNode(current.val));
            current = current.next;
        }
        int len = listNodes.size();

        ListNode prev = null;
        current = null;
        head = null;
        for (int i = 0; i < len; i++) {
            ListNode node = listNodes.get(len - 1 - i);
            if (prev == null) {
                prev = node;
                head = node;
            }
            prev.next = node;
            prev = node;
        }
        return head;
    }

    public ListNode reverseList2(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode prev = null;
        ListNode curr = head;
        while (curr != null) {
            //ListNode next = new ListNode();
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }
}
