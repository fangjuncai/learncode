package com.learn.java.javabase.test;

/**
 * @description
 * @author: fangjc
 * @create: 2020-10-20 20:38
 **/
public class Main01 {
    public static void main(String[] args) {
        String [] strArr = new String [3];
        strArr[1] = "test";
        System.out.println(strArr.toString());
        ThreadLocal<String> stringThreadLocal = new ThreadLocal<>();
        InheritableThreadLocal<String> stringInheritableThreadLocal = new InheritableThreadLocal<>();
    }
}
