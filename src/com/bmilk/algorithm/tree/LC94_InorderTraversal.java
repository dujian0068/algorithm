package com.bmilk.algorithm.tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class LC94_InorderTraversal {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();

        TreeNode node = root;
        Stack<TreeNode> stack = new Stack<>();
        while (null != node || !stack.isEmpty()){

            while (null != node){
                stack.push(node);
                node = node.left;
            }
            node = stack.pop();
            result.add(node.val);
            node = node.right;
        }
        return result;
    }

    List<Integer> result = new ArrayList<>();
    public List<Integer> inorderTraversal2(TreeNode root) {
        if(null == root) return result;
        inorderTraversal2(root.left);
        result.add(root.val);
        inorderTraversal2(root.right);

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
