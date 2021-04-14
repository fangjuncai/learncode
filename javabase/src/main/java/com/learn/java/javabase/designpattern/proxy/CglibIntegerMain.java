package com.learn.java.javabase.designpattern.proxy;

/**
 * @description
 * @author: fangjc
 * @create: 2021-04-07 16:21
 **/
public class CglibIntegerMain {
    public static void main(String[] args) {
        CglibInterceptor cglibInterceptor = new CglibInterceptor();
        HelloService helloServiceProxy = (HelloService) cglibInterceptor.getProxy(HelloServiceImpl.class);
        helloServiceProxy.sayHello();

        HelloServiceImpl HelloServiceImplProxy = (HelloServiceImpl) cglibInterceptor.getProxy(HelloServiceImpl.class);
        HelloServiceImplProxy.sayHello();
    }
}
