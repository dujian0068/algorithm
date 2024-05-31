package com.bmilk.algorithm;

public class LC268_MissingNumber {

    public int missingNumber(int[] nums) {
        int result = 0;

        for (int i = 0; i<nums.length; i++){
            result = i+ 1 - nums[i] + result;
        }
        return result;
    }

    public int missingNumber1(int[] nums) {
        int result = 0;
        for (int i=0; i<nums.length; i++){
            result = result^(i+1);
            result = result^nums[i];
        }
        return result;
    }
}
