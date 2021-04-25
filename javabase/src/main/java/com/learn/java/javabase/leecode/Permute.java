package com.learn.java.javabase.leecode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * @description
 * @author: fangjc
 * @create: 2021-04-21 16:12
 **/
public class Permute {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Deque<Integer> path = new ArrayDeque<>();
        dfs(nums,res,path);
        return res;

    }

    private void dfs(int[] nums, List<List<Integer>> res, Deque<Integer> path) {
        if (path.size() == nums.length) {
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if(path.contains(nums[i])){
                continue;
            }
            path.add(nums[i]);
            dfs(nums,res,path);
            path.removeLast();
        }
    }
}
/*
46. 全排列
给定一个 没有重复 数字的序列，返回其所有可能的全排列。

示例:

输入: [1,2,3]
输出:
[
  [1,2,3],
  [1,3,2],
  [2,1,3],
  [2,3,1],
  [3,1,2],
  [3,2,1]
]
通过次数304,673提交次数391,489
 */
