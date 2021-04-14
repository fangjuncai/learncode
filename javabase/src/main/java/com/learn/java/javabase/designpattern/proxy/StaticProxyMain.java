package com.learn.java.javabase.designpattern.proxy;

/**
 * @description
 * @author: fangjc
 * @create: 2021-04-07 09:48
 **/
public class StaticProxyMain {
    public static void main(String[] args) {
        HelloService helloService = new HelloServiceImpl();
        HelloServiceStaticProxy helloServiceStaticProxy = new HelloServiceStaticProxy(helloService);
        helloServiceStaticProxy.sayHello();
    }
}
