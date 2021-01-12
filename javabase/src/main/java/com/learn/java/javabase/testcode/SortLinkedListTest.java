package com.learn.java.javabase.testcode;

/**
 * @description
 * @author: fangjc
 * @create: 2021-01-10 20:13
 **/

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 * 对两个无序链表，合并成一个有序链表
 */
public class SortLinkedListTest {
    public static void main(String[] args) {
        MyNode p1 = new MyNode(3);
        p1.next = new MyNode(5);
        p1.next.next = new MyNode(7);
        p1.next.next = new MyNode(100);


        MyNode p2 = new MyNode(2);
        p2.next = new MyNode(4);
        p2.next.next = new MyNode(6);
        MyNode sortNodeList = mergeList(p1,p2);
        MyNode temp = sortNodeList;
        while(temp !=null){
            System.out.println(temp.val + " ");
            temp =temp.next;
        }
    }

    public static MyNode sortList(MyNode p){
        ArrayList<MyNode> arr = new ArrayList<>();
        MyNode temp = p;
        while (temp != null)
        {
            arr.add(temp);
            temp = temp.next;
        }
        Collections.sort(arr,Comprators.getComparator());

        MyNode first = arr.get(0);
        MyNode temp2 = first;

        for( int i =1 ;i<arr.size() ;i++)
        {
            temp2.next = arr.get(i);
            temp2 =temp2.next;

        }
        temp2 = null;
        return first;
    }


    public static MyNode mergeList(MyNode p1, MyNode p2){
        MyNode sortP1 = sortList(p1);
        MyNode sortP2 = sortList(p2);
        //合并链表
        MyNode ans ;
        MyNode temp1 = sortP1;
        MyNode temp2 = sortP2;
        if(temp1.val <= temp2.val)
        {
            ans = temp1;
            temp1 = temp1.next;
        }else{
            ans = temp2;
            temp2 = temp2.next;
        }

        MyNode temp = ans;

        while(temp1 != null && temp2 !=null){
            if(temp1.val <= temp2.val)
            {
                temp.next = temp1;
                temp1 = temp1.next;
            }else{
                temp.next = temp2;
                temp2 = temp2.next;
            }
            temp = temp.next;
        }
        while(temp1!=null){
            temp.next = temp1;
            temp = temp.next;
            temp1= temp1.next;
        }
        while(temp2!=null){
            temp.next = temp2;
            temp = temp.next;
            temp2= temp2.next;
        }
        temp = null;
        return  ans;
    }
}


class Comprators {
    private static Comparator comparator = null;

    public static Comparator getComparator() {
        if(comparator == null){
            comparator = new Comparator() {
                @Override
                public int compare(Object o1, Object o2) {
                    if(o1 instanceof MyNode){
                        return ((MyNode) o1).val-((MyNode) o2).val;
                        //return 1;
                    }
                    return 1;
                }

            };
        }
        return comparator;
    }

}