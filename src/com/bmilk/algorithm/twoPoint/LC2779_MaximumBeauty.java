package com.bmilk.algorithm.twoPoint;

import java.util.Arrays;

public class LC2779_MaximumBeauty {
    public static void main(String[] args) {
        LC2779_MaximumBeauty o = new LC2779_MaximumBeauty();
        int i = o.maximumBeauty(new int[]{49,26}, 12);
        System.out.println(i);
    }
    public int maximumBeauty(int[] nums, int k) {
        Arrays.sort(nums);
        int len = nums.length;
        int res = 0;
        int left = 0;
        int right = 0;
        while (left <= right && right < len){
            while (right < len && nums[right]-nums[left] <= 2*k){
                right++;
            }
            res = Math.max(right-left, res);
            left++;
        }
        return res;
    }
}
