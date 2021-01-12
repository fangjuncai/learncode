package com.learn.java.javabase.io;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.nio.charset.Charset;

/**
 * @description
 * @author: fangjc
 * @create: 2020-12-18 14:20
 **/
public class SeriableTest {
    public static void main(String[] args)  {
        //WriteTest();
        testRead();
        testByte();
    }
    private static void WriteTest(){
        try {
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream("a.txt"));
            Persion per = new Persion();
            per.name = "jack";
            objectOutputStream.writeObject(per);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private static void testRead(){
        try {
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream("a.txt"));
            try {
                Persion per = (Persion) ois.readObject();
                System.out.println(per.name);

            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private static void testByte(){
        String abc  = "中国";
        System.out.println(abc.getBytes().length);
        Character cha = 'a';
        System.out.println(cha.toString().getBytes(Charset.defaultCharset()).length);
    }
    static class Persion implements Serializable{
        public String name;
    }
}
