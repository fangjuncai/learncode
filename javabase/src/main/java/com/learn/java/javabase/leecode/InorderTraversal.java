package com.learn.java.javabase.leecode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @description
 * @author: fangjc
 * @create: 2021-04-22 23:30
 **/
public class InorderTraversal {
    public List<Integer> inorderTraversal(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        Stack<TreeNode> stack = new Stack<>();
        List<Integer> res = new ArrayList<>();

        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                root=root.left;
            }
            root= stack.pop();
            res.add(root.val);
            root=root.right;
        }
        return res;
    }
}
