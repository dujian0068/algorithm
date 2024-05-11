package com.bmilk.algorithm.dfs;

import com.bmilk.algorithm.tree.LC102_LevelOrder;

public class LC124_MaxPathSum {
    int result = Integer.MIN_VALUE;

    public static void main(String[] args) {
        TreeNode node4 = new TreeNode(15);
        TreeNode node5 = new TreeNode(7);
        TreeNode node2 = new TreeNode(9);
        TreeNode node3 = new TreeNode(20, node4, node5);
        TreeNode node1 = new TreeNode(-10,node2, node3);

        TreeNode node6 = new TreeNode(-3);

        LC124_MaxPathSum o = new LC124_MaxPathSum();
        int i = o.maxPathSum(node1);
        System.out.println(i);
    }


    public int maxPathSum(TreeNode root){
        dfs(root);
        return result;
    }

    public int dfs(TreeNode root) {

        int leftRootSum = root.val;
        if(root.left != null){
            int leftSum = dfs(root.left);
            leftRootSum = leftSum + root.val;
            result = Math.max(Math.max(leftSum, leftRootSum), result);
        }
        int rightRootSum =  root.val;
        if(root.right != null){
            int rightSum = dfs(root.right);
            rightRootSum = rightSum + root.val;
            result = Math.max(Math.max(rightSum, rightRootSum), result);
        }

        int allSum = leftRootSum + rightRootSum - root.val;

        result = Math.max(Math.max(result, root.val), allSum);

        return Math.max(Math.max(leftRootSum, rightRootSum),  root.val);
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
