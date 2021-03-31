package com.learn.java.javabase.leecode;

/**
 * @description
 * @author: fangjc
 * @create: 2021-03-30 19:33
 **/
public class ListNode {
    int val;
    ListNode next;

    public ListNode(int val) {
        this.val = val;
        this.next = null;
    }
    public ListNode(int val,ListNode next){
        this.val= val;
        this.next=next;
    }
    public ListNode(){
        this.next = null;
    }

}
