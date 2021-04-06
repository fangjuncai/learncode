package com.learn.java.javabase.leecode;

/**
 * @description
 * @author: fangjc
 * @create: 2021-04-01 11:33
 **/
public class RemoveDuplicates {
    public static void main(String[] args) {
        System.out.println(new RemoveDuplicates().removeDuplicates(new int[]{0, 0, 1, 1, 1, 2, 2, 3, 3, 4}));
    }

    public int removeDuplicates(int[] nums) {
        int p = 0;
        int len = nums.length;
        for (int q = 0; q < len; q++) {
            if (nums[p] != nums[q]) {
                p++;
                nums[p] = nums[q];
            }

        }
        return p + 1;
    }
}
