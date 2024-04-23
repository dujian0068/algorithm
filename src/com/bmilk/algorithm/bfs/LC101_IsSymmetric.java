package com.bmilk.algorithm.bfs;

import java.util.LinkedList;
import java.util.Queue;

public class LC101_IsSymmetric {

    public boolean isSymmetric(TreeNode root) {
        if(null == root) return true;

        TreeNode leftRoot = root.left;
        TreeNode rightRoot = root.right;

        if( null == leftRoot && null == rightRoot) return true;
        if(null == leftRoot || null == rightRoot) return false;

        Queue<TreeNode> leftQ = new LinkedList<>();
        Queue<TreeNode> rightQ = new LinkedList<>();
        leftQ.add(leftRoot);
        rightQ.add(rightRoot);

        while (!leftQ.isEmpty() && !rightQ.isEmpty()){
            TreeNode leftNode = leftQ.poll();
            TreeNode rightNode = rightQ.poll();
            if(leftNode.val != rightNode.val){
                return false;
            }
            if(null == leftNode.left && null == rightNode.right){

            }else if(null == leftNode.left || null == rightNode.right){
                return false;
            }else {
                leftQ.add(leftNode.left);
                rightQ.add(rightNode.right);
            }

            if(null == leftNode.right && null == rightNode.left){

            }else if(null == leftNode.right || null == rightNode.left){
                return false;
            }else {
                leftQ.add(leftNode.right);
                rightQ.add(rightNode.left);
            }

        }
        return true;
    }


    static  class TreeNode {
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
