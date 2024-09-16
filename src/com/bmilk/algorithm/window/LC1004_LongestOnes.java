package com.bmilk.algorithm.window;

public class LC1004_LongestOnes {
    public int longestOnes(int[] nums, int k) {
        int left = 0;
        int len = nums.length;
        int res = 0;
        while (nums[left] == 0){
            left++;
        }
        int right = left;
        while (right< len){
            while (right < nums.length && (k>0 || nums[right] == 1)){
                if(nums[right] == 0){
                    k--;
                }
                right++;
            }
            res = Math.max(right-left, res);
            if(right == len) return res;

            while (k <=0 && left < right){
                if(nums[left] == 0){
                    k++;
                }
                left++;
            }
        }
        return res;

    }
}
