package com.bmilk.algorithm.dp;

public class LC322_CoinChange {

    public static void main(String[] args) {
        LC322_CoinChange o = new LC322_CoinChange();

        int i = o.coinChange(new int[]{186,419,83,408}, 6249);
        System.out.println(i);
    }
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount+1];
        dp[0] = 0;
        for (int i =1; i<= amount; i++){
            dp[i] = -1;
        }
        for (int i =0; i<coins.length;i++){
            for (int j = 1; j<= amount;j++){
                if(j-coins[i] >=0 && dp[j-coins[i]] != -1){
                    if(dp[j] == -1){
                        dp[j] = dp[j-coins[i]] + 1;
                    }else {
                        dp[j] = Math.min(dp[j], dp[j-coins[i]] + 1);
                    }

                }
            }
        }
        return dp[amount];
    }

}
