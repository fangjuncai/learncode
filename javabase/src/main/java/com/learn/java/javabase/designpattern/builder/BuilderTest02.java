package com.learn.java.javabase.designpattern.builder;

/**
 * 实现无序的建造者
 */
public class BuilderTest02 {
    public static void main(String[] args) {
        test02();
    }
    public static void test01(){
        //无序调用，使用者其实拥有Director角色
        House house = House.createBuilder().buildBuleprint("蓝图").buildPartA("A部分").buildPartB("B部分").build();
        System.out.println(house.toString());
    }
    public static void test02(){
        //调用方不可见如何调用的
        House house = Director.build(new ConcreteBuilder());
        System.out.println(house.toString());
    }
}
