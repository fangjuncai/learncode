package com.learn.java.javabase.leecode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

/**
 * @description
 * @author: fangjc
 * @create: 2021-04-21 19:57
 **/
public class PostorderTraversal {
    public static void main(String[] args) {
        TreeNode t1 = new TreeNode(1);
        TreeNode t2 = new TreeNode(2);
        TreeNode t3 = new TreeNode(3);
        t1.right = t2;
        t2.left = t3;
        System.out.println(new PostorderTraversal().postorderTraversal3(t1));

    }

    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        order(res, root);
        return res;
    }


    private void order(List<Integer> res, TreeNode root) {
        if (root == null) {
            return;
        }
        order(res, root.left);
        order(res, root.right);
        res.add(root.val);
    }

    public List<Integer> postorderTraversal2(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        Stack<TreeNode> stack = new Stack<>();
        List<Integer> res = new ArrayList<>();
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            if (root.right == null) {
                res.add(root.val);
            } else {
                stack.push(root);
                root = root.right;
            }
            root = root.right;
        }

        return null;

    }

    public List<Integer> postorderTraversal3(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        Stack<TreeNode> stack = new Stack<>();
        List<Integer> res = new ArrayList<>();

        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                res.add(root.val);
                stack.push(root);
                root = root.right;
            }
            root = stack.pop();
            root = root.left;
        }
        Collections.reverse(res);
        return res;
    }

    public List<Integer> postorderTraversal4(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        Stack<TreeNode> stack = new Stack<>();
        List<Integer> res = new ArrayList<>();

        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                root=root.right;
            }
            root= stack.pop();
            res.add(root.val);
            root=root.left;
        }
        return res;
    }
}
