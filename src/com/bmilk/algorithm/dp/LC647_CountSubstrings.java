package com.bmilk.algorithm.dp;

public class LC647_CountSubstrings {
    public static void main(String[] args) {
        LC647_CountSubstrings o = new LC647_CountSubstrings();
        int abc = o.countSubstrings("aaa");
        System.out.println(abc);

    }

    public int countSubstrings(String s) {
        int result = 0;
        if(null == s || "".equals(s)) return 0;
        int l = s.length();
        boolean[][] dp = new boolean[l][l];

        for (int i = l-1; i>=0; i--){
            for (int j = i; j<l; j++){
                if(j==i){
                    dp[i][j] = true;
                    result ++;
                }else if(s.charAt(i) == s.charAt(j) && (dp[i+1][j-1] || j-i ==1)){
                    dp[i][j] = true;
                    result++;
                }
            }
        }
        return result;

    }
}
