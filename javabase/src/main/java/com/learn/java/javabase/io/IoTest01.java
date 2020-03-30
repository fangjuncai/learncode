package com.learn.java.javabase.io;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * BufferedReader测试
 */
public class IoTest01 {
    public static void main(String[] args) {
        test01();
    }
    public static void test01(){
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        //InputStreamReader bufferedReader =new InputStreamReader(System.in);
        //public int read   <-   return cb[nextChar++]; 返回的默认8192缓冲区下的下一个char
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
