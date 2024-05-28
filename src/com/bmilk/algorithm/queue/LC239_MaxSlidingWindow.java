package com.bmilk.algorithm.queue;

import java.util.*;

public class LC239_MaxSlidingWindow {

    public static void main(String[] args) {
        LC239_MaxSlidingWindow o = new LC239_MaxSlidingWindow();
        int[] nums = {1,3,1,2,0,5};
        int[] ints = o.maxSlidingWindow(nums, 3);
        System.out.println(Arrays.toString(ints));
    }

    public int[] maxSlidingWindow(int[] nums, int k) {
        Deque<Integer> deque = new LinkedList<>();
        int[] result = new int[nums.length-k+1];
        for (int i = 0; i<k-1; i++){
            addQueue(deque, i, nums, 0);
        }
        for (int i = k-1; i<nums.length; i++){
            addQueue(deque, i, nums, i-k+1);
            result[i-k+1] = nums[deque.peek()];
        }
        return result;
    }

    private void addQueue(Deque<Integer> deque, int i, int[] nums, int start){
        while (!deque.isEmpty() && deque.peek() < start){
            deque.poll();
        }
        while (!deque.isEmpty() && nums[deque.peekLast()] < nums[i]){
            deque.pollLast();
        }
        deque.add(i);
    }
}
