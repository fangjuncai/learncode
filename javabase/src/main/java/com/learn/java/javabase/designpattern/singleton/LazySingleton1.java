package com.learn.java.javabase.designpattern.singleton;

/**
 * @description
 * @author: fangjc
 * @create: 2021-04-15 14:10
 **/
public class LazySingleton1 {
    //延迟加载是不能用final  因为不能修改 语法不会编译通过
    private volatile static LazySingleton1 lazySingleton1 = null;

    public static LazySingleton1 getInstance() {
        if (lazySingleton1 == null) {
            synchronized (LazySingleton1.class) {
                //会发生指令重排序
                lazySingleton1 = new LazySingleton1();
            }
        }
        return lazySingleton1;
    }
    public void  test(){
        System.out.println(Thread.currentThread().getStackTrace()[1].getClassName()+" test ");
        System.out.println(this.getClass().getSimpleName());
    }

}
