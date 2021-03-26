package com.learn.java.javabase.leecode;

/**
 * @description
 * @author: fangjc
 * @create: 2021-03-14 22:10
 **/
public class MaxArea {
    public static void main(String[] args) {

    }
    //双指针
    //执行用时：5 ms, 在所有 Java 提交中击败了35.11%的用户 内存消耗：51.8 MB, 在所有 Java 提交中击败了10.00%的用户
    public static int maxArea(int[] height) {

        int len = height.length;

        int i = 0;
        int j = len - 1;
        int area = 0;
        int max = 0;
        while (i < j) {
            area = Math.min(height[i], height[j]) * (j - i);
            max = Math.max(max, area);
            if (height[i] < height[j]) {
                i++;
            }else {
                j--;
            }
        }
        return max;
    }
}
