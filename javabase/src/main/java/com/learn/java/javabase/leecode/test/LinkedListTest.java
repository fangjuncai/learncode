package com.learn.java.javabase.leecode.test;

/**
 * @description
 * @author: fangjc
 * @create: 2021-01-10 15:32
 **/
public class LinkedListTest {
    public Node head = new Node(-1);
    public static void main(String[] args) {
        Node node1  = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);

        LinkedListTest test = new LinkedListTest();
        test.addNode(node1);
        test.addNode(node2);
        test.deleteNode(node2);
        //test.printAllNodeData();
        test.addNode(node3);
        test.addNode(node4);
        test.reverseNodeList();
        test.printAllNodeData();
    }
    void addNode(Node node){
        Node tmp = head;
        while(null != tmp.next)
        {
            tmp = tmp.next;
        }
        tmp.next = node;
    }
    void deleteNode(Node node){
        Node tmp = head;
        while( null != tmp.next )
        {
            if(null != tmp && null !=tmp.next ){
                Node current = tmp.next;
                if( node == current){
                    tmp.next = current.next;
                    break;
                }
            }
            tmp = tmp.next;
        }

    }
    void printAllNodeData(){
        Node tmp = head;
        while (null != tmp.next)
        {
            tmp  = tmp.next;
            System.out.println(tmp.data);
        }
    }

    void reverseNodeList(){
        Node pre = head.next;
        Node pCur= pre.next;
        while(  null != pCur)
        {
            {
               pre.next = pCur.next;
               pCur.next = head.next;
               head.next = pCur;
               pCur= pre.next;
            }
        }
    }
}
class Node{
    int data;
    Node next;
    public Node(int x){
        data =x ;
        next = null;
    }
}

