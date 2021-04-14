package com.learn.java.javabase.designpattern.proxy;

/**
 * @description
 * @author: fangjc
 * @create: 2021-04-07 11:11
 **/
public class JdkDynicMain {
    public static void main(String[] args) {
        JdkDynicProxyHander jdkDynicHander = new JdkDynicProxyHander(new HelloServiceImpl());
        //委托类加载器  被代理类的接口  委托类
        JdkDynicProxyHanderFactory factory = new JdkDynicProxyHanderFactory(jdkDynicHander);
        HelloService proxy = (HelloService) factory.getProxy();
       // HelloService proxy = (HelloService) Proxy.newProxyInstance(jdkDynicHander.getClass().getClassLoader(), jdkDynicHander.getTarget().getClass().getInterfaces(),jdkDynicHander);
        proxy.sayHello();
    }
}
