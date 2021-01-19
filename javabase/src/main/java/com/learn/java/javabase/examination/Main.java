package com.learn.java.javabase.examination;

/**
 * @description
 * @author: fangjc
 * @create: 2021-01-10 20:47
 **/

import java.util.*;

//链表
class MyNode {
    int val;
    MyNode next;
    public MyNode(int val) {
        this.val = val;
    }
}

//自定义比较器
class Comparators {


    private static Comparator comparator = null;

    public static Comparator getComparator() {
        if(comparator == null) {
            comparator = new Comparator() {
                public int compare(Object ob1, Object ob2) {
                    if(ob1 instanceof MyNode) return compare((MyNode)ob1, (MyNode)ob2);
                    return 1;
                }

                //自定义链表排序规则
                public int compare(MyNode n1, MyNode n2) {
                    return n1.val - n2.val;
                }
            };
        }
        return comparator;
    }
}

public class Main {

    //将无序单链表转化为有序单链表
    public static MyNode sortOfList(MyNode p) {
        //暂存链表结点
        ArrayList<MyNode> arr = new ArrayList<MyNode>();
        MyNode temp = p;
        while (temp != null) {
            arr.add(temp);
            temp = temp.next;
        }
        Collections.sort(arr, (o1, o2) -> {
            if(o1 instanceof MyNode){
                return o1.val-o2.val;
            }
            return 1;
        });

        MyNode ans = arr.get(0);
        MyNode temp2 = ans;
        for (int i = 1; i < arr.size(); i++) {
            temp2.next = arr.get(i);
            temp2 = temp2.next;
        }
        temp2 = null;

        return ans;
    }
    //两个无序单链表p1,p2合并成一个有序单链表
    //表1的头结点的值小于链表2 的头结点的值，因此链表1的头结点是合并后链表的头结点。
    // 在剩余的结点中，链表2 的头结点的值小于链表1的头结点的值，因此链表2的头结点是剩余结点的头结点，把这个结点和之前已经合并好的链表的尾结点链接起来
    public static  MyNode mergeList2(MyNode p1, MyNode p2) {
        if (p1 == null)
            return p2;
        if (p2 == null)
            return p1;
        if (p1.val < p2.val) {
            p1.next = mergeList2(p1.next, p2);
            return p1;
        } else {
            p2.next = mergeList2(p1, p2.next);
            return p2;
        }
    }

    public static  MyNode mergeList3(MyNode p1, MyNode p2) {
        MyNode p1Current = p1;
        MyNode p2Current = p2;

        while(p1.val < p2.val){
            
        }
        return null;
    }

    //两个无序单链表p1,p2合并成一个有序单链表
    public static MyNode mergeList(MyNode p1, MyNode p2) {

        //得到有序单链表
        MyNode p11 = sortOfList(p1);
        MyNode p22 = sortOfList(p2);


        //合并单链表
        MyNode ans;
        MyNode temp1 = p11;
        MyNode temp2 = p22;
        if (temp1.val <= temp2.val) {
            ans = temp1;
            temp1 = temp1.next;
        } else {
            ans = temp2;
            temp2 = temp2.next;
        }
        MyNode temp = ans;
        while (temp1 != null && temp2 != null) {
            if (temp1.val <= temp2.val) {
                temp.next = temp1;
                temp1 = temp1.next;
            } else {
                temp.next = temp2;
                temp2 = temp2.next;
            }
            temp = temp.next;
        }
        while (temp1 != null) {
            temp.next = temp1;
            temp = temp.next;
            temp1 = temp1.next;
        }
        while (temp2 != null) {
            temp.next = temp2;
            temp = temp.next;
            temp2 = temp2.next;
        }
        temp = null;
        return ans;
    }

    //测试
    public static void main(String[] args) {
        MyNode p1 = new MyNode(1);
        p1.next = new MyNode(3);

        p1.next.next = new MyNode(99);



        MyNode p2 = new MyNode(2);
        p2.next = new MyNode(9);
        p2.next.next = new MyNode(10);


        //MyNode ans = mergeList(p1, p2);
        MyNode ans = mergeList2(p1, p2);
        MyNode temp = ans;
        while (temp != null) {
            System.out.print(temp.val + " ");
            temp = temp.next;
        }
        System.out.println();
    }
}
