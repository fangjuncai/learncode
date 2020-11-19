package com.learn.java.javabase.testcode;

import java.util.Stack;

/**
 * @description
 * @author: fangjc
 * @create: 2020-11-17 21:55
 **/

/*

问题：代码撰写：实现一个特殊的Stack，跟普通Stack相比，pop/top/push的行为一致，但是额外增加一个min接口，每次调用返回当前Stack中的最小值
*/

public class MyStack {
    private Stack<Integer> stack1;
    private Stack<Integer> stack2;

    public MyStack(){
        this.stack1 =new Stack<>();

        this.stack2 = new Stack<>();
    }

    public void push(int data)
    {
        stack1.push(data);
        if(stack2.isEmpty() || data < stack2.peek()){
            stack2.push(data);
        }
    }

    public void pop(){
        if(!stack1.isEmpty())
        {
            if(stack1.peek() == stack2.peek())
            {
                stack2.pop();
            }
            stack1.pop();
        }
    }

    Integer  min(){
        if(!stack2.empty()){
            return stack2.peek();
        }
        return null;
    }

    public static void main(String[] args) {
        MyStack myStack = new MyStack();
        myStack.push(4);
        myStack.push(5);
        myStack.push(5);
        myStack.push(4);
        System.out.println(myStack.min());
        myStack.pop();
        System.out.println(myStack.min());
    }
}
