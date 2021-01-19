package com.learn.java.javabase.examination;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @description
 * @author: fangjc
 * @create: 2020-11-17 21:40
 **/
public class TreeNodeTest {
    static class TreeNode{
        int value;
        TreeNode left;
        TreeNode right;

        public TreeNode(int value){
            this.value = value;
            this.left = null;
            this.right =null;
        }
    }
/*
问题：二叉树的层序遍历
*/

    public static  List<Integer> levelLoop(TreeNode root){
        ArrayList<Integer> resultList = new ArrayList<>();

        if(  null == root){
            return resultList;
        }

        Queue<TreeNode> q = new LinkedList<>();

        q.add(root);
        while(!q.isEmpty())
        {
            TreeNode nowNode = q.peek();
            q.poll();
            resultList.add(nowNode.value);

            if(nowNode.left != null)
            {
                q.add(nowNode.left);
            }

            if(nowNode.right!=null)
            {
                q.add(nowNode.right);
            }
        }
        return  resultList;
    }

    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(1);
        treeNode.left = new TreeNode(2);
        treeNode.right = new TreeNode(3);
        treeNode.right.left = new TreeNode(4);
        System.out.println(levelLoop(treeNode));
    }
}
