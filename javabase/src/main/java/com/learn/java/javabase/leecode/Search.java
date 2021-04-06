package com.learn.java.javabase.leecode;

/**
 * @description
 * @author: fangjc
 * @create: 2021-04-03 13:25
 * 搜索旋转排序数组
 **/
public class Search {
    public static void main(String[] args) {
        System.out.println(new Search().search(new int[]{4, 5, 6, 7, 0, 1, 2}, 0));
    }

    /**
     * 1 2 3 4 5 6 7
     * 3 4 5 6| 7 1 2
     * 6 7 1 2| 3 4 5
     *
     * @param nums
     * @param target
     * @return
     */
    public int search(int[] nums, int target) {
        int n = nums.length;
        if (n <= 0) {
            return -1;
        }
        int l = 0;

        int r = n - 1;
        int mid = 0;
        while (l <= r) {
            mid = (l + r) / 2;
            if (nums[mid] == target) {
                return mid;
            }
            if (nums[0] <= nums[mid]) {
                if (nums[0] <= target && target < nums[mid]) {
                    r = mid - 1;
                } else {
                    l = mid + 1;
                }

            } else {
                if (nums[mid] < target && target <= nums[n - 1]) {
                    l = mid + 1;
                } else {
                    r = mid - 1;
                }

            }
        }
        return -1;
    }
}
