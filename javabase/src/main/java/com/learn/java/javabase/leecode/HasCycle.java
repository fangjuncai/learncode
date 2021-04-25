package com.learn.java.javabase.leecode;

/**
 * @description
 * @author: fangjc
 * @create: 2021-04-21 10:55
 **/
public class HasCycle {
    public boolean hasCycle(ListNode head) {
        if (head == null) {
            return false;
        }
        ListNode slow = head.next;
        if (slow == null) {
            return false;
        }
        ListNode fast = slow.next;
        if (fast == null) {
            return false;
        }
        while (fast != null && slow != null) {
            if (slow == fast) {
                return true;
            }
            slow = slow.next;
            if(fast.next==null){
                return false;
            }else {
                fast = fast.next.next;
            }

        }
        return false;

    }
}
/*
141. 环形链表
给定一个链表，判断链表中是否有环。

如果链表中有某个节点，可以通过连续跟踪 next 指针再次到达，则链表中存在环。 为了表示给定链表中的环，我们使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。 如果 pos 是 -1，则在该链表中没有环。注意：pos 不作为参数进行传递，仅仅是为了标识链表的实际情况。

如果链表中存在环，则返回 true 。 否则，返回 false 。

输入：head = [3,2,0,-4], pos = 1
输出：true
解释：链表中有一个环，其尾部连接到第二个节点。

输入：head = [1,2], pos = 0
输出：true
解释：链表中有一个环，其尾部连接到第一个节点。

输入：head = [1], pos = -1
输出：false
解释：链表中没有环。
 */
