package com.learn.java.javabase.java8.lambda;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;

/**
 * 测试用lambda表达式来调用实现了@FunctionalInterface
 * 1. 只有一个抽象方法的接口，无论有没有加上@FunctionalInterface
 * 2. 继承了Object方法的方法，不算入接口方法计入
 */
public class Lambda01FunctionInterface {
    public static void main(String[] args) {

        System.out.println("---------------------------");
        //Runable只有一个接口
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("anonymize fun");
            }
        }).start();

        new Thread(() -> System.out.println("lambda fun")).start();


        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("---------------------------");
        //@FunctionalInterface接口直接被lambda调用，实际上是基于对象实现@FunctionalInterface
        //即lambda表达式是对象，依赖于一种特殊的对象类型：@FunctionalInterface 函数式接口
        testFunctional01(new FunctionalInterface01() {
            @Override
            public void test01() {
                System.out.println("lambda call functional imple fun 1 ");
            }
        });
        testFunctional01(() -> System.out.println("lambda call functional imple fun 2 "));

        System.out.println("---------------------------");
        //测试new 使用lambda使用lambda表达式
        FunctionalInterface01 interface01Impl = ()-> System.out.println("lambda new fun impl");
        interface01Impl.test01();
        System.out.println( interface01Impl.getClass());
        System.out.println(interface01Impl.getClass().getSuperclass());

        System.out.println("---------------------------");
        //测试lambdas使用
        List<Integer> consumeList = Arrays.asList(10,9,8,7,6,1,2,3,4,5);
        //o1 < o2 return < 0  不变化顺序
        consumeList.sort((o1, o2) -> o1-o2);
        consumeList.forEach(s -> System.out.println(s));

        //forEach内部的遍历器，不用创建一个新的外部遍历器，每个对象for循环，调用Consumer的方法
        //Consumer只用一个void方法
        consumeList.forEach(new Consumer<Integer>() {
            @Override
            public void accept(Integer integer) {
                System.out.println(integer*2);
            }
        });

    }
    public static void testFunctional01(FunctionalInterface01 functionalInterface01){
        functionalInterface01.test01();

    }
}
