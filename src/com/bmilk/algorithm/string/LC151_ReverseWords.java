package com.bmilk.algorithm.string;

import java.util.Stack;

public class LC151_ReverseWords {
    public static void main(String[] args) {
        String s = "  Bob    Loves  Alice   ";
        LC151_ReverseWords o = new LC151_ReverseWords();
        String s1 = o.reverseWords(s);
        System.out.println(s1);
    }
    public String reverseWords(String s) {
        Stack<String> stack = new Stack<>();
        int slow = 0;
        int quick =1;
        while (quick <= s.length()){
            if(quick == s.length() || s.charAt(quick) == ' '){
                String substring = s.substring(slow, quick);
                if(!" ".equals(substring) && !"".equals(substring)){
                    stack.push(substring);
                }
                slow = quick+1;
            }
            quick++;
        }
        StringBuilder sb = new StringBuilder();
        if(!stack.isEmpty()){
            sb.append(stack.pop());
        }
        while (!stack.isEmpty()){
            sb.append(" ");
            sb.append(stack.pop());
        }
        return sb.toString();

    }
}
