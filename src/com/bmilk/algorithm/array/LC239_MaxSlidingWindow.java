package com.bmilk.algorithm.array;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class LC239_MaxSlidingWindow {


    public int[] maxSlidingWindow(int[] nums, int k) {
        PriorityQueue<Integer> queue = new PriorityQueue<>(k, (a, b)->b-a);

        int len = nums.length;
        int[] res = new int[len-k+1];
        for (int i=0;i<k; i++){
            queue.add(nums[i]);
        }
        res[0] = queue.peek();
        for (int i=k, j=1; i<len; i++,j++){
            queue.remove(nums[i-k]);
            queue.add(nums[i]);
            res[i]=queue.peek();
        }
        return res;
    }
}
