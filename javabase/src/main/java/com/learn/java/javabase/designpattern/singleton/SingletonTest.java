package com.learn.java.javabase.designpattern.singleton;

/**
 * @description
 * @author: fangjc
 * @create: 2021-04-15 14:07
 **/
public class SingletonTest {
    public static void main(String[] args) {

        HungerSingleton.getInstance().test();
        LazySingleton1.getInstance().test();
        LazySingleton.getInstance().test();
    }
}
