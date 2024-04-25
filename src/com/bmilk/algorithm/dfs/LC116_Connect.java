package com.bmilk.algorithm.dfs;

public class LC116_Connect {


    public Node connect(Node root) {
        if(null ==root){
            return root;
        }
        if(null != root.left){
            root.left.next = root.right;
        }
        if( null != root.right && null!=root.next){
            root.right.next = root.next.left;
        }
        connect(root.left);
        connect(root.right);

        return root;
    }


    static class Node{
        private int val;

        private Node left;

        private Node right;

        private Node next;

        public Node(int val) {
            this.val = val;
        }
    }
}
