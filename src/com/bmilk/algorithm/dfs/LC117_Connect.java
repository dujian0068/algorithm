package com.bmilk.algorithm.dfs;

public class LC117_Connect {

    public static void main(String[] args) {
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        Node node5 = new Node(5);
        Node node7 = new Node(7);
        node1.left = node2;
        node1.right = node3;
        node2.left = node4;
        node2.right = node5;
        node3.right = node7;

        LC117_Connect o = new LC117_Connect();
        o.connect(node1);


    }

    public Node connect(Node root) {

        if (null == root) {
            return root;
        }

        Node left = null;
        Node childC = null;
        Node p = root;
        while (p != null) {
            if (p.left != null) {
                if (left == null) left = p.left;
                if (null == childC) {
                    childC = p.left;
                }else {
                    childC.next = p.left;
                    childC = childC.next;
                }
            }
            if(null != p.right){
                if (left == null) left = p.right;
                if (null == childC) {
                    childC = p.right;
                }else {
                    childC.next = p.right;
                    childC = childC.next;
                }
            }
            p = p.next;
        }
        connect(left);


        return root;

    }


    static class Node {
        private int val;

        private Node left;

        private Node right;

        private Node next;

        public Node(int val) {
            this.val = val;
        }
    }
}
