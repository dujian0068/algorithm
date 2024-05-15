package com.bmilk.algorithm.array;

import java.util.Arrays;

public class LC31_NextPermutation {

    public static void main(String[] args) {
        LC31_NextPermutation o = new LC31_NextPermutation();
        int[] test = new int[]{1,1,5};
        o.nextPermutation(test);
        System.out.println(Arrays.toString(test));
    }

    public void nextPermutation(int[] nums) {

        if (null == nums || nums.length == 1) {
            return;
        }
        int left = nums.length - 2;
        int right = nums.length - 1;

        for (; left > 0; left--) {
            if (nums[left] < nums[left + 1]) {
                break;
            }
        }
        if(left == 0 && nums[left] >= nums[left+1]){
            Arrays.sort(nums);
            return;
        }
        for (;right>left;right--){
            if (nums[right]>nums[left]){
                break;
            }
        }
        int num = nums[right];
        nums[right] = nums[left];
        nums[left] = num;

        Arrays.sort(nums, left+1, nums.length);
    }
}
