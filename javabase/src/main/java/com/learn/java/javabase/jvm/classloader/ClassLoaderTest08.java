package com.learn.java.javabase.jvm.classloader;

//类的初始化时按照上下文的顺序初始化的
public class ClassLoaderTest08 {
    public static void main(String[] args) {
        System.out.println("main get counter01 =" + Singleton08.counter02);
        //Singleton08 single =Singleton08.getInstance();
    }
}

class Singleton08 {
    public static int counter01;
    //public static int counter02=0;
    private static Singleton08 singleton08 = new Singleton08();

    private Singleton08() {
        counter01++;
        counter02++;
        System.out.println(counter01);
        System.out.println(counter02);
    }

    public static int counter02 = 0;

    public static Singleton08 getInstance() {
        return singleton08;
    }
}