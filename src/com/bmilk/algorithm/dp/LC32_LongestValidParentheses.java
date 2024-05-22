package com.bmilk.algorithm.dp;


public class LC32_LongestValidParentheses {

    public static void main(String[] args) {
        LC32_LongestValidParentheses o = new LC32_LongestValidParentheses();

        int i = o.longestValidParentheses("())");
        System.out.println(i);
    }

    public int longestValidParentheses(String s) {
        char[] charArray = s.toCharArray();

        int len = charArray.length;

        int[] dp = new int[len];
        int res = 0;
        for (int i = 1; i<len;i++){

            if(charArray[i] == '('){
                dp[i] = 0;
            }else if(charArray[i-1] == '('){
                dp[i] = 2 + (i-2 >=0 ? dp[i-2] : 0);
            }else {
                if(i-1-dp[i-1] >=0 && charArray[i-1-dp[i-1]] == '('){
                    dp[i] = dp[i-1] +2 + ((i-2-dp[i-1]) >=0 ? dp[i-2-dp[i-1]] : 0);
                }
            }
            res = Math.max(dp[i], res);

        }
        return res;
    }
}
