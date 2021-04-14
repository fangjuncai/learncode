package com.learn.java.javabase.designpattern.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @description
 * @author: fangjc
 * @create: 2021-04-07 10:16
 **/
public class JdkDynicProxyHander implements InvocationHandler {
    private Object target;

    public JdkDynicProxyHander(Object target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("动态代理执行");
        Object object = method.invoke(target, args);
        System.out.println("动态代理执行结束");
        return object;
    }

    public Object getTarget() {
        return target;
    }

    public void setTarget(Object target) {
        this.target = target;
    }
}
