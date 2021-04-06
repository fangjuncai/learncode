package com.learn.java.javabase.leecode.test;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @description
 * @author: fangjc
 * @create: 2021-04-03 19:29
 * honur输出十进制所有所有的回文进制  30 9 16
 **/
public class Honor02ISCircle {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println(isCircle(30,9));
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

    private static List<Integer> numRadius(int n) {
        List<Integer> res = new ArrayList<>();
        for (int r = 2; r <= 16; r++) {
            if (isCircle(n, r)) {
                res.add(r);
            }
        }
        return res;

    }

    private static boolean isCircle(int n, int radius) {
        int[] a = new int[1000];
        int i = 0;
        int j = n;
        while (j > 0) {
            a[i] = j % radius;
            j /= radius;
            i++;

        }
        //i++所以-1
        for (int m = 0; m < (i-1)/ 2; m++) {
            if (a[m] != a[i - m]) {
                return false;
            }

        }
        return true;
    }
}
