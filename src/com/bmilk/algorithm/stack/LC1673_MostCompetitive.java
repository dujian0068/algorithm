package com.bmilk.algorithm.stack;

import java.util.Arrays;
import java.util.Stack;

public class LC1673_MostCompetitive {

    public static void main(String[] args) {

        LC1673_MostCompetitive o = new LC1673_MostCompetitive();
        int[] ints = o.mostCompetitive(new int[]{2, 4, 3, 3, 5, 4, 9, 6}, 4);
        System.out.println(Arrays.toString(ints));

    }

    public int[] mostCompetitive(int[] nums, int k) {

        Stack<Integer> stack =  new Stack<>();

        for (int i = 0; i<nums.length; i++){
            while (!stack.isEmpty() && stack.size() + nums.length -i -1>k && stack.peek() > nums[i]){
                stack.pop();
            }
            stack.push(nums[i]);
        }
        while (stack.size() > k){
            stack.pop();
        }
        int[] result= new int[k];
        for(int i = k-1; i>=0; i--){
            result[i]= stack.pop();
        }
        return result;
    }
}
