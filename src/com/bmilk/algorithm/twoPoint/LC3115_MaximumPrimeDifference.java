package com.bmilk.algorithm.twoPoint;

import java.util.Arrays;

public class LC3115_MaximumPrimeDifference {
    public static void main(String[] args) {
        LC3115_MaximumPrimeDifference o = new LC3115_MaximumPrimeDifference();
        int i = o.maximumPrimeDifference(new int[]{4,8,2,8});
        System.out.println(i);
    }
    public int maximumPrimeDifference(int[] nums) {
        boolean[] b = new boolean[101];
        Arrays.fill(b, true);
        b[0] = false;
        b[1] = false;
        for (int i = 2; i< 101; i++){
            int j = i;
            while ( i*j < 101 ){
                b[i*j++] = false;
            }
        }
        int left = -1;
        for (int i = 0; i< nums.length; i++){
            if(b[nums[i]]){
                left = i;
                break;
            }
        }

        int right = Integer.MAX_VALUE;
        for (int i = nums.length-1; i>=0; i--){
            if(b[nums[i]]){
                right = i;
                break;
            }
        }
        return right-left;

    }
}
