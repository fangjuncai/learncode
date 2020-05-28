package com.learn.java.javabase.jvm.classloader;

/**
 * javap测试
 *          iconst_5 把常量推送至栈顶，反编译的时候可以发现方法中已经有了常量
 *        4: invokevirtual #4                  // Method java/io/PrintStream.println:(I)V
 *        7: getstatic     #2                  // Field java/lang/System.out:Ljava/io/PrintStream;
 *       10: bipush        127
 *
 */
public class VariableTest {
    private static final int v1 =5;
    private static final short v2 =127;
    private static final int v3 =256;
    private static final String s1 ="s1";

    public static void main(String[] args) {
        System.out.println(v1);
        System.out.println(v2);
    }
}
