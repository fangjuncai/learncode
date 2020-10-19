package com.learn.java.javabase.thread;

import java.util.HashMap;

/**
 * @program: javabase
 * @description
 * @author: fangjc
 * @create: 2020-06-04 19:35
 **/
public class Main01 {
    public static void main(String[] args) {
        System.out.println(Long.MAX_VALUE);
        System.out.println(Long.MAX_VALUE/1024/1024/1024/1024); }

    public static int testFinally() {
        int i;
        try {
            i = 1;
           // throw  new Exception();
            return i;
        } catch (Exception e) {
            i = 2;
            return i;
        } finally {
            i = 3;
            return i;
        }
    }
}
