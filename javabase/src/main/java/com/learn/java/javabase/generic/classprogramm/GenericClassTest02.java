package com.learn.java.javabase.generic.classprogramm;

/**
 * 泛型测试 泛型方法
 */
public class GenericClassTest02 {
    public static void main(String[] args) {
        printAll(1);
    }

    /**
     * 泛型接口的写法 都会加上<T>  这样写是为了让编译器知道泛型的类型是什么
     * 泛型类的写法也会声明好泛型的类型
     * public class FruitGenerator<E> {
     *     ArrayList<E> fruit;
     */
    public static <T> void printAll(T t){
        System.out.println(t);
    }
}
