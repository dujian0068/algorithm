package com.bmilk.algorithm.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LC102_LevelOrder {

    public List<List<Integer>> levelOrder(TreeNode root) {

        List<List<Integer>> result = new ArrayList<>();
        if(null == root){
            return result;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()){
            int len = queue.size();
            List<Integer> tmp = new ArrayList<>();
            for (int i =0; i<len; i++){
                TreeNode poll = queue.poll();
                tmp.add(poll.val);
                if(null != poll.left){
                    queue.add(poll.left);
                }
                if(null != poll.right){
                    queue.add(poll.right);
                }
            }
            result.add(tmp);
        }
        return result;

    }

    static class TreeNode{

        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(){}
        TreeNode(int val){ this.val = val;}

        public TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
