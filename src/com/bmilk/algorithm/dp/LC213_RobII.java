package com.bmilk.algorithm.dp;

public class LC213_RobII {

    public static void main(String[] args) {
        LC213_RobII service = new LC213_RobII();
        int[] nums = {4,9,3,-1};
        int rob = service.rob(nums);
        System.out.println(rob);
    }

    public int rob(int[] nums) {
        if(nums.length<2){
            return nums[0];
        }

        int[][] dp = new int[nums.length][2];


        dp[0][0] = nums[0];
        dp[0][1] = 0;
        dp[1][0] = nums[0];
        dp[1][1] = nums[1];

        for (int i= 2 ; i< nums.length-1;i++){
            dp[i][0] = Math.max(dp[i-1][0], dp[i-2][0]+nums[i]);
        }
        for (int i=2; i<nums.length;i++){
            dp[i][1] = Math.max(dp[i-1][1], dp[i-2][1]+nums[i]);
        }
        return Math.max(dp[nums.length-2][0], dp[nums.length-1][1]);
    }
}
