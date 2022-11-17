package com.bmilk.algorithm.dp;

public class BM69_Solve {

    public static void main(String[] args) {
        BM69_Solve service = new BM69_Solve();
        int solve = service.solve("10");
        System.out.println(solve);
    }

    public int solve(String nums) {

        if (nums.length() == 0 || "0".equals(nums)) return 0;
        char[] numChars = nums.toCharArray();
        if (numChars[0] == '0') return 0;
        for (int i = 1; i < numChars.length; i++) {
            if (numChars[i] == '0' && numChars[i - 1] != '1' && numChars[i - 1] != '2') {
                return 0;
            }
        }
        int[] dp = new int[numChars.length];

        dp[0] = 1;
        if (numChars.length > 1) {
            if (numChars[0] == '1' && numChars[1] != '0') {
                dp[1] = 2;
            } else if (numChars[0] == '2' && numChars[1] < '7' && numChars[1] > '0') {
                dp[1] = 2;
            } else {
                dp[1] = 1;
            }
        }
        for (int i = 2; i < numChars.length; i++) {
            if (numChars[i - 1] == '1' && numChars[i] != '0') {
                dp[i] = dp[i - 1] + dp[i - 2];
            } else if (numChars[i - 1] == '2' && numChars[i] < '7' && numChars[i] > '0') {
                dp[i] = dp[i - 1] + dp[i - 2];
            } else {
                dp[i] = dp[i - 1];
            }
        }

        return dp[numChars.length - 1];

    }
}
