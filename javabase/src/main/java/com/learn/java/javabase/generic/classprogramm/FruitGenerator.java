package com.learn.java.javabase.generic.classprogramm;

import java.util.ArrayList;

public class FruitGenerator<E> {
    ArrayList<E> fruit;
    public FruitGenerator (){
        fruit =new ArrayList<>();
    }
    public void add(E e){
        fruit.add(e);
    }
    public void print(){
        for(E e:fruit){
            System.out.println(e.toString());
        }

    }
}
