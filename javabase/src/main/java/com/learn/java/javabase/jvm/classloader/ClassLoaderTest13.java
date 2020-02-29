package com.learn.java.javabase.jvm.classloader;

public class ClassLoaderTest13 {
    public static void main(String[] args) {
        //返回当前线程的上下文类加载器，没有指定setContextClassLoader返回的是默认父线程的类加载器
        ClassLoader currentLoader = Thread.currentThread().getContextClassLoader();
        System.out.println("current thread loader" + currentLoader);
        Class<?> currentClass = null;
        try {
            currentClass=Class.forName("com.learn.java.javabase.jvm.classloader.ClassLoaderTest13");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        //currentClass = ClassLoaderTest13.class;
        //返回当前类的加载器Returns the class loader for the class，如果是根类加载器则返回null
        System.out.println(currentClass.getClassLoader());
        System.out.println(String.class.getClassLoader());


        //返回系统类加载器。当在运行阶段，返回的是调用的线程的上下文加载器
        ClassLoader systemClassLoader = ClassLoader.getSystemClassLoader();
        System.out.println(systemClassLoader);

        while (null != systemClassLoader) {
            systemClassLoader = systemClassLoader.getParent();
            //classLoader=ClassLoader.getSystemClassLoader();
            System.out.println(systemClassLoader);
        }
    }
}
