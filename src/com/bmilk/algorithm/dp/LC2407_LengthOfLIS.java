package com.bmilk.algorithm.dp;

public class LC2407_LengthOfLIS {

    public static void main(String[] args) {
        LC2407_LengthOfLIS o = new LC2407_LengthOfLIS();
        int[] nums = {1,19,6,2,11,13,10};
        int i = o.lengthOfLIS(nums, 18);
        System.out.println(i);

    }


    public int lengthOfLIS(int[] nums, int k) {

        if(null == nums) return 0;
        if(1 == nums.length) return 1;

        int l = nums.length;
        int[] dp = new int[l];
        dp[0] = 1;
        int result = 1;
        for (int i=1; i<l; i++){
            dp[i] = 1;
            for (int j =i-1 ; j>=0;j--){
                if(nums[i]-nums[j] <=  k && nums[i]>nums[j]){
                    dp[i] = Math.max(dp[i], dp[j]+1);
                    result = Math.max(dp[i], result);
                }
                if(dp[j] == j+1 && dp[i] == dp[j]+1){
                    break;
                }
            }
        }
        return result;
    }

}
