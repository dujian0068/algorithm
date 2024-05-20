package com.bmilk.algorithm.heap;

import java.util.Arrays;
import java.util.PriorityQueue;

public class LC239_MaxSlidingWindow {

    public static void main(String[] args) {
        LC239_MaxSlidingWindow o = new LC239_MaxSlidingWindow();
        int[] nums = {1,3,-1,-3,5,3,6,7};
        int[] ints = o.maxSlidingWindow(nums, 3);
        System.out.println(Arrays.toString(ints));
    }

    public int[] maxSlidingWindow(int[] nums, int k) {

        int[] result = new int[nums.length-k+1];
        int end = k-1;

        PriorityQueue<int[]> queue = new PriorityQueue<>((o1,o2)->o2[1]-o1[1]);

        for (int i = 0; i<=end; i++){
            queue.add(new int[]{i, nums[i]});
        }
        result[0] = queue.peek()[1];
        for (int i = end+1; i<nums.length; i++){
            queue.add(new int[]{i, nums[i]});
            while (queue.peek()[0] < i-k+1){
                queue.poll();
            }
            result[i-k+1] = queue.peek()[1];

        }
        return result;
    }
}
