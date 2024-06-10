package com.bmilk.algorithm.dp;

public class LC312_MaxCoins {

    public static void main(String[] args) {
        LC312_MaxCoins o = new LC312_MaxCoins();
        int i = o.maxCoins(new int[]{1,5});
        System.out.println(i);
    }
    public int maxCoins(int[] nums) {
        int[] tmpNums = new int[nums.length+2];
        for (int i = 0; i<nums.length; i++){
            tmpNums[i+1] = nums[i];
        }
        tmpNums[0] = 1;
        tmpNums[tmpNums.length-1] = 1;

        int[][] dp = new int[tmpNums.length][tmpNums.length];
        for (int i = 0; i< tmpNums.length; i++){
            for (int j = 0; j<tmpNums.length; j++){
                dp[i][j] = -1;
            }
        }

        int dfs = dfs(0, tmpNums.length - 1, tmpNums, dp);
        return dfs;

    }

    private int dfs(int start, int end, int[] nums, int[][] dp){
        if(start >= end-1) return 0;
        if (dp[start][end] != -1) {
            return dp[start][end];
        }
        int result = 0;
        for (int i = start +1; i<end; i++){
            result = Math.max(result, nums[i] * nums[start] * nums[end] + dfs(start, i, nums, dp) + dfs(i, end, nums, dp));
        }
        dp[start][end] = result;
        return result;
    }
}
