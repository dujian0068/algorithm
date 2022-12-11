package com.bmilk.algorithm.stack;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

public class LC20_IsValid {
    public static void main(String[] args) {
        LC20_IsValid service = new LC20_IsValid();
        boolean valid = service.isValid("()[]{}");
        System.out.println(valid);
    }

    public boolean isValid(String s) {

        Set<Character> set = new HashSet<>();

        set.add(')');
        set.add('}');
        set.add(']');

        Stack<Character> stack = new Stack<>();
        char[] chars = s.toCharArray();

        for (char c : chars){
            if(set.contains(c)){
                if(stack.isEmpty()) return false;
                char p = stack.pop();
                if(c == ')' && p == '(' ||
                        c == ']' && p == '['  ||
                        c == '}' && p == '{' ){
                    continue;
                }
                return false;
            }else {
                stack.push(c);
            }

        }
        return stack.isEmpty();
    }
}
