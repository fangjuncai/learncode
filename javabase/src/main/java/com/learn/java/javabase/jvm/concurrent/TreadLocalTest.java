package com.learn.java.javabase.jvm.concurrent;

/**
 * @description
 * @author: fangjc
 * @create: 2020-11-26 18:56
 **/
public class TreadLocalTest {

    static ThreadLocal<String> stringThreadLocal = new ThreadLocal<>();
    static ThreadLocal<String> stringThreadLocalB = new ThreadLocal<>();
    public static void main(String[] args) {
        stringThreadLocal.set("main");
        stringThreadLocalB.set("mainB");
        System.out.println(stringThreadLocal.get());
        new Thread(new Runnable() {
            @Override
            public void run() {
                stringThreadLocal.set("t1");
                System.out.println(stringThreadLocal.get());

                stringThreadLocalB.set("B t1");
                System.out.println(stringThreadLocalB.get());
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                stringThreadLocal.set("t2");
                System.out.println(stringThreadLocal.get());
            }
        }).start();
        System.out.println(stringThreadLocal.get());
    }
}
