package com.learn.java.javabase.leecode.test;

import java.util.Scanner;

/**
 * @description
 * @author: fangjc
 * @create: 2021-04-03 19:04
 **/
public class HonourMain01 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println(sum(111));
        while (in.hasNextInt()) {// 注意，如果输入是多个测试用例，请通过while循环处理多个测试用例
            int a = in.nextInt();
            int b = in.nextInt();
            System.out.println(res(a, b));
        }
    }

    private static int res(int m, int n) {
        return sum(m) % sum(n);
    }

    private static int sum(int m) {
        int num = m;
        int sum = 0;
        while (num > 0) {
            sum += num % 10;
            num = num / 10;
        }


        return sum;
    }
}
