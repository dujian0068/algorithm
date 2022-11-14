package com.bmilk.algorithm.dp;

public class LC1143_LongestCommonSubsequence {
    public static void main(String[] args) {
        LC1143_LongestCommonSubsequence service = new LC1143_LongestCommonSubsequence();
        int i = service.longestCommonSubsequence("abcde", "ace");
        System.out.println(i);

    }

    public int longestCommonSubsequence(String text1, String text2) {

        int n = text1.length();
        int m = text2.length();
        char[] test1c = text1.toCharArray();
        char[] test2c = text2.toCharArray();

        int[][] dp = new int[n+1][m+1];

        for (int i =0;i<=n;i++){
            dp[i][0] = 0;
        }
        for (int i =0;i<=m;i++){
            dp[0][i] = 0;
        }

        for (int i =1; i<=n;i++){
            for (int j =1; j<=m ; j++){
                if(test1c[i-1] == test2c[j-1]){
                    dp[i][j] = dp[i-1][j-1] +1;
                }else {
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }
        return dp[n][m];

    }
}
