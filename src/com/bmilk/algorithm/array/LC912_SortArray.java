package com.bmilk.algorithm.array;


import java.util.Random;

public class LC912_SortArray {

    public static void main(String[] args) {
        int[] nums = {5, 1, 1, 2, 0, 0};
        LC912_SortArray o = new LC912_SortArray();
        o.sortArray(nums);
        for (int num : nums) {
            System.out.print(num + "  ");
        }
    }

    public int[] sortArray(int[] nums) {
        quickSort(nums, 0, nums.length - 1);
        return nums;
    }

    private void quickSort(int[] nums, int left, int right) {
        if (left >= right) {
            return;
        }
        int p = randomizedPartition(left, right);
        swap(nums,left, p);
        int i = left;
        int j = right;
        int tmp = nums[left];
        while (i < j) {
            while (i<j && nums[j] >= tmp) j--;
            while (i<j && nums[i] < tmp) i++;
            swap(nums, i,j);
        }
        if(nums[i] < tmp) swap(nums, left, i);
        quickSort(nums, left, i);
        quickSort(nums, i + 1, right);
    }

    private void swap(int[] nums, int left, int right) {
        int tmp = nums[left];
        nums[left] = nums[right];
        nums[right] = tmp;
    }

    public int randomizedPartition(int left, int right) {
        return new Random().nextInt(right - left + 1) + left;

    }

}
