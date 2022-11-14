package com.bmilk.algorithm.dp;

public class LC76_MinCostClimbingStairs {
    public static void main(String[] args) {
        LC76_MinCostClimbingStairs service = new LC76_MinCostClimbingStairs();
        int[] cost = {1,100,1,1,1,100,1,1,100,1};
        int i = service.minCostClimbingStairs(cost);
        System.out.println(i);
    }

    public int minCostClimbingStairs(int[] cost) {
        int[] dp = new int[cost.length+1];
        if(cost.length == 1) return cost[0];
        if(cost.length == 2) return Math.min(cost[0], cost[1]);


        dp[0] = 0;
        dp[1] = 0;
        for (int i=2; i<dp.length;i++){
            dp[i] = Math.min((dp[i-2]+cost[i-2]), dp[i-1] + cost[i-1]);
        }
        return dp[cost.length];
    }
}
