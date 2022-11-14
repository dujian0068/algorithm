package com.bmilk.algorithm;

import com.bmilk.algorithm.node.TreeNode;
import com.bmilk.algorithm.tree.LC144_PreorderTraversal;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Stack;

public class Test {
    public static void main(String[] args) {

    }

    public ArrayList<Integer> GetLeastNumbers_Solution(int [] input, int k) {
        PriorityQueue<Integer> queue = new PriorityQueue<>(k, (o1, o2)-> o2.compareTo(o1));

        for (int value : input){
            if(queue.size()<k){
                queue.add(value);
            }else {
                if( queue.peek() > value){
                    queue.poll();
                    queue.add(value);
                }
            }
        }
        return new ArrayList<>(queue);
    }
}
