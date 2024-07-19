package com.bmilk.algorithm.prefixsum;

public class LC560_SubArraySum {
    public int subarraySum(int[] nums, int k) {
        int[] pSum = new int[nums.length];
        pSum[0] = nums[0];
        int res = 0;
        if(pSum[0] == k) res++;
        for (int i = 1; i< nums.length; i++){
            pSum[i] = pSum[i-1] + nums[i];
            if(pSum[i] == k) res++;

        }
        for (int i = 1; i< nums.length; i++){
            for (int j = i; j<nums.length; j++){
                if(pSum[j] - pSum[i-1] == k){
                    res++;
                }
            }
        }
        return res;


    }
}
