package com.bmilk.algorithm.dp;

public class LC322_CoinChange {

    public static void main(String[] args) {
        LC322_CoinChange o = new LC322_CoinChange();
        int i = o.coinChange(new int[]{1, 2, 5}, 5);
        System.out.println(i);
    }

    public int coinChange(int[] coins, int amount) {
        if(amount < 0) return 0;
        if(null == coins || coins.length ==0) return 0;
        int coinL = coins.length;
        int[] dp = new int[amount + 1];
        dp[0] = 1;

        for ( int j = 0; j< coinL; j++){
            for (int i = 1; i <= amount; i++){
                if(i-coins[j] >= 0){
                    dp[i] += dp[i-coins[j]];
                }
            }
        }
        return dp[amount];

    }

}
