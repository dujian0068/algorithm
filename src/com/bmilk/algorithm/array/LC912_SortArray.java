package com.bmilk.algorithm.array;

import javafx.embed.swt.SWTFXUtils;

public class LC912_SortArray {

    public static void main(String[] args) {
        int[] nums = {31,19,7,22,30, 88,6,9,4};
        LC912_SortArray o = new LC912_SortArray();
        o.sortArray(nums);
        for (int num : nums) {
            System.out.print(num + "  ");
        }
    }

    public int[] sortArray(int[] nums) {
        quickSort(nums, 0, nums.length-1);
        return nums;
    }

    private void quickSort(int[] nums, int left, int right){
        if(left >= right){
            return;
        }
        int p = left;
        left ++;
        while (left < right){
            while (left<right && nums[right]>=nums[p]) {
                right--;
            }
            while (left< right && nums[left]< nums[p]){
                left++;
            }
            swap(nums, left, right);
        }
        if(nums[p] > nums[left]){
            swap(nums, p , left);
        }
        quickSort(nums, p, left-1);
        quickSort(nums, right+1, nums.length-1);
    }

    private void swap(int[] nums, int left, int right){
        int tmp = nums[left];
        nums[left] = nums[right];
        nums[right] = tmp;
    }
}
