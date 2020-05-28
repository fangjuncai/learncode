package com.learn.java.javabase.java8.lambda;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.http.converter.json.GsonBuilderUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;

/**
 * 测试lambda表达式语法
 */
public class LambdaTest02 {

    public static void main(String[] args) {
        //testLambda01();
        //testFunction();
        testFunction03();
    }

    protected static void testFunction() {
        //通过定义Function  传入apply方法  实现方法中调用apply行为
        //高阶函数满足下面两个条件的任何一个条件: 接受一个或多个函数作为输入 ;输出一个函数
        int a = 10;
        System.out.println(compute(a, integer -> integer + 10));
        System.out.println(compute(a, integer -> integer * integer));
        System.out.println(a);

        //原来提前定义好行为，写好方法体，现在通过Function接口直接重写apply方法，可以直接传递行为（函数）
    }

    public static int compute(int a, Function<Integer, Integer> function) {

        return function.apply(a);
    }

    protected static void testLambda01() {

        List<Integer> nums = Arrays.asList(100, 99, 0, 9);
        Collections.sort(nums, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1 - o2;
            }
        });
        //expresion lambda 单参数 无返回单语句
        nums.forEach((Integer intitem) -> System.out.println(intitem));
        nums.forEach(intitem -> System.out.println(intitem));
        //statement lambda 多参数必须要()
        //多参数 ,会有类型推断，可以省略类型
        //多语句
        Collections.sort(nums,
                (Integer o1, Integer o2) -> {
                    int num1 = o1;
                    int num2 = o2;
                    return num2 - num1;
                }
        );
        nums.forEach(intitem -> System.out.println(intitem));

        //单语句, 省略return
        //Collections.sort(nums, (o1, o2) -> o1 - o2);

    }

    /**
     * 测试Function对象  修改对象
     * 测试Consumer接口
     */
    public static void testFunction03() {
        Apple apple1 = new Apple("red", 150);
        Apple apple2 = new Apple("green", 250);
        Apple apple3 = new Apple("orange", 1350);
        List<Apple> apples = Arrays.asList(apple1, apple2, apple3);

        apples.forEach(apple -> System.out.println(apple.toString()));

        //通过Consumer向对象传递  设置  这个行为.虽然没有返回值，但可以修改对象的属性
        apples.forEach(apple -> apple.setHeavy(100));
        apples.forEach(apple -> System.out.println(apple.toString()));

        //通过Funciton 传递 修改的行为  这个行为是由返回值，返会引用达到了目的
        setAppleHeavy(apple1, (apple) ->
                {
                    apple.setHeavy(1);
                    return apple;
                }
        );
        System.out.println(apple1.toString());

        //结合Consumer Function ;
        // setAppleHeavy行为放到Consumer接口的accpt方法中
        // setAppleHeavy传递Consumer的Apple对象,Function方法实现设置值，再返回原来的引用
        //实现了forEach修改每个对象的值

        apples.forEach(
                apple ->
                        //传递apple入参
                        setAppleHeavy(apple, (app) -> {
                                    app.setHeavy(2);
                                    return app;
                                }
                        ));
        //等价于下面的写法  清晰的逻辑远胜晦涩难读
        apples.forEach(new Consumer<Apple>() {
            @Override
            public void accept(Apple apple) {
                //System.out.println(apple.toString());
                setAppleHeavy(apple, new Function<Apple, Apple>() {
                    @Override
                    public Apple apply(Apple apple) {
                        apple.setHeavy(3);
                        return apple;
                    }
                });
            }
        });

        apples.forEach(apple -> System.out.println(apple.toString()));
    }

    public static Apple setAppleHeavy(Apple apple, Function<Apple, Apple> function) {
        return function.apply(apple);

    }
}

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
class Apple {
    String color;
    Integer heavy;
}

