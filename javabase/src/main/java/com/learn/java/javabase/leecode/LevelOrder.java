package com.learn.java.javabase.leecode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @description
 * @author: fangjc
 * @create: 2021-04-21 16:50
 **/
public class LevelOrder {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        TreeNode t1 = new TreeNode(9);
        TreeNode t2 = new TreeNode(20);
        TreeNode t21 = new TreeNode(15);
        TreeNode t22 = new TreeNode(7);
        root.left = t1;
        root.right = t2;
        t2.left = t21;
        t2.right = t22;
        System.out.println(new LevelOrder().levelOrder(root));


    }

    public List<Integer> levelOrder2(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        List<Integer> res = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            res.add(node.val);
            if (node.left != null) {
                queue.offer(node.left);
            }
            if (node.right != null) {
                queue.add(node.right);
            }

        }
        return res;
    }

    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        List<List<Integer>> res = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            List<Integer> level = new ArrayList<>();
            int size = queue.size();
            //i==q.size是错误的
            for (int i = 0; i < size; i++) {
                TreeNode cur = queue.poll();

                level.add(cur.val);
                if (cur.left != null) {
                    //queue.add(cur.left);
                    queue.offer(cur.left);
                }
                if (cur.right != null) {
                    queue.offer(cur.right);
                }
            }
            res.add(level);
        }
        return res;
    }
}
/*
输入
[3,9,20,null,null,15,7]
输出
[[3,9],[20,15],[7]]
预期结果
[[3],[9,20],[15,7]]
 */
