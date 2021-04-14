package com.learn.java.javabase.designpattern.proxy;

/**
 * @description
 * @author: fangjc
 * @create: 2021-04-07 09:44
 **/
public class HelloServiceStaticProxy implements HelloService{
    private HelloService helloService;

    public HelloServiceStaticProxy(HelloService helloService) {
        this.helloService = helloService;
    }

    @Override
    public void sayHello() {
        System.out.println("代理执行");
        this.helloService.sayHello();
        System.out.println("代理执行结束");
    }

    public static void main(String[] args) {

    }
}
