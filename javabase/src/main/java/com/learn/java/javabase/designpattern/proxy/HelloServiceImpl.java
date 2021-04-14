package com.learn.java.javabase.designpattern.proxy;

/**
 * @description
 * @author: fangjc
 * @create: 2021-04-07 09:42
 **/
public class HelloServiceImpl implements HelloService{
    @Override
    public void sayHello() {
        System.out.println("hello");
    }
}
