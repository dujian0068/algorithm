package com.bmilk.algorithm.array;

public class LC3011_CanSortArray {

    public static void main(String[] args) {
        LC3011_CanSortArray o = new LC3011_CanSortArray();
        boolean b = o.canSortArray(new int[]{20,16});
        System.out.println(b);
    }
    public boolean canSortArray(int[] nums) {
        int len = nums.length;
        int beforeMax = Integer.MIN_VALUE;
        int i = 0;
        while ( i< len){
            int count = count(nums[i]);
            int max = nums[i];
            int min = nums[i];
            i++;
            while (i< len && count(nums[i]) == count){
                max = Math.max(max, nums[i]);
                min = Math.min(min, nums[i]);
                i++;
            }
            if(min < beforeMax){
                return false;
            }
            beforeMax = max;
        }
        return true;
    }

    private int count(int num){
        int count = 0;
        while (num > 0 ){
            if((num & 1) == 1){
                count++;
            }
            num = num >> 1;
        }
        return count;
    }
}
