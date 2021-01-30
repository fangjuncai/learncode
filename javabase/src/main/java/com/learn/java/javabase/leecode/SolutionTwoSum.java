package com.learn.java.javabase.leecode;

/**
 * @program: javabase
 * @description
 * @author: fangjc
 * @create: 2020-08-15 23:31
 **/

import java.util.HashMap;
import java.util.Map;

/**
 * Given an array of integers, return indices of the two numbers such that they add up to a specific target.
 * <p>
 * You may assume that each input would have exactly one solution, and you may not use the same element twice.
 * <p>
 * Example:
 * <p>
 * Given nums = [2, 7, 11, 15], target = 9,
 * <p>
 * Because nums[0] + nums[1] = 2 + 7 = 9,
 * return [0, 1].
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/two-sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class SolutionTwoSum {
    public static void main(String[] args) {
        //int[] nums = new int[]{3,3};
        //int[] nums = new int[]{2,7,11,5};
        int[] nums = new int []{230,863,916,585,981,404,316,785,88,12,70,435,384,778,887,755,740,337,86,92,325,422,815,650,920,125,277,336,221,847,168,23,677,61,400,136,874,363,394,199,863,997,794,587,124,321,212,957,764,173,314,422,927,783,930,282,306,506,44,926,691,568,68,730,933,737,531,180,414,751,28,546,60,371,493,370,527,387,43,541,13,457,328,227,652,365,430,803,59,858,538,427,583,368,375,173,809,896,370,789};

        int[] res = twoSum1(nums,542);
        for (int num : res) {
            System.out.println(num);
        }
    }
    //一遍hash
    public static int[] twoSum1(int[] nums, int target) {
        Map<Integer, Integer> numMap = new HashMap<>();

        for(int i = 0;i<nums.length;i++)
        {
            int com = target - nums[i];
            if(numMap.containsKey(com)){
                return new  int[]{numMap.get(com),i};
            }else {
                numMap.put(nums[i],i);
            }

        }
        //RuntimeException
        throw new IllegalArgumentException("error");

    }
    //两遍hash
    public static int[] twoSum3(int[] nums, int target) {
        Map<Integer, Integer> numMap = new HashMap<>();
        int indicy = 0;
        int [] res =new int[2];
        //两遍循环
        for (int num : nums) {
            if(!numMap.containsKey(num)){
                numMap.put(num, indicy);
            }else{
                if(target-num == num){
                    res [0] = numMap.get(num);
                    res [1] = indicy;
                    return res;
                }
                //return res;

            }
            indicy++;
        }
        for (int num : nums) {
            if (null != numMap.get(target - num) && (numMap.get(num) !=numMap.get(target - num))) {
                res [0] =numMap.get(num);
                res[1]=numMap.get(target - num);
                System.out.println(res [0]);
                break;
            }

        }

        return res;
    }
    public static int[] twoSum2(int[] nums, int target) {
        Map<Integer, Integer> numMap = new HashMap<>();
        int indicy = 0;
        for (int num : nums) {
            numMap.put(num, indicy);
            indicy++;
        }
        numMap.forEach((key,value) -> System.out.println(key + "-" + value));
        int [] res =new int[2];
        for (int num : nums) {
            if (null != numMap.get(target - num) && (numMap.get(num) !=numMap.get(target - num))) {
                res [0] =numMap.get(num);
                res[1]=numMap.get(target - num);
                System.out.println(res [0]);
                System.out.println(num);
                System.out.println("--");
                break;
            }

        }

        return res;
    }
}
