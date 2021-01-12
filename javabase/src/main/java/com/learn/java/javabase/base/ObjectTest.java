package com.learn.java.javabase.base;

import java.util.ArrayList;

/**
 * @description
 * @author: fangjc
 * @create: 2020-12-18 13:53
 **/
public class ObjectTest {
    public static void main(String[] args) {
        //7ba4f24f 2074407503
        Object object = new Object();
        System.out.println(object.toString());
        ArrayList<String> list = new ArrayList<>();
        System.out.println(object.hashCode());
    }
}
