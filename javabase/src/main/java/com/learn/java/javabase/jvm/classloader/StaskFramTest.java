package com.learn.java.javabase.jvm.classloader;

/**
 * @program: javabase
 * @description
 * @author: fangjc
 * @create: 2020-07-06 18:46
 * Xms 是指设定程序启动时占用内存大小。一般来讲，大点，程序会启动的快一点，但是也可能会导致机器暂时间变慢。
 *
 * Xmx 是指设定程序运行期间最大可占用的内存大小。如果程序运行需要占用更多的内存，超出了这个设置值，就会抛出OutOfMemory异常。
 *
 * Xss 是指设定每个线程的堆栈大小。这个就要依据你的程序，看一个线程大约需要占用多少内存，可能会有多少线程同时运行等。
 *

 **/
public class StaskFramTest {
    private static int stackLen = 0;
    private static int stackLen2 = 0;
    public static void main(String[] args) {

            try {
                testStack();
            }catch (Throwable throwable){
                System.out.println(stackLen);
                System.out.println(throwable.getMessage());
                //StackOverflowError 1088
                //a=1  990
                //a =1 n=2 842
                //throw throwable;
                //break;
            }

    }
    public static void testStack(){
        int a=1;
        long b=2L;
        stackLen++;
        //stackLen2++;
        //System.out.println(stackLen);
        testStack();
    }
}
