package com.learn.java.javabase.designpattern.builder;

public class BuilderTest01 {
    public static void main(String[] args) {
        test01();
    }
    //测试Lombok @Builder使用静态内部类一步步建造对象
    public static void test01(){
        Person1 person1 = Person1.builder().name("jack").age(10).build();
        System.out.println(person1.toString());
    }
}
