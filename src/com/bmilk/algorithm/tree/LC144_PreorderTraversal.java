package com.bmilk.algorithm.tree;

import netscape.security.UserTarget;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class LC144_PreorderTraversal {

    public List<Integer> preorderTraversal(TreeNode root) {
        if(null == root){
            return new ArrayList<>();
        }
        Stack<TreeNode> stack = new Stack<>();
        List<Integer> result = new ArrayList<>();
        stack.push(root);
        while (!stack.isEmpty()){
            TreeNode pop = stack.pop();
            result.add(pop.val);
            if(null != pop.right){
                stack.push(pop.right);
            }
            if(null != pop.left){
                stack.push(pop.left);
            }
        }
        return result;
    }

    private List<Integer> result = new ArrayList<>();
    public List<Integer> preorderTraversal2(TreeNode root) {
        if(null == root) return result;
        result.add(root.val);
        preorderTraversal2(root.left);
        preorderTraversal2(root.right);
        return result;
    }



    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
