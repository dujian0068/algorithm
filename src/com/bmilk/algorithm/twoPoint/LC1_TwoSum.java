package com.bmilk.algorithm.twoPoint;

import java.util.Arrays;

public class LC1_TwoSum {
    public static void main(String[] args) {
        int[] nums = {2,7,11,15};
        LC1_TwoSum o = new LC1_TwoSum();
        int[] ints = o.twoSum(nums, 9);
        System.out.println(ints[0] + "  "+ ints[1]);
    }

    public int[] twoSum(int[] nums, int target) {

        for (int i =0 ; i< nums.length; i++){
            for (int j = i+1; j<nums.length;j++){
                if(nums[i] + nums[j] == target){
                    return new int[]{i,j};
                }
            }
        }
        return null;
    }

//    public int[] twoSum(int[] nums, int target) {
//        Arrays.sort(nums);
//
//        for (int i=0, j= nums.length-1; i < j ; ){
//            if(nums[i] + nums[j] == target){
//                return new int[]{i, j};
//            }else if(nums[i] + nums[j] > target){
//                j--;
//            }else {
//                i++;
//            }
//        }
//        return null;
//    }
}
