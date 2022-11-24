package com.bmilk.algorithm.tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class LC144_PreorderTraversal {
    public static void main(String[] args) {

    }

    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> pList = new ArrayList<>();
        preorderTraversal(root, pList);
        return pList;
    }

    public void preorderTraversal(TreeNode node, List<Integer> pList ){
        if(node == null)  return;
        pList.add(node.val);
        preorderTraversal(node.left, pList);
        preorderTraversal(node.right, pList);
    }

    public List<Integer> preorderTraversal2(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        List<Integer> pList = new ArrayList<>();

        while (!stack.isEmpty() || root!= null){
            while (root != null){
                pList.add(root.val);
                stack.push(root);
                root = root.left;
            }
            root = stack.pop().right;
        }
        return pList;
    }


    class TreeNode{
        int val;

        TreeNode left;
        TreeNode right;
        TreeNode(){};
        TreeNode(int val){
            this.val = val;
        }
        TreeNode(int val, TreeNode left, TreeNode right){
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
