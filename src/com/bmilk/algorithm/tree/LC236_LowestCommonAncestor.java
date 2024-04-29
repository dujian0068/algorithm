package com.bmilk.algorithm.tree;

public class LC236_LowestCommonAncestor {
    private TreeNode ans = null;
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        dfs(root, p, q);
        return ans;
    }

    private boolean dfs(TreeNode root, TreeNode p, TreeNode q){
        if(root == null) return false;
        boolean left = dfs(root.left, p, q);
        boolean right = dfs(root.right, p, q);
        if((left && right) || ((left || right) && (root.val == p.val || root.val == q.val))){
            ans = root;
        }
        return left || right || root.val == p.val || root.val == q.val;
    }

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }

    }
}
