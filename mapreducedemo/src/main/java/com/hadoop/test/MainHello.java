package com.hadoop.test;

import com.hadoop.mapreducedemo.mapper.MyMapperTask;

public class MainHello {
    public static void main(String[] args) {
        System.out.println("welcome");
        Class <?> c1= MyMapperTask.class;
        System.out.println(c1.toString());
    }
}
