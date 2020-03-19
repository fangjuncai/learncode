package com.learn.java.javabase.designpattern.builder;

public class Director {
    public static House build(Builder builder){
        return  builder.buildBuleprint("buluptint").buildPartA("part a").buildPartB("part b").build();
    }
}
