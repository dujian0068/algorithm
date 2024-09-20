package com.bmilk.algorithm.twoPoint;

import java.util.Arrays;

public class LC2576_MaxNumOfMarkedIndices {
    public static void main(String[] args) {
        LC2576_MaxNumOfMarkedIndices o = new LC2576_MaxNumOfMarkedIndices();
        int i = o.maxNumOfMarkedIndices(new int[]{3, 5, 2, 4});
        System.out.println(i);
    }

    public int maxNumOfMarkedIndices(int[] nums) {
        Arrays.sort(nums);
        int len = nums.length;
        int left = 0;
        int right  =  len/2;
        int res = 0;
        while (left < len/2 && right< len){
            while (right < len && nums[right] < nums[left]*2){
                right++;
            }
            if(right < len && nums[right] >= nums[left]*2){
                res+=2;
            }
            left++;
            right++;
        }
        return res;

    }
}
