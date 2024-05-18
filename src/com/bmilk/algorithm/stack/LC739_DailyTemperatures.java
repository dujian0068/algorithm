package com.bmilk.algorithm.stack;

import java.util.Stack;

public class LC739_DailyTemperatures {
    public int[] dailyTemperatures(int[] temperatures) {
        int[] result = new int[temperatures.length];
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i<temperatures.length; i++){
            if(stack.isEmpty()){
                stack.push(i);
            }else {
                while (!stack.isEmpty() && temperatures[stack.peek()] < temperatures[i]){
                    int tmp = stack.pop();
                    result[tmp] = i-tmp;
                }
                stack.push(i);
            }
        }
        while (!stack.isEmpty()){
            result[stack.pop()] = 0;
        }
        return result;
    }
}
