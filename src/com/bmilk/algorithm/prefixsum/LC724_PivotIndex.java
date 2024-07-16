package com.bmilk.algorithm.prefixsum;

public class LC724_PivotIndex {
    public int pivotIndex(int[] nums) {
        int total = 0;
        int len = nums.length;
        for (int i = 0; i< len; i++){
            total += nums[i];
        }
        int sum = 0;
        for (int i = 0; i < len; i++){
            if(2 * sum + nums[i] == total) return i;
            sum += nums[i];
        }
        return -1;

    }
}
