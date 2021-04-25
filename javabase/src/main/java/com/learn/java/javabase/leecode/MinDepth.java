package com.learn.java.javabase.leecode;

/**
 * @description
 * @author: fangjc
 * @create: 2021-04-25 23:38
 **/
public class MinDepth {
    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = 0;
        int right = 0;
        left = minDepth(root.left);
        right = minDepth(root.right);
        return Math.min(left, right) + 1;

    }
}
