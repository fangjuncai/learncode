package com.learn.java.javabase.jvm.classloader;

import java.util.Random;
//ldc将int float String常量值从常年池推送至栈顶
//bipush表示将单字节常量-128-127推送至栈顶
//sipush表示将短整型-32768-32767常量推送至栈顶
// iconst_5表示将int型常量推动至栈顶，是1-5比较常见的数字
public class ClassLoaderInterfaceTest {
    public static void main(String[] args) {
//        Paraent01 paraent01 =new Paraent01();
//        Paraent01 paraent02 =new Paraent01();
           // Child01 child01 =new Child01();
        //System.out.println(Paraent01.paraent01);
        System.out.println(Child01.childInt);
        System.out.println(Child01.childstr);
        System.out.println(Paraent01.s);
        System.out.println(Paraent01.pint1);
    }
}

class Paraent01 {
    //常量会在编译期间放到调用类的常量池中
    public static final int  paraent01=10;
    public static final short s =7;
    public static final int pint1 =128;
    //public static  int  paraent01=10;
    //静态代码块随着类的加载只会执行一次

    static {
        System.out.println("paraent01");
    }
}

class Child01 extends Paraent01 {
    public static final int childInt =5;
    public static final String childstr ="hello";
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
/*
    PS D:\my\code\github\learncode\javabase\target\classes\com\learn\java\javabase\jvm\classloader> javap -c .\ClassLoaderTest08.class
Compiled from "ClassLoaderTest08.java"
public class com.learn.java.javabase.jvm.classloader.ClassLoaderTest08 {
public com.learn.java.javabase.jvm.classloader.ClassLoaderTest08();
        Code:
        0: aload_0
        1: invokespecial #1                  // Method java/lang/Object."<init>":()V
        4: return

public static void main(java.lang.String[]);
        Code:
        0: getstatic     #2                  // Field java/lang/System.out:Ljava/io/PrintStream;
        3: new           #3                  // class java/lang/StringBuilder
        6: dup
        7: invokespecial #4                  // Method java/lang/StringBuilder."<init>":()V
        10: ldc           #5                  // String main get counter01 =
        12: invokevirtual #6                  // Method java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        15: getstatic     #7                  // Field com/learn/java/javabase/jvm/classloader/Singleton08.counter02:I
        18: invokevirtual #8                  // Method java/lang/StringBuilder.append:(I)Ljava/lang/StringBuilder;
        21: invokevirtual #9                  // Method java/lang/StringBuilder.toString:()Ljava/lang/String;
        24: invokevirtual #10                 // Method java/io/PrintStream.println:(Ljava/lang/String;)V
        27: return
        }
        PS D:\my\code\github\learncode\javabase\target\classes\com\learn\java\javabase\jvm\classloader>
*/
