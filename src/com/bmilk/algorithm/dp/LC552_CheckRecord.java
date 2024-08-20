package com.bmilk.algorithm.dp;

public class LC552_CheckRecord {
    public int checkRecord(int n) {

        int MOD = 1000000007;

        int[][][] dp = new int[n + 1][2][3];

        dp[0][0][0] = 1;
        for (int i = 1; i <= n; i++) {
            // 以P结尾
            for (int j = 0; j < 2; j++) {
                for (int k = 0; k < 3; k++) {
                    dp[i][j][0] = (dp[i][j][0] + dp[i - 1][j][k]) % MOD;
                }
            }
            // 以A结尾
            for (int k = 0; k < 3; k++) {
                dp[i][1][0] = (dp[i][1][0] + dp[i - 1][0][k]) % MOD;
            }
            //以L结尾
            for (int j = 0; j < 2; j++) {
                for (int k = 1; k < 3; k++) {
                    dp[i][j][k] = (dp[i][j][k] + dp[i - 1][j][k - 1]) % MOD;
                }
            }
        }

        int sum = 0;
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 3; j++) {
                sum = (sum + dp[n][i][j]) % MOD;
            }
        }
        return sum;

    }
}
