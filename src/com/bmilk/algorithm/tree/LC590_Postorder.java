package com.bmilk.algorithm.tree;

import java.util.ArrayList;
import java.util.List;

public class LC590_Postorder {
    public static void main(String[] args) {


    }


    public List<Integer> postorder(Node root) {

        List<Integer> res = new ArrayList<>();
        postorder(root, res);
        return  res;
    }


    public void postorder(Node root, List<Integer> res) {
        if (null == root) return;
        for (Node node : root.children){
            postorder(node, res);
        }
        res.add(root.val);
    }

    class Node {
        public int val;
        public List<Node> children;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    }



}
