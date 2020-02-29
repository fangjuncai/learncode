package com.learn.java.javabase.jvm.classloader;

import java.util.Random;

public class ClassLoaderInterfaceTest {
    public static void main(String[] args) {
//        Paraent01 paraent01 =new Paraent01();
//        Paraent01 paraent02 =new Paraent01();
           // Child01 child01 =new Child01();
        //System.out.println(Paraent01.paraent01);
        System.out.println(Child01.childInt);
    }
}

class Paraent01 {
    //常量会在编译期间放到调用类的常量池中
    public static final int  paraent01=10;
    //public static  int  paraent01=10;
    //静态代码块随着类的加载只会执行一次

    static {
        System.out.println("paraent01");
    }
}

class Child01 extends Paraent01 {
    public static final int childInt =5;
    static {
        System.out.println("child01");
    }
}

interface Interface01 {
    //public static final int inter01 = new Random().nextInt(10);
    public static final int inter01 = 1;
    public static Thread inter01Thread =new Thread(){
        {
            //这个例子说明，类的初始化不会去初始化它的父接口
            System.out.println("inter01Thread");
        }
        //不能直接使用System.out.println，这种非staic代码块，只要new都会加载一次
    };

}
/*
class Interface02 implements Interface01 {
    public static final int inter02 = 2;
}*/

interface Interface02 extends Interface01 {
    public static final int inter02 = 2;
    public static Thread inter02Thread =new Thread(){
        {
            //这个例子说明，类的初始化不会去初始化它的父接口
            System.out.println("inter02Thread");
        }
        //不能直接使用System.out.println，这种非staic代码块，只要new都会加载一次
    };
}
