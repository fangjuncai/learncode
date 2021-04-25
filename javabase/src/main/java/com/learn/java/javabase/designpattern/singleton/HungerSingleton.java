package com.learn.java.javabase.designpattern.singleton;

/**
 * @description
 * @author: fangjc
 * @create: 2021-04-15 14:01
 **/
public class HungerSingleton {
    //private final static HungerSingleton hungerSingleton = new HungerSingleton();
    private static HungerSingleton hungerSingleton = new HungerSingleton();
    public static HungerSingleton getInstance(){
        return hungerSingleton;
    }
    public void  test(){
        System.out.println(Thread.currentThread().getStackTrace()[1].getClassName()+" test ");
        System.out.println(this.getClass().getSimpleName());
    }
}
