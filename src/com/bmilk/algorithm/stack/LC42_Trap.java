package com.bmilk.algorithm.stack;

import java.util.Stack;

public class LC42_Trap {

    public static void main(String[] args) {
        int[] height = {0,1,0,2,1,0,1,3,2,1,2,1};
        LC42_Trap o = new LC42_Trap();
        int trap = o.trap(height);
        System.out.println(trap);
    }

    public int trap(int[] height) {

        if(null == height || height.length == 1){
            return 0;
        }

        int result = 0;
        Stack<Integer> stack = new Stack<>();
        for (int i =0; i< height.length; i++){
            if(stack.isEmpty()){
                stack.push(i);
                continue;
            }
            int before = stack.peek();
            while (!stack.isEmpty() && height[before] < height[i]){
                Integer pop = stack.pop();
                if(!stack.isEmpty()){
                    before = stack.peek();
                    result += (Math.min(height[i], height[before])-height[pop]) * (i-before-1) ;
                }
            }
            stack.push(i);
        }
        return result;

    }
}
