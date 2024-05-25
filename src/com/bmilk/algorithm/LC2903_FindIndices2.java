package com.bmilk.algorithm;

public class LC2903_FindIndices2 {

    public int[] findIndices(int[] nums, int indexDifference, int valueDifference) {
       int pMax = 0;
       int pMin = 0;

       int i =0;
       int j = i+indexDifference;
       int[] result = {-1, -1};
       while (j<nums.length){
           if(nums[pMax] < nums[i]){
               pMax = i;
           }
           if(nums[pMin] > nums[i]){
               pMin = i;
           }
           if(Math.abs(nums[pMax] - nums[j])>=valueDifference){
               result = new int[]{pMax, j};
               break;
           }
           if(Math.abs(nums[pMin] - nums[j])>=valueDifference){
               result = new int[]{pMin, j};
               break;
           }
           i++;
           j++;
       }
       return result;
    }
}
