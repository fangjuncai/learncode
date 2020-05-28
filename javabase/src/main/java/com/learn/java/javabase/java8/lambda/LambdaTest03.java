package com.learn.java.javabase.java8.lambda;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

/**
 * 测试断言接口Predicate
 */
public class LambdaTest03 {
    public static void main(String[] args) {
        testPredicate01();
    }

    public static void testPredicate01() {
        List<Integer> integers = Arrays.asList(1, 0, 10, 6);
        //filter(integers,item -> item>0);
/*        integers = filter(integers, new Predicate<Integer>() {
            @Override
            public boolean test(Integer integer) {
                return integer > 1;
            }
        });*/
        //断言接口
        Predicate<Integer> predicate = (Integer intitem) -> intitem > 1;
        integers = filter(integers,predicate);
        integers.forEach(item -> System.out.println(item));

    }

    public static <T> List<T> filter(List<T> list, Predicate<T> predicate) {
        List<T> tmpList = new ArrayList<>();
        for (T t : list)
            if (predicate.test(t)) {
                tmpList.add(t);
            }
        return tmpList;
    }
}
