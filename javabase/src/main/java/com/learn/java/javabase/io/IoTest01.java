package com.learn.java.javabase.io;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class IoTest01 {
    public static void main(String[] args) {
        test01();
    }
    public static void test01(){
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("input :");
        int  c = 0;
        try {
            c = bufferedReader.read();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(c);
    }
}
