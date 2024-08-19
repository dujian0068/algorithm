package com.bmilk.algorithm.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

public class LC572_IsSubtree {
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        List<Integer> rootList = pre(root);
        List<Integer> subList = pre(subRoot);
        for (int i = 0; i< rootList.size(); i++){
            for (int j = 0, ri = i; j< subList.size() && ri < rootList.size(); j++, ri++){
                if(!Objects.equals(rootList.get(ri), subList.get(j))){
                    break;

                }
                if(Objects.equals(rootList.get(ri), subList.get(j)) && j == subList.size()-1){
                    return true;
                }
            }
        }
        return false;

    }

    private List<Integer> pre(TreeNode root){
        List<Integer> res = new ArrayList<>();
        LinkedList<TreeNode> list = new LinkedList<>();
        list.addFirst(root);
        while (!list.isEmpty()){
            TreeNode node  = list.pollFirst();
            if(null == node){
                res.add(Integer.MAX_VALUE);
                continue;
            }
            res.add(node.val);
            list.addFirst(node.right);
            list.addFirst(node.left);

        }
        return res;
    }
}
