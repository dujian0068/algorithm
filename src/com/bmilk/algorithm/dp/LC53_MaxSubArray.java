package com.bmilk.algorithm.dp;

public class LC53_MaxSubArray {
    public static void main(String[] args) {

    }

    public int maxSubArray(int[] nums) {
        int dp = nums[0];
        int result = dp;


        for (int i = 1; i< nums.length;i++){
            dp = Math.max((dp + nums[i]), nums[i]);
            result = Math.max(dp, result);
        }
        return result;
    }
}
