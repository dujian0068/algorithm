package com.bmilk.algorithm.tree;

import java.util.ArrayList;
import java.util.List;

public class LC129_SumNumbers {

    public static void main(String[] args) {
        LC129_SumNumbers o = new LC129_SumNumbers();
//        TreeNode node2 = new TreeNode(2);
//        TreeNode node3 = new TreeNode(3);
//        TreeNode node1 = new TreeNode(1, node2, node3);
        TreeNode node1 = new TreeNode(1);
        TreeNode node0 = new TreeNode(0, node1, null);
        int i = o.sumNumbers(node0);
    }

    private List<Integer> sumList = new ArrayList<>();

    public int sumNumbers(TreeNode root) {
        preOrder(root, 0);
        return sumList.stream().mapToInt(Integer::intValue).sum();
    }

    private void preOrder(TreeNode root, int sum) {

        if (root.left == null && root.right == null) {
            sumList.add(sum * 10 + root.val);
            return;
        }
        if (null != root.left) {
            preOrder(root.left, sum * 10 + root.val);
        }
        if (null != root.right) {
            preOrder(root.right, sum * 10 + root.val);
        }
    }
}
