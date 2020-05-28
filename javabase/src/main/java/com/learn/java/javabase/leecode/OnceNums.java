package com.learn.java.javabase.leecode;

import java.awt.print.PrinterGraphics;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * @program: javabase
 * @description
 * @author: fangjc
 * @create: 2020-05-08 22:49
 * <p>
 * 给定一个整数数组 nums，其中恰好有两个元素只出现一次，其余所有元素均出现两次。 找出只出现一次的那两个元素。
 * <p>
 * 示例 :
 * <p>
 * 输入: [1,2,1,3,2,5]
 * 输出: [3,5]
 * <p>
 * 注意：
 * <p>
 * 结果输出的顺序并不重要，对于上面的例子， [5, 3] 也是正确答案。
 * 你的算法应该具有线性时间复杂度。你能否仅使用常数空间复杂度来实现？
 * <p>
 * 来源：力扣（LeetCode）
 **/
public class OnceNums {
    public static void main(String[] args) {
        int [] nums = new int[] {1,2,1,3,2,5};
       int []res  = singleNumber(nums);
        for (int num : res) {
            System.out.println(num);
        }

    }

    /**
     * 执行用时 :6 ms, 在所有 Java 提交中击败了23.82% 的用户
     * 内存消耗 :40.5 MB, 在所有 Java 提交中击败了16.67%的用户
     * @param nums
     * @return
     */
    public static int[] singleNumber(int[] nums) {
        Map<Integer, Integer> resMap = new HashMap<>();
        int len = 0;
        for (int i = 0; i < nums.length; i++) {
            if (resMap.containsKey(nums[i])) {
                resMap.remove(nums[i]);
                len--;
            } else {
                resMap.put(nums[i], 1);
                len++;
            }
        }
        int[] res = new int[len];
        Set<Integer> keys = resMap.keySet();
        int index = 0;
        for (Integer key : keys) {
            res[index] = key;
            index ++;
        }
        return  res;
    }

}
