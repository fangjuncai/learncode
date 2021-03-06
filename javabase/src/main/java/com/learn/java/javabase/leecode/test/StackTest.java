package com.learn.java.javabase.leecode.test;

import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Stack;

/**
 * @description
 * @author: fangjc
 * @create: 2021-01-08 18:55
 **/
public class StackTest {
    public static void main(String[] args) {
        test();
    }
    private static void test(){
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
        Stack<String> stringStack = new Stack<>();
        stringStack.push("1");
        stringStack.push("2");
        stringStack.push("3");
        System.out.println(stringStack);
        //摘取最后一个返回
        System.out.println(stringStack.peek());
        System.out.println(stringStack);
        //出栈返回
        System.out.println(stringStack.pop());
        System.out.println(stringStack);
        //
        System.out.println(stringStack.push("4"));
        System.out.println(stringStack);
        HashSet<Integer> hashSet =new HashSet<>();
        hashSet.add(1);
    }
}
