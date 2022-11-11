package com.bmilk.algorithm.tree;

import com.bmilk.algorithm.node.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class LC145_PostorderTraversal {
    public static void main(String[] args) {

        TreeNode left31 = new TreeNode(1);
        TreeNode right32 = new TreeNode(2);
        TreeNode left21 = new TreeNode(3, left31, right32);
        TreeNode right22 = new TreeNode(4);
        TreeNode root = new TreeNode(5, left21, right22);

        LC145_PostorderTraversal service = new LC145_PostorderTraversal();
        List<Integer> list = service.postorderTraversal2(root);
        System.out.println(list);

    }

    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> pList = new ArrayList<>();
        postorderTraversal(root, pList);
        return pList;
    }

    public void postorderTraversal(TreeNode root, List<Integer> pList) {
        if(root == null) return ;
        postorderTraversal(root.left, pList);
        postorderTraversal(root.right, pList);
        pList.add(root.val);

    }

    public List<Integer> postorderTraversal2(TreeNode root) {
        List<Integer> pList = new ArrayList<>();

        Stack<TreeNode> stack = new Stack<>();

        TreeNode pre = null;
        while (root != null || !stack.isEmpty()){
            while (root!= null){
                stack.add(root);
                root= root.left;
            }
            root = stack.peek();

            if(root.right == null || root.right == pre){
                pList.add(root.val);
                pre = root;
                stack.pop();
                root = null;
            }else {
                root = root.right;
            }
        }
        return pList;
    }
}
