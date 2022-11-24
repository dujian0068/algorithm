package com.bmilk.algorithm.dp;

import java.util.Arrays;
import java.util.List;

public class LC322_CoinChange {
    public static void main(String[] args) {
        LC322_CoinChange service = new  LC322_CoinChange();
        int[] coins = {5};
        service.coinChange(coins, 20);
    }

    public int coinChange(int[] coins, int amount) {
        if(amount<1) return 0;

        int[] dp = new int[amount+1];

        for (int i=0; i<amount+1;i++){
            dp[i] = amount+1;
        }

        dp[0] = 0;
        for (int i =1; i< amount+1;i++){
            for (int j= 0; j<coins.length; j++){
                if(i >= coins[j]){
                    dp[i] = Math.min(dp[i], dp[i-coins[j]]+1);
                }
            }
        }

        System.out.println(Arrays.toString(dp));
        return dp[amount] > amount? -1: dp[amount];


    }
}
