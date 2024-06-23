package com.bmilk.algorithm.tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class LC1382_balanceBST {
    public TreeNode balanceBST(TreeNode root) {
        List<TreeNode> treeNodes = midOrder(root);
        TreeNode treeNode = buildBSTTree(treeNodes, 0, treeNodes.size() - 1);
        return treeNode;
    }

    public TreeNode buildBSTTree(List<TreeNode> list, int start, int end){
        if(end<start) return null;
        if(end == start) return list.get(end);
        int mid =  (end+start)/2;
        TreeNode root = list.get(mid);
        root.left = buildBSTTree(list, start, mid-1);
        root.right = buildBSTTree(list, mid+1, end);
        return root;
    }

    private List<TreeNode> midOrder(TreeNode root){
        List<TreeNode> result = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode node = root;
        while (null != node || !stack.isEmpty()){
            while (null != node){
                stack.push(node);
                node = node.left;
            }
            TreeNode pop = stack.pop();
            node = pop.right;
            pop.left = null;
            pop.right = null;
            result.add(pop);
        }
        return result;
    }
}
