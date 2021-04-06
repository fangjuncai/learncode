package com.learn.java.javabase.leecode;

/**
 * @description
 * @author: fangjc
 * @create: 2021-04-03 22:17
 **/
public class HammingWeight {
    public static void main(String[] args) {
        System.out.println(new HammingWeight().hammingWeight(9));
    }
    public int hammingWeight(int n) {
        int res = 0;
        int num = n;
        //会无限循环  num==0要跳出来
        while (num >= 0) {
            res += num & 1;
            num = num >>> 1;
        }
        return res;

    }
}
