package com.bmilk.algorithm.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class LC103_ZigzagLevelOrder {

    public static void main(String[] args) {
        TreeNode node15 = new TreeNode(15);
        TreeNode node7 = new TreeNode(7);

        TreeNode node20 = new TreeNode(20,node15, node7);
        TreeNode node9 = new TreeNode(9);
        TreeNode node3 = new TreeNode(3,node9, node20);
        LC103_ZigzagLevelOrder o = new LC103_ZigzagLevelOrder();
        List<List<Integer>> lists = o.zigzagLevelOrder(node3);
        System.out.println(lists);

    }

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        
        if(null == root){
            return new ArrayList<>();
        }
        List<List<Integer>> result = new ArrayList<>();

        Stack<TreeNode> stack1 = new Stack<>();
        Stack<TreeNode> stack2 = new Stack<>();
        stack1.add(root);
        while (!stack1.isEmpty()){
            List<Integer> tmp = new ArrayList<>();
            while (!stack1.isEmpty()){
                TreeNode pop = stack1.pop();
                tmp.add(pop.val);
                if(pop.left!= null)  stack2.push(pop.left);
                if(pop.right!= null) stack2.push(pop.right);
            }
            result.add(new ArrayList<>(tmp));
            tmp.clear();
            while (!stack2.isEmpty()){
                TreeNode pop = stack2.pop();
                tmp.add(pop.val);
                if(pop.right!= null)  stack1.push(pop.right);
                if(pop.left!= null) stack1.push(pop.left);
            }
            if(tmp.size()!=0){
                result.add(tmp);
            }
        }
        return result;
        

    }

}
