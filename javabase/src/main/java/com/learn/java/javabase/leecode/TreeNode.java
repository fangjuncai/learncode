package com.learn.java.javabase.leecode;

/**
 * @description
 * @author: fangjc
 * @create: 2021-04-21 16:50
 **/

public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    public TreeNode(){

    }

    public TreeNode(int val) {
        this.val = val;
    }

    public TreeNode(TreeNode left, TreeNode right) {
        this.left=left;
        this.right=right;
    }

}
