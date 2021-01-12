package com.learn.java.javabase.io;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.FilenameFilter;
import java.io.IOException;
import java.util.Arrays;

public class IoTest02 {
    public static void main(String[] args) {

        //testFile1();
        //testFileOutStream();
        testFileInputAndOutStream();



    }

    private static void testFileInputAndOutStream(){
        FileInputStream fileInputStream = null;
        FileOutputStream fileOutputStream = null;
        try {
            fileInputStream= new FileInputStream("D:\\my\\code\\github\\learncode\\javabase\\src\\main\\java\\com\\learn\\java\\javabase\\io\\IoTest02.java");
            fileOutputStream= new FileOutputStream("D:\\my\\code\\github\\learncode\\test.txt");
            String  hello = "helloWorld";

            char[] chars =hello.toCharArray();
            byte [] bytes2 = new byte[1024];
            for(char ar:chars){
                byte tmp = (byte)ar;
            }
            fileOutputStream.write(97);
            //fileInputStream= new FileInputStream("IoTest02.java");
            byte [] bytes  = new byte[1024];
            int hashRead = 0;
            while((hashRead=fileInputStream.read(bytes)) > 0){
                System.out.println("hashRead:"+hashRead);
                System.out.println(new String(bytes,0 ,hashRead));
                fileOutputStream.write(bytes);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                fileInputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    private static void testFile1(){
        File file = new File(".");
        System.out.println(file.getAbsolutePath());
        System.out.println(file.getAbsoluteFile());
        System.out.println(file.getPath());
        System.out.println(file.getAbsoluteFile().getParent());
        System.out.println(file.getParent());

        System.out.println(file.isDirectory());
        System.out.println(file.isFile());
//        File[] listFiles = file.listFiles();
//        for(File file1 : listFiles)
//        {
//            System.out.println(file1.getAbsoluteFile());
//        }

        //fixme 命令模式 将一个请求封装为一个对象，从而使你可用不同的请求对客户进行参数化，对请求排队或记录请求日志。以及支持可撤销的操作。
        //用接口封装，调用对象的方法
        String[] listFiles1 = file.list(new FilenameFilter() {
            @Override
            public boolean accept(File dir, String name) {
                //System.out.println("dir:"+dir.getAbsoluteFile());
                //System.out.println("name:"+name);
                return name.endsWith("s");
            }
        });
        Arrays.stream(listFiles1).forEach(System.out::println);
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
