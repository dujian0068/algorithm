package com.bmilk.algorithm.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class LC145_PostorderTraversal {
    public List<Integer> postorderTraversal(TreeNode root) {
        LinkedList<Integer> result = new LinkedList<>();
        if(null == root){
            return result;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()){
            TreeNode pop = stack.pop();
            result.addFirst(pop.val);
            if(pop.left != null){
                stack.push(pop.left);
            }
            if(pop.right != null){
                stack.push(pop.right);
            }
        }
        return result;
    }

    List<Integer> result = new ArrayList<>();
    public List<Integer> postorderTraversal2(TreeNode root) {
        if (null == root) return result;
        postorderTraversal2(root.left);
        postorderTraversal2(root.right);
        result.add(root.val);
        return result;
    }

}
