package com.learn.java.javabase.leecode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @description
 * @author: fangjc
 * @create: 2021-03-16 12:49
 **/
public class ThreeSum {
    public static void main(String[] args) {
        System.out.println(threeSum(new int[]{-1, 0, 1, 2, -1, -4}));
        //System.out.println(threeSum(new int[]{0,0,0,0}));
       // System.out.println(threeSum(new int[]{-2, 0, 0, 2, 2}));
        //[1,2,-2,-1]
        //System.out.println(threeSum(new int[]{1,2,-2,-1}));

    }
   // 执行用时：28 ms, 在所有 Java 提交中击败了36.07%的用户 内存消耗：42.4 MB, 在所有 Java 提交中击败了53.67%的用户
    public static List<List<Integer>> threeSum(int[] nums) {
        int len = nums.length;
        List<List<Integer>> res = new ArrayList<>();
        if (nums.length < 3) {
            return res;
        }
        Arrays.sort(nums);
        for (int i = 0; i < len; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            int a = nums[i];
            int tempa = -a;
            int right = len - 1;
            for (int left = i + 1; left < len && left < right; left++) {
                //left开始阶段之后 第一个符合 如果出现连续两个相同 结果有一定符合记录  会冲突跳过 [-2,0,0,2,2] [[-2,0,2],[-2,0,2]]
                if (left > i + 1 && nums[left] == nums[left - 1]  ) {
                    continue;
                }
                //这句话的意思 left和之前相同 就要跳过去，这种情况肯定不行-1 -1  ... 2
/*                if (nums[left] == nums[left - 1] ) {
                    continue;
                }*/
                while (nums[left] + nums[right] > tempa && right>left) {
                    right--;
                }
                if (right>left&&nums[left] + nums[right] == tempa) {
                    List<Integer> list = new ArrayList<>();
                    list.add(nums[i]);
                    list.add(nums[left]);
                    list.add(nums[right]);
                    res.add(list);
                    right--;
                    
                }
            }
        }
        return res;
    }
}
