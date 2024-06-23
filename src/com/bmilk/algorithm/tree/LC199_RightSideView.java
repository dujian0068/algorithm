package com.bmilk.algorithm.tree;

import java.util.*;

public class LC199_RightSideView {

    Map<Integer, TreeNode> nodeMap = new HashMap<>();

    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        dfs(root, 1);
        if(nodeMap.isEmpty()) return result;
        for (int i =1; null != nodeMap.get(i); i++){
            result.add(nodeMap.get(i).val);
        }
        return result;

    }

    public void dfs(TreeNode root, int deepth){
        if(root == null ) return;
        nodeMap.putIfAbsent(deepth, root);
        dfs(root.right, deepth+1);
        dfs(root.left, deepth+1);

    }

    public List<Integer> bfs(TreeNode root){
        List<Integer> result = new ArrayList<>();
        if(null == root){
            return result;
        }
        Queue<TreeNode> nodeQueue = new LinkedList<>();
        nodeQueue.add(root);
        while (!nodeQueue.isEmpty()){
            int size = nodeQueue.size();
            result.add(nodeQueue.peek().val);
            for (int i = 0; i< size; i++){
                TreeNode poll = nodeQueue.poll();
                if(null != poll.right){
                    nodeQueue.add(poll.right);
                }
                if(null != poll.left){
                    nodeQueue.add(poll.left);
                }
            }
        }
        return result;
    }

}
