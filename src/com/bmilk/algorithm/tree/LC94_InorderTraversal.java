package com.bmilk.algorithm.tree;

import com.bmilk.algorithm.node.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * @Link https://leetcode.cn/problems/binary-tree-inorder-traversal/
 */
public class LC94_InorderTraversal {

    private List<Integer> result = new ArrayList<>();

    /**
     * test param
     *
     *              3
     *           /     \
     *          2       14
     *          \      /  \
     *           1    35   16
     * @param args
     */
    public static void main(String[] args) {
        TreeNode node_1 = new TreeNode(1);
        TreeNode node_35 = new TreeNode(35);
        TreeNode node_16 = new TreeNode(16);
        TreeNode node_2 = new TreeNode(2, null, node_1);
        TreeNode node_14 = new TreeNode(14, node_35, node_16);
        TreeNode node_3 = new TreeNode(3, node_2, node_14);

        LC94_InorderTraversal lc94_inorderTraversal = new LC94_InorderTraversal();

        List<Integer> list = lc94_inorderTraversal.inorderTraversal(node_3);
        System.out.println(list);
    }

//    public List<Integer> inorderTraversal(TreeNode root) {
//        if(null == root){
//            return result;
//        }
//        inorderTraversal(root.left);
//        result.add(root.val);
//        inorderTraversal(root.right);
//        return result;
//    }


    public List<Integer> inorderTraversal(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();

        TreeNode node = root;
        while (null != node || !stack.isEmpty()){
            while (null != node){
               stack.push(node);
               node = node.left;
            }
            node = stack.pop();
            result.add(node.val);
            node = node.right;
        }
        return  result;
    }


}
