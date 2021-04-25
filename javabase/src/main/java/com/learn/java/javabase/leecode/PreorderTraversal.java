package com.learn.java.javabase.leecode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @description
 * @author: fangjc
 * @create: 2021-04-21 19:34
 **/
public class PreorderTraversal {
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
        System.out.println(new PreorderTraversal().preorderTraversal2(root));
    }
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        order(res, root);
        return res;
    }

    private void order(List<Integer> res, TreeNode root) {
        if (root == null) {
            return;
        }
        if (root != null) {
            res.add(root.val);
        }
        order(res, root.left);
        order(res, root.right);
    }
    public List<Integer> preorderTraversal2(TreeNode root){
        if (root == null) {
            return new ArrayList<>();
        }
        List<Integer> res = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode treeNode = stack.pop();
            res.add(treeNode.val);

            if (treeNode.right != null) {
                stack.push(treeNode.right );
            }
            if (treeNode.left != null) {
                stack.push(treeNode.left );
            }

        }
        return res;
    }
    public List<Integer> preorderTraversal3(TreeNode root){
        if (root == null) {
            return new ArrayList<>();
        }
        List<Integer> res = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();

        while (root!=null||!stack.isEmpty()) {
            while (root != null) {
                res.add(root.val);
                stack.push(root);
                root=root.left;
            }
            TreeNode cur=stack.pop();
            root=cur.right;

        }
        return res;
    }
}
/*
输入：root = [1,null,2,3]
输出：[1,2,3]
示例 2：

输入：root = []
输出：[]
示例 3：

输入：root = [1]
输出：[1]
输入：root = [1,null,2]
输出：[1,2]

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/binary-tree-preorder-traversal
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
