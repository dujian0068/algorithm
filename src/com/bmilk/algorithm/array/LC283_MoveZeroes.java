package com.bmilk.algorithm.array;

import java.util.Arrays;

public class LC283_MoveZeroes {
    public static void main(String[] args) {
        LC283_MoveZeroes o = new LC283_MoveZeroes();
        int[] nums =  {0,1,0,3,12};
        o.moveZeroes(nums);
        System.out.println(Arrays.toString(nums ));
    }
    public void moveZeroes(int[] nums) {
        int left = 0;
        int right = 0;
        while (right  < nums.length && left < nums.length){
            while (left < nums.length && nums[left] != 0){
                left++;
            }
            while (right< nums.length && (nums[right] == 0 || right< left)){
                right++;
            }
            if(right<nums.length && left<nums.length){
                nums[left] = nums[right];
                nums[right] = 0;
                left ++;
            }

        }
    }
}
