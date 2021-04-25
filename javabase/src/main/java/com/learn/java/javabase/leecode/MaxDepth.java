package com.learn.java.javabase.leecode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @description
 * @author: fangjc
 * @create: 2021-04-22 20:44
 **/
public class MaxDepth {
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
        System.out.println(new MaxDepth().maxDepth2(root));
    }

    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = 0;
        int right = 0;
        left = maxDepth(root.left);
        right = maxDepth(root.right);
        return Math.max(left, right) + 1;
    }

    public int maxDepth2(TreeNode root) {
        if (root == null) {
            return 0;
        }
        List<List<Integer>> res = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {

            List<Integer> level = new ArrayList<>();
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode treeNode = queue.poll();
                level.add(treeNode.val);
                if (treeNode.left != null) {
                    queue.offer(treeNode.left);
                }
                if (treeNode.right != null) {
                    queue.offer(treeNode.right);
                }
            }
            res.add(level);
        }
        return res.size();
    }

}
