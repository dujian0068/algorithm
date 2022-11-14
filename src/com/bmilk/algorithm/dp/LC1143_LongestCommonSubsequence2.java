package com.bmilk.algorithm.dp;

import java.util.List;

public class LC1143_LongestCommonSubsequence2 {
    public static void main(String[] args) {
        LC1143_LongestCommonSubsequence2 service = new LC1143_LongestCommonSubsequence2();
        String lcs = service.LCS("abcde", "ace");
        System.out.println(lcs);

    }

    public String LCS(String text1, String text2) {

        int n = text1.length();
        int m = text2.length();
        char[] test1c = text1.toCharArray();
        char[] test2c = text2.toCharArray();

        int[][] dp = new int[n+1][m+1];
        int[][] rec = new int[n+1][m+1];

        for (int i =0;i<=n;i++){
            dp[i][0] = 0;
            rec[i][0] = 0;
        }
        for (int i =0;i<=m;i++){
            dp[0][i] = 0;
            rec[0][1] = 0;
        }

        for (int i =1; i<=n;i++){
            for (int j =1; j<=m ; j++){
                if(test1c[i-1] == test2c[j-1]){
                    dp[i][j] = dp[i-1][j-1] +1;
                    rec[i][j] = 1;
                }else {
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                    if(dp[i-1][j]> dp[i][j-1]){
                        dp[i][j] = dp[i-1][j];
                        rec[i][j] = 2;
                    }else {
                        dp[i][j] = dp[i][j-1];
                        rec[i][j]= 3;

                    }
                }
            }
        }
        char[] res = new char[dp[n][m]];
        int i = res.length-1;
        int x=n,y=m;
        while (dp[x][y] != 0){
            if(rec[x][y] == 1){
                res[i] = test1c[x-1];
                i--;
                x--;
                y--;
            }else if(rec[x][y] == 2){
                x--;
            }else {
                y--;
            }
        }
        return new String(res);
    }
}
