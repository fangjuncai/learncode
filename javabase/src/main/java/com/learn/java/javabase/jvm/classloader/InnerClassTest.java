package com.learn.java.javabase.jvm.classloader;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @program: javabase
 * @description
 * @author: fangjc
 * @create: 2020-06-07 21:29
 **/
@Component
public class InnerClassTest {
    @Value("${app.name}")
    private String annoName;
    int m;
    public void print(int a){
        new Thread(()->{
                System.out.println(a);
            InnerClass1.printName("helloword");

        }).start();

    }

    static class InnerClass1{
        String name;
        public static void printName(String  name){
            new Thread(()->{
                System.out.println(name);
            }).start();

        }

    }
}
/*
PS D:\my\code\github\learncode\javabase\target\classes\com\learn\java\javabase\jvm\classloader> javap -verbose .\InnerClassTest.class
Classfile /D:/my/code/github/learncode/javabase/target/classes/com/learn/java/javabase/jvm/classloader/InnerClassTest.class
  Last modified 2020-6-7; size 1436 bytes
  MD5 checksum ca28d54d7fa4ac9b30c9023b2b8f47aa
  Compiled from "InnerClassTest.java"
public class com.learn.java.javabase.jvm.classloader.InnerClassTest
  minor version: 0
  major version: 52
  flags: ACC_PUBLIC, ACC_SUPER
Constant pool:
   #1 = Methodref          #11.#31        // java/lang/Object."<init>":()V
   #2 = Class              #32            // java/lang/Thread
   #3 = InvokeDynamic      #0:#37         // #0:run:(I)Ljava/lang/Runnable;
   #4 = Methodref          #2.#38         // java/lang/Thread."<init>":(Ljava/lang/Runnable;)V
   #5 = Methodref          #2.#39         // java/lang/Thread.start:()V
   #6 = Fieldref           #40.#41        // java/lang/System.out:Ljava/io/PrintStream;
   #7 = Methodref          #42.#43        // java/io/PrintStream.println:(I)V
   #8 = String             #44            // helloword
   #9 = Methodref          #12.#45        // com/learn/java/javabase/jvm/classloader/InnerClassTest$InnerClass1.printName:(Ljava/lang/String;)V
  #10 = Class              #46            // com/learn/java/javabase/jvm/classloader/InnerClassTest
  #11 = Class              #47            // java/lang/Object
  #12 = Class              #48            // com/learn/java/javabase/jvm/classloader/InnerClassTest$InnerClass1
  #13 = Utf8               InnerClass1
  #14 = Utf8               InnerClasses
  #15 = Utf8               m
  #16 = Utf8               I
  #17 = Utf8               <init>
  #18 = Utf8               ()V
  #19 = Utf8               Code
  #20 = Utf8               LineNumberTable
  #21 = Utf8               LocalVariableTable
  #22 = Utf8               this
  #23 = Utf8               Lcom/learn/java/javabase/jvm/classloader/InnerClassTest;
  #24 = Utf8               print
  #25 = Utf8               (I)V
  #26 = Utf8               a
  #27 = Utf8               MethodParameters
  #28 = Utf8               lambda$print$0
  #29 = Utf8               SourceFile
  #30 = Utf8               InnerClassTest.java
  #31 = NameAndType        #17:#18        // "<init>":()V
  #32 = Utf8               java/lang/Thread
  #33 = Utf8               BootstrapMethods
  #34 = MethodHandle       #6:#49         // invokestatic java/lang/invoke/LambdaMetafactory.metafactory:(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;
Ljava/lang/invoke/MethodType;Ljava/lang/invoke/MethodType;Ljava/lang/invoke/MethodHandle;Ljava/lang/invoke/MethodType;)Ljava/lang/invoke/CallSite;
  #35 = MethodType         #18            //  ()V
  #36 = MethodHandle       #6:#50         // invokestatic com/learn/java/javabase/jvm/classloader/InnerClassTest.lambda$print$0:(I)V
  #37 = NameAndType        #51:#52        // run:(I)Ljava/lang/Runnable;
  #38 = NameAndType        #17:#53        // "<init>":(Ljava/lang/Runnable;)V
  #39 = NameAndType        #54:#18        // start:()V
  #40 = Class              #55            // java/lang/System
  #41 = NameAndType        #56:#57        // out:Ljava/io/PrintStream;
  #42 = Class              #58            // java/io/PrintStream
  #43 = NameAndType        #59:#25        // println:(I)V
  #44 = Utf8               helloword
  #45 = NameAndType        #60:#61        // printName:(Ljava/lang/String;)V
  #46 = Utf8               com/learn/java/javabase/jvm/classloader/InnerClassTest
  #47 = Utf8               java/lang/Object
  #48 = Utf8               com/learn/java/javabase/jvm/classloader/InnerClassTest$InnerClass1
  #49 = Methodref          #62.#63        // java/lang/invoke/LambdaMetafactory.metafactory:(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/in
voke/MethodType;Ljava/lang/invoke/MethodType;Ljava/lang/invoke/MethodHandle;Ljava/lang/invoke/MethodType;)Ljava/lang/invoke/CallSite;
  #50 = Methodref          #10.#64        // com/learn/java/javabase/jvm/classloader/InnerClassTest.lambda$print$0:(I)V
  #51 = Utf8               run
  #52 = Utf8               (I)Ljava/lang/Runnable;
  #53 = Utf8               (Ljava/lang/Runnable;)V
  #54 = Utf8               start
  #55 = Utf8               java/lang/System
  #56 = Utf8               out
  #57 = Utf8               Ljava/io/PrintStream;
  #58 = Utf8               java/io/PrintStream
  #59 = Utf8               println
  #60 = Utf8               printName
  #61 = Utf8               (Ljava/lang/String;)V
  #62 = Class              #65            // java/lang/invoke/LambdaMetafactory
  #63 = NameAndType        #66:#69        // metafactory:(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/invoke/M
ethodType;Ljava/lang/invoke/MethodHandle;Ljava/lang/invoke/MethodType;)Ljava/lang/invoke/CallSite;
  #64 = NameAndType        #28:#25        // lambda$print$0:(I)V
  #65 = Utf8               java/lang/invoke/LambdaMetafactory
  #66 = Utf8               metafactory
  #67 = Class              #71            // java/lang/invoke/MethodHandles$Lookup
  #68 = Utf8               Lookup
  #69 = Utf8               (Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/invoke/MethodType;Ljava/lang/invoke/Me
thodHandle;Ljava/lang/invoke/MethodType;)Ljava/lang/invoke/CallSite;
  #70 = Class              #72            // java/lang/invoke/MethodHandles
  #71 = Utf8               java/lang/invoke/MethodHandles$Lookup
  #72 = Utf8               java/lang/invoke/MethodHandles
{
  int m;
    descriptor: I
    flags:

  public com.learn.java.javabase.jvm.classloader.InnerClassTest();
    descriptor: ()V
    flags: ACC_PUBLIC
    Code:
      stack=1, locals=1, args_size=1
         0: aload_0
         1: invokespecial #1                  // Method java/lang/Object."<init>":()V
         4: return
      LineNumberTable:
        line 9: 0
      LocalVariableTable:
        Start  Length  Slot  Name   Signature
            0       5     0  this   Lcom/learn/java/javabase/jvm/classloader/InnerClassTest;

  public void print(int);
    descriptor: (I)V
    flags: ACC_PUBLIC
    Code:
      stack=3, locals=2, args_size=2
         0: new           #2                  // class java/lang/Thread
         3: dup
         4: iload_1
         5: invokedynamic #3,  0              // InvokeDynamic #0:run:(I)Ljava/lang/Runnable;
        10: invokespecial #4                  // Method java/lang/Thread."<init>":(Ljava/lang/Runnable;)V
        13: invokevirtual #5                  // Method java/lang/Thread.start:()V
        16: return
      LineNumberTable:
        line 12: 0
        line 16: 13
        line 18: 16
      LocalVariableTable:
        Start  Length  Slot  Name   Signature
            0      17     0  this   Lcom/learn/java/javabase/jvm/classloader/InnerClassTest;
            0      17     1     a   I
            MethodParameters的作用是记录方法的各个形参名称和信息。
    MethodParameters:
      Name                           Flags
      a
}
SourceFile: "InnerClassTest.java"
InnerClasses:
     static #13= #12 of #10; //InnerClass1=class com/learn/java/javabase/jvm/classloader/InnerClassTest$InnerClass1 of class com/learn/java/javabase/jvm/classloade
r/InnerClassTest
     public static final #68= #67 of #70; //Lookup=class java/lang/invoke/MethodHandles$Lookup of class java/lang/invoke/MethodHandles
BootstrapMethods:
  0: #34 invokestatic java/lang/invoke/LambdaMetafactory.metafactory:(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/l
ang/invoke/MethodType;Ljava/lang/invoke/MethodHandle;Ljava/lang/invoke/MethodType;)Ljava/lang/invoke/CallSite;
    Method arguments:
      #35 ()V
      #36 invokestatic com/learn/java/javabase/jvm/classloader/InnerClassTest.lambda$print$0:(I)V
      #35 ()V
PS D:\my\code\github\learncode\javabase\target\classes\com\learn\java\javabase\jvm\classloader>
 */
