package com.learn.java.javabase.designpattern.singleton;

/**
 * @description
 * @author: fangjc
 * @create: 2021-04-15 14:23
 **/
public class LazySingleton {
    private static LazySingleton lazySingleton2= new LazySingleton();
    private static class LazySingletonHolder {
        private static LazySingleton lazySingleton= new LazySingleton();
        private static void test(){
            System.out.println(lazySingleton2.getClass().getSimpleName()+"inside");
        }

    }
    public static LazySingleton getInstance(){
        LazySingletonHolder.test();
        return LazySingletonHolder.lazySingleton;
    }
    public void  test(){
        System.out.println(Thread.currentThread().getStackTrace()[1].getClassName()+" test ");
        System.out.println(this.getClass().getSimpleName());
    }
}
