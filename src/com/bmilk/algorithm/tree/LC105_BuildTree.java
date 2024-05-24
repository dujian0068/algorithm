package com.bmilk.algorithm.tree;

import java.net.URLEncoder;

public class LC105_BuildTree {

    public static void main(String[] args) {
        LC105_BuildTree o = new LC105_BuildTree();
        TreeNode treeNode = o.buildTree(new int[]{1,2,3}, new int[]{2,3,1});
        System.out.println(treeNode);

    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int len = preorder.length;
        TreeNode treeNode = buildTree(preorder, inorder, 0, len - 1, 0, len - 1);
        return treeNode;
    }

    private TreeNode buildTree(int[] preorder, int[] inorder, int pStart, int pEnd, int iStart, int iEnd){
        if(pEnd<pStart || iEnd < iStart) return null;
        TreeNode root = new TreeNode(preorder[pStart]);
        int iRootIndex = -1;
        for (int i = iStart;i<=iEnd; i++){
            if(preorder[pStart] == inorder[i]){
                iRootIndex = i;
                break;
            }
        }
        root.left = buildTree(preorder, inorder, pStart+1, pStart+iRootIndex-iStart, iStart, iRootIndex-1);
        root.right = buildTree(preorder, inorder, pStart+iRootIndex-iStart+1, pEnd, iRootIndex+1, iEnd);

        return root;
    }




    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        void TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }


}
