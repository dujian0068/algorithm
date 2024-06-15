package com.bmilk.algorithm.dp;

public class LC2786_maxScore {
    public static void main(String[] args) {
         int[] nums = {38,92,23,30,25,96,6,71,78,77,33,23,71,48,87,77,53,28,6,20,90,83,42,21,64,95,84,29,22,21,33,36,53,51,85,25,80,56,71,69,5,21,4,84,28,16,65,7};
        LC2786_maxScore o = new LC2786_maxScore();
        o.maxScore(nums, 52);
    }
    public long maxScore(int[] nums, int x) {
        if(null == nums) return 0;
        if(nums.length == 1) return nums[0];
        long[] dp = {nums[0], Long.MIN_VALUE};
        for (int i = 1; i<nums.length; i++){
            if(nums[i] % 2 == nums[i-1]%2){
                dp[0] = dp[0] + nums[i];
            }else {
                long tmp = dp[0];
                dp[0] = Math.max(dp[0] + nums[i] - x, dp[1] + nums[i]);
                dp[1] = tmp;
            }
        }
        return Math.max(dp[0], dp[1]);
    }
}
