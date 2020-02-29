package com.learn.java.javabase.jvm.classloader;

public class ClassLoaderTest012 {
    public static void main(String[] args) {
        ClassLoader classLoader=ClassLoader.getSystemClassLoader();
        Class<?>  c1;
        try {
            c1 = classLoader.loadClass("com.learn.java.javabase.jvm.classloader.Test012");
            System.out.println(c1);
            System.out.println("--------");
            c1=Class.forName("com.learn.java.javabase.jvm.classloader.Test012");
            System.out.println(c1);
            System.out.println("--------");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        System.out.println("--------");


    }
}
class Test012{
    static {
        System.out.println("test012");
    }
}
