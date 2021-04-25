package com.learn.java.javabase.leecode;


import java.util.PriorityQueue;

/**
 * @description
 * @author: fangjc
 * @create: 2021-04-21 11:22
 **/
public class FindKthLargest {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>((o1, o2) -> o1 - o2);
        int len = nums.length;
        int count = 0;
        for (int i = 0; i < len; i++) {
            if (count < k) {
                priorityQueue.add(nums[i]);
                count++;
            } else {
                if (priorityQueue.peek() < nums[i]) {
                    priorityQueue.poll();
                    priorityQueue.add(nums[i]);
                }
            }
        }
        return priorityQueue.peek();


    }
}
/*
在未排序的数组中找到第 k 个最大的元素。请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。

示例 1:

输入: [3,2,1,5,6,4] 和 k = 2
输出: 5

输入: [3,2,3,1,2,4,5,5,6] 和 k = 4
输出: 4

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/kth-largest-element-in-an-array
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */