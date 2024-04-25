package com.bmilk.algorithm.bfs;

import java.util.LinkedList;
import java.util.Queue;

public class LC116_Connect {

    public Node connect(Node root) {

        if(null == root){
            return root;
        }

        Queue<Node> q = new LinkedList<>();
        q.add(root);

        while (!q.isEmpty()){
            int len = q.size();

            Node before= null;
            for (int i=0; i<len;i++){
                if(null ==before){
                    before = q.poll();
                }else {
                    before.next = q.poll();
                    before = before.next;
                }
                if(null != before.left){
                    q.add(before.left);
                }
                if(null != before.right){
                    q.add(before.right);
                }
            }
        }
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
