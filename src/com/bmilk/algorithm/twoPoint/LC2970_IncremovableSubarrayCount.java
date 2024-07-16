package com.bmilk.algorithm.twoPoint;

public class LC2970_IncremovableSubarrayCount {


    public int incremovableSubarrayCount(int[] nums) {
        int len = nums.length;
        int res = 0;
        int left = 1;
        while (left < len && nums[left-1] < nums[left]){
            left++;
        }

        res += left + (left < len ? 1:0);
        for (int right = len-2; right >= 0; right--){
            while (left > 0 && nums[left -1] >= nums[right+1]){
                left--;
            }
            res += left + (left < right ? 1 : 0);
            if(nums[right] >= nums[right+1]){
                break;
            }
        }
        return res;
    }
}
