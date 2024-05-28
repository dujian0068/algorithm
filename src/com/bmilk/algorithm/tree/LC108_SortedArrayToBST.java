package com.bmilk.algorithm.tree;

public class LC108_SortedArrayToBST {
    public static void main(String[] args) {

    }
    public TreeNode sortedArrayToBST(int[] nums) {
        TreeNode treeNode = buildTree(nums, 0, nums.length - 1);
        return treeNode;
    }

    public TreeNode buildTree(int[] nums, int start, int end){
        if(end<start) return null;
        if(end == start) return new TreeNode(nums[end]);

        int mid = (end+start)/2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = buildTree(nums, start, mid-1);
        root.right = buildTree(nums, mid+1, end);
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

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
