package com.bmilk.algorithm.array;

public class LC41_FirstMissingPositive {
    public static void main(String[] args) {
        int[] nums = {2, 1};
        LC41_FirstMissingPositive o = new LC41_FirstMissingPositive();
        int i = o.firstMissingPositive(nums);
        System.out.println(i);
    }

    public int firstMissingPositive(int[] nums) {

        for (int i = 0 ;i<nums.length ; i++){
            int num = nums[i];
            while (num > 0 && num <= nums.length && nums[num-1] != num){
                int tmp = nums[num-1];
                nums[num-1] = num;
                num = tmp;
            }
        }
        int i = 1;
        while ( i <=nums.length && nums[i-1] == i ){
            i++;
        }
        return i;
    }
}
