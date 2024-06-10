package com.bmilk.algorithm.array;

public class LC3038_MaxOperations {
    public int maxOperations(int[] nums) {

        if(nums.length < 2){
            return 0;
        }
        int result = 1;

        for (int i = 2; (i+1)<nums.length; i= i+2){
            if(nums[i] + nums[i+1] ==  nums[i-1] + nums[i-2]){
                result +=1;
            }else{
                return result;
            }
        }
        return result;
    }
}
