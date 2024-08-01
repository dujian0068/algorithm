package com.bmilk.algorithm.array;

import java.util.Arrays;

public class LC2740_FindValueOfPartition {
    public int findValueOfPartition(int[] nums) {
        Arrays.sort(nums);
        int res = Integer.MAX_VALUE;
        for (int i = 1; i< nums.length;i++){
            res = Math.min(res, nums[i] - nums[i-1]);
        }
        return res;
    }
}
