package com.learn.java.javabase.leecode.test;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @description
 * @author: fangjc
 * @create: 2021-01-08 22:58
 **/
public class QueueTest {
    public static void main(String[] args) {
        test();
    }
    private static void test(){
        Queue<String> queue = new LinkedList<>();
        //add remove会抛出illaglStateExp remove会抛出异常
        queue.add("1");
        queue.add("2");
        queue.add("3");
        System.out.println(queue);
        //会返回 null if this queue is empty
        System.out.println(queue.peek());
        //为空抛出异常
        System.out.println(queue.element());
        System.out.println(queue);
        System.out.println(queue.poll());
        System.out.println(queue);
        System.out.println(queue.remove());
        System.out.println(queue);
        System.out.println(queue.remove());
        //NoSuchElementException
        //System.out.println(queue.remove());
        System.out.println(queue.peek());
        //class NoSuchElementException extends RuntimeException {
        //System.out.println(queue.element());


    }
}
