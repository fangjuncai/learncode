package com.learn.java.javabase.designpattern.proxy;

import java.lang.reflect.Proxy;

/**
 * @description
 * @author: fangjc
 * @create: 2021-04-07 11:21
 **/
public class JdkDynicProxyHanderFactory {
    public JdkDynicProxyHanderFactory(JdkDynicProxyHander jdkDynicProxyHander) {
        this.jdkDynicProxyHander = jdkDynicProxyHander;
    }

    private JdkDynicProxyHander jdkDynicProxyHander;


    public Object getProxy(){
        Object target = jdkDynicProxyHander.getTarget();
        Object proxy= Proxy.newProxyInstance(jdkDynicProxyHander.getClass().getClassLoader(), target.getClass().getInterfaces(),jdkDynicProxyHander);
        return proxy;
    }
}
