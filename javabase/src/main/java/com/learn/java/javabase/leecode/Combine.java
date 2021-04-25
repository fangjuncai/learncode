package com.learn.java.javabase.leecode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * @description
 * @author: fangjc
 * @create: 2021-04-21 15:25
 **/
public class Combine {
    public static void main(String[] args) {
        System.out.println(new Combine().combine(4, 2));
    }

    public List<List<Integer>> combine(int n, int k) {
        if (n < k || n == 0) {
            return null;
        }
        List<List<Integer>> res = new ArrayList<>();
        Deque<Integer> path = new ArrayDeque<>();
        int begin = 1;
        dfs(n, k, path, begin, res);
        return res;
    }

    private void dfs(int n, int k, Deque<Integer> path, int begin, List<List<Integer>> res) {
        if (path.size() == k) {
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i = begin; i <= n; i++) {
            path.add(i);
            //System.out.println(i + "dfs before" + path);
            dfs(n, k, path, i + 1, res);

            //回溯
            path.removeLast();
            //System.out.println(i + "dfs after" + path);
        }
    }
}
