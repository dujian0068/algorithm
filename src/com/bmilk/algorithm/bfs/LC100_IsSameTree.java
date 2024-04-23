package com.bmilk.algorithm.bfs;

import java.util.LinkedList;
import java.util.Queue;

public class LC100_IsSameTree {

    public boolean isSameTree(TreeNode p, TreeNode q) {
        if(null == p && null == q) return true;

        if(null == p || null == q) return false;


        Queue<TreeNode> pQ = new LinkedList<>();
        Queue<TreeNode> qQ = new LinkedList<>();


        pQ.add(p);
        qQ.add(q);
        while (!pQ.isEmpty() && !qQ.isEmpty()){
            TreeNode pT = pQ.poll();
            TreeNode qT = qQ.poll();
            if(pT.val != qT.val){
                return false;
            }
            if(null == pT.left && null == qT.left){

            }else if(null == pT.left || null == qT.left){
                return false;
            }else {
                pQ.add(pT.left);
                qQ.add(qT.left);
            }

            if(null == pT.right && null == qT.right){

            }else if(null == pT.right || null == qT.right){
                return false;
            }else {
                pQ.add(pT.right);
                qQ.add(qT.right);
            }

        }
        return true;

    }

private  class TreeNode {
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

