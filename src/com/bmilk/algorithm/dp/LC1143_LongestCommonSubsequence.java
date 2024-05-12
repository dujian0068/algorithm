package com.bmilk.algorithm.dp;

public class LC1143_LongestCommonSubsequence {

    public static void main(String[] args) {
        LC1143_LongestCommonSubsequence o = new LC1143_LongestCommonSubsequence();
        int i = o.longestCommonSubsequence("abc", "abc");
        System.out.println(i);
    }

    public int longestCommonSubsequence(String text1, String text2) {

        if(null == text1 || null == text2 || "".equals(text1) || "".equals(text2)) return 0;

        int row = text1.length();
        int col = text2.length();

        int[][] dp = new int[row][col];
        if(text1.charAt(0) == text2.charAt(0)){
            dp[0][0] = 1;
        }else {
            dp[0][0] = 0;
        }

        for (int i = 1; i< row; i++){
            dp[i][0] = dp[i-1][0];
            if(text1.charAt(i) == text2.charAt(0)){
                dp[i][0] = 1;
            }
        }
        for(int j =1; j< col; j++){
            dp[0][j] = dp[0][j-1];

            if(text1.charAt(0) == text2.charAt(j)){
                dp[0][j] = 1;
            }
        }

        for (int i=1; i<row; i++){
            for (int j =1; j<col; j++){

                if(text1.charAt(i) == text2.charAt(j)){
                    dp[i][j] = dp[i-1][j-1] + 1;
                }else {
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }
        return dp[row-1][col-1];
    }

}
