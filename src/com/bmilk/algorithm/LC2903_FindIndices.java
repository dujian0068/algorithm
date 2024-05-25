package com.bmilk.algorithm;

import java.util.Arrays;

public class LC2903_FindIndices {
    public static void main(String[] args) {
        LC2903_FindIndices o = new LC2903_FindIndices();
        int[] indices = o.findIndices(new int[]{5, 1, 4, 1}, 2, 4);
        System.out.println(Arrays.toString(indices));
    }

    public int[] findIndices(int[] nums, int indexDifference, int valueDifference) {
        int[] result = new int[]{-1,-1};

        for (int i =0; i<nums.length;i++){
            for (int j = i+indexDifference; j<nums.length;j++){
                if(Math.abs(nums[j]-nums[i]) >=valueDifference){
                    result[0] = i;
                    result[1] = j;
                    break;
                }
            }
        }
        return result;
    }
}
