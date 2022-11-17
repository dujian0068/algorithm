package com.bmilk.algorithm.dp;

public class LC300_LengthOfLIS {
    public static void main(String[] args) {
        LC300_LengthOfLIS service = new LC300_LengthOfLIS();
        int[] nums = {0,1,0,3,2,3};
        int i = service.lengthOfLIS(nums);
        System.out.println(i);

    }

    public int lengthOfLIS(int[] nums) {
        if(nums.length == 1) return 1;
        int n = nums.length;
        int[] dp = new int[n];
        for (int i=0; i<n ;i++){
            dp[i] = 1;
        }
        int max = 0;
        for (int i=1; i<n;i++){
            for (int j=0;j<i;j++){
                if(nums[i]>nums[j]){
                    dp[i] = Math.max(dp[i], dp[j]+1);
                }
            }
            max = Math.max(dp[i], max);
        }
        return max;
    }
}
