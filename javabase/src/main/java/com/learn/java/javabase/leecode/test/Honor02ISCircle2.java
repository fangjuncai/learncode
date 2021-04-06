package com.learn.java.javabase.leecode.test;

import java.util.Scanner;

/**
 * @description
 * @author: fangjc
 * @create: 2021-04-03 19:29
 * honur输出十进制所有所有的回文进制  30 9 16
 **/
public class Honor02ISCircle2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println(isCircle(30, 15));
/*        while (in.hasNextInt()) {// 注意，如果输入是多个测试用例，请通过while循环处理多个测试用例
            int a = in.nextInt();
            //int b = in.nextInt();
            List<Integer> res = numRadius(a);
            if (!res.isEmpty()) {
                res.forEach(System.out::println);
            } else {
                System.out.println(-1);
            }

        }*/
    }


    private static boolean isCircle(int n, int radius) {
        int[] a = new int[100];
        int i = 0;
        int num = n;
        while (num > 0) {
            a[i] = num % radius;
            num = num / radius;
            i++;
        }
        i--;
        for (int j = 0; j <= i / 2; j++) {
            if (a[j] != a[i - j]) {
                return false;
            }
        }
        return true;
    }
}
