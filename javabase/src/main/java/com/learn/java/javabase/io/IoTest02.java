package com.learn.java.javabase.io;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;

public class IoTest02 {
    public static void main(String[] args) {
        testFileOutStream();
    }

    /**
     * 测试字符流的写
     */
    public static void testFileWriter(){
        String filePath = "D:\\tmp\\java\\iotest01.txt";
        File file = new File(filePath);
        try {
            //BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file));
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file));
            bufferedWriter.write("welcome to write");
            bufferedWriter.flush();
            bufferedWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 测试字节流的写
     */
    public static void testFileOutStream(){
        String filePath = "D:\\tmp\\java\\iotest02.txt";
        File file = new File(filePath);
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            fileOutputStream.write(new byte[] { 0x61, 0x62, 0x63, 0x64 });
            fileOutputStream.write(0x65);
            fileOutputStream.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }catch (IOException e)
        {
            e.printStackTrace();
        }
    }
}
