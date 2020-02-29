package com.learn.java.javabase.generic.classprogramm;

import java.util.ArrayList;

public class GenericClassTest {
    public static void main(String[] args) {
        FruitGenerator<Fruit>fruitFruitGenerator =new FruitGenerator<>();
        Apple apple1 =new Apple("honghushi","japan");
        Apple apple2 =new Apple("qinpingguo","other");
        Orange orange1 =new Orange("orange 1","");
        fruitFruitGenerator.add(apple1);
        fruitFruitGenerator.add(apple2);
        fruitFruitGenerator.add(orange1);
        fruitFruitGenerator.print();

        ArrayList<Object> objs =new ArrayList<>();
        objs.add(new String("str1"));
        System.out.println(objs.toString());
        //ArrayList<String> string =new ArrayList<>();
        //string.add(new Object());  comple error
        //.out.println(string.toString());
    }
}
