package com.bmilk.algorithm.tree;

public class LC450_DeleteNode {
    public static void main(String[] args) {
        LC450_DeleteNode o = new LC450_DeleteNode();
        TreeNode node2 = new TreeNode(2);
        TreeNode node4 = new TreeNode(4);
        TreeNode node7 = new TreeNode(7);
        TreeNode node3 = new TreeNode(3, node2, node4);
        TreeNode node6 = new TreeNode(6, null, node7);
        TreeNode node5 = new TreeNode(5, node3, node6);
        o.deleteNode(node5, 7);

    }


    public TreeNode deleteNode(TreeNode root, int key) {
        if(root == null){
            return null;
        }
        if(key == root.val){
            if(root.left == null){
                return root.right;
            }
            TreeNode newNode = searchLeftMax(root);
            newNode.left = root.left;
            newNode.right = root.right;
            return newNode;

        } else if ( root.val > key){
            root.left = deleteNode(root.left, key);
        }else {
            root.right = deleteNode(root.right, key);
        }
        return root;
    }

    public TreeNode searchLeftMax(TreeNode root){
        TreeNode node1 = root;
        TreeNode result = null;
        if(node1.left.right == null){
            result =  root.left;
            root.left = root.left.left;
            result.left = null;
            return result;
        }
        node1= node1.left;
        TreeNode node2 = node1.right;
        TreeNode node3 = node2.right;
        while (node3 != null){
            node1 = node2;
            node2 = node3;
            node3 = node3.right;
        }
        node1.right = node2.left;
        node2.left = null;
        return node2;
    }
}
