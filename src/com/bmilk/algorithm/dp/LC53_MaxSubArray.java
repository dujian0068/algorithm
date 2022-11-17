package com.bmilk.algorithm.dp;

public class LC53_MaxSubArray {
    public static void main(String[] args) {
        LC53_MaxSubArray service = new LC53_MaxSubArray();


    }

    public int maxSubArray(int[] nums) {

        int[] dp = new int[nums.length];
        int res = nums[0];

        dp[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            dp[i] = Math.max(dp[i-1]+nums[i], nums[i]);
            if(dp[i]>res){
                res = dp[i];
            }
        }
        return res;
    }
}
