package com.bmilk.algorithm.array;

public class LC3151_IsArraySpecial {
    public boolean isArraySpecial(int[] nums) {
        if(nums.length == 1) return true;
        for (int i = 1; i < nums.length; i++){
            if( 1 != ((nums[i] ^ nums[i-1]) ^ 1)){
                return false;
            }
        }
        return true;
    }
}
