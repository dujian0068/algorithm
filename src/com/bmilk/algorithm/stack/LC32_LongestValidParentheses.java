package com.bmilk.algorithm.stack;

import java.util.Stack;

public class LC32_LongestValidParentheses {
    public static void main(String[] args) {
       LC32_LongestValidParentheses o = new LC32_LongestValidParentheses();

        int i = o.longestValidParentheses("()()())");
        System.out.println(i);
    }
    public int longestValidParentheses(String s){

        char[] charArray = s.toCharArray();
        Stack<Integer> stack = new Stack<>();
        for (int i=0; i<charArray.length; i++){
            if(stack.isEmpty()){
                stack.push(i);
            }else {
                if(charArray[i] == ')' && charArray[stack.peek()] == '('){
                    stack.pop();
                }else {
                    stack.push(i);
                }
            }
        }
        if(stack.isEmpty()){
            return s.length();
        }
        int before = charArray.length;
        int res = 0;
        while (!stack.isEmpty()){
            res = Math.max(before - stack.peek() - 1, res);
            before = stack.pop();
        }
        res = Math.max(before - 0, res);
        return res;
    }
}
