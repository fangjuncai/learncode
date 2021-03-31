package com.learn.java.javabase.leecode;

/**
 * @description
 * @author: fangjc
 * @create: 2021-03-27 14:36
 **/
public class BinarySearch {
    public int search(int[] nums, int target) {
        if (nums.length == 0) {
            return -1;
        }
        if (nums.length == 1) {
            return nums[0];
        }
        int len = nums.length;
        int left = 0;
        int right = len - 1;
        int middle = 0;
        while (left < right) {
            middle = (left + right) / 2;
            if (target > nums[middle]) {
                left = middle + 1;
            } else if (target < nums[middle]) {
                right = middle - 1;
            }else {
                return middle;
            }
        }
        return -1;

    }
}
