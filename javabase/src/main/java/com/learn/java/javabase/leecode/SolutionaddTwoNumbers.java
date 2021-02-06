package com.learn.java.javabase.leecode;

/**
 * @program: javabase
 * @description
 * @author: fangjc
 * @create: 2020-08-16 23:00
 **/

/**
 * 给出两个非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照逆序的方式存储的，并且它们的每个节点只能存储一位数字。
 * <p>
 * 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
 * <p>
 * 您可以假设除了数字 0 之外，这两个数都不会以 0开头。
 * <p>
 * 示例：
 * <p>
 * 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
 * 输出：7 -> 0 -> 8
 * 原因：342 + 465 = 807
 * <p>
 * 示例 2：
 * <p>
 * 输入：l1 = [0], l2 = [0]
 * 输出：[0]
 * 示例 3：
 * <p>
 * 输入：l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]
 * 输出：[8,9,9,9,0,0,0,1]
 * <p>
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/add-two-numbers
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode(int x) { val = x; }
 * }
 */
public class SolutionaddTwoNumbers {
    public static void main(String[] args) {
        ListNode nodes = new ListNode(1);
        nodes.next = new ListNode(2);
        ListNode nodes2 = new ListNode(1);
        nodes2.next = new ListNode(2);
        System.out.println(addTwoNumbers(nodes, nodes2));
    }

    /**
     * 链表相加+进位carry=sum
     * 当前位数sum%/10
     * 下一个进位sum/10
     * @param l1
     * @param l2
     * @return
     */

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = null;
        ListNode current = null;
        int carray = 0;
        while (l1 != null || l2 != null) {

            int sum = 0;
            int int1 = 0;
            int int2 = 0;
            if (l1 != null) {
                int1 = l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                int2 = l2.val;
                l2 = l2.next;
            }
            sum = int1 + int2 + carray;
            if (head == null) {
                head = current = new ListNode(sum % 10);
            } else {
                //下一个节点
                current.next = new ListNode(sum % 10);
                //维护列表顺序
                current = current.next;
            }
            //下一个进位
            carray = sum / 10;


        }
        if (carray > 0) {
            current.next = new ListNode(carray);
        }
        return head;
    }

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }

        ListNode() {
            val = 0;
            next = null;

        }

        @Override
        public String toString() {
            return "ListNode{" +
                    "val=" + val +
                    ", next=" + next +
                    '}';
        }
    }
}

