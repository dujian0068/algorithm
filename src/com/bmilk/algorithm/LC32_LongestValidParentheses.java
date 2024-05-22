package com.bmilk.algorithm;

public class LC32_LongestValidParentheses {
    public static void main(String[] args) {
        LC32_LongestValidParentheses o = new LC32_LongestValidParentheses();

        int i = o.longestValidParentheses("()(()");
        System.out.println(i);
    }
    public int longestValidParentheses(String s) {
        int res = 0;
        int left = 0;
        int right = 0;
        for (char c : s.toCharArray()) {
            if(c == '(') left++;
            if(c==')') right++;
            if(left == right) res = Math.max(res, left+right);
            if(right > left){
                right =0;
                left =0;
            }
        }
        left =0;
        right=0;

        for (int i = s.length()-1; i>=0;i--){
            if(s.charAt(i) == ')') left++;
            else right++;
            if(left == right) res = Math.max(res, left+right);
            if(right>left) {
                left =0;
                right = 0;
            }
        }
        return res;

    }

}
