package com.bmilk.algorithm.array;

import java.util.Arrays;

public class LC2974_NumberGame {
    public int[] numberGame(int[] nums) {
        Arrays.sort(nums);
        int tmp;
        for (int i=1 ; i< nums.length; i +=2){
            tmp = nums[i];
            nums[i] = nums[i-1];
            nums[i-1] = tmp;
        }
        return nums;

    }
}
