package com.bmilk.algorithm.stack;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

public class LC503_NextGreaterElements {

    public static void main(String[] args) {
        LC503_NextGreaterElements o = new LC503_NextGreaterElements();
        int[] ints = o.nextGreaterElements(new int[]{1,1,1,1,1});
        System.out.println(Arrays.toString(ints));
    }
    public int[] nextGreaterElements(int[] nums) {
        int[] result = new int[nums.length];
        Deque<Integer> deque = new LinkedList<>();

        for (int i =0; i<nums.length; ){
            while (!deque.isEmpty() && nums[deque.peekLast()] < nums[i]){
                result[deque.pollLast()] = nums[i];
            }
            if(!deque.isEmpty() && deque.peekFirst() == i){
                break;
            }
            deque.addLast(i);
            i++;
            if (i == nums.length) {
                i = 0;
            }
        }
        while (!deque.isEmpty()){
            result[deque.pollLast()] = -1;
        }
        return result;
    }
}
