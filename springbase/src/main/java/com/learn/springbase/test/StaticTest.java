package com.learn.springbase.test;

/**
 * @description
 * @author: fangjc
 * @create: 2021-02-24 11:09
 **/
public class StaticTest {
    public  int getId() {
        return this.id;
    }

    public  void setId(int id) {
        this.id = id;
    }

    public static void main(String[] args) {
        System.out.println("hello");
        StaticTest staticTest = new StaticTest();
        staticTest.setId(100);
        System.out.println(staticTest.getId());
        System.out.println(StaticTest.id);
    }

    public static int id;

}
