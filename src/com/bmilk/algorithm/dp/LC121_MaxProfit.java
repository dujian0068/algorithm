package com.bmilk.algorithm.dp;

public class LC121_MaxProfit {
    public static void main(String[] args) {

    }
    // max = max(price[i]- i天之前的最小值 ， max)

    public int maxProfit(int[] prices) {

        int[] dp = new int[prices.length];

        dp[0] = prices[0];
        int res = 0;
        for(int i=1; i<prices.length;i++){
            dp[i] = Math.min(prices[i], dp[i-1]);
            res = Math.max(res, prices[i] - dp[i-1]);
        }
        return  res;
    }
}
