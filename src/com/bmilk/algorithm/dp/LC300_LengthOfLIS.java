package com.bmilk.algorithm.dp;

public class LC300_LengthOfLIS {

    public int lengthOfLIS(int[] nums) {

        if(null == nums) return 0;
        if(1 == nums.length) return 1;


        int l = nums.length;
        int[] dp = new int[l];
        dp[0] = 1;

        int result = 0;
        for (int i =1;i<l;i++){
            dp[i] = 1;
            for (int j =0 ; j<i; j++){
                if(nums[i] > nums[j]){
                    dp[i] = Math.max(dp[i] , dp[j]+1);
                    result = Math.max(dp[i], result);
                }

            }
        }
        return result;


    }

}
