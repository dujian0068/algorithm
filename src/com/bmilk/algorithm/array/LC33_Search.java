package com.bmilk.algorithm.array;

public class LC33_Search {

    public static void main(String[] args) {
        int[] nums = {3,1};
        LC33_Search o = new LC33_Search();
        int search = o.search(nums, 1);
        System.out.println(search);
    }


    public int search(int[] nums, int target) {
        if( null == nums || nums.length == 0){
            return -1;
        }
        if(nums.length == 1){
            return nums[0] == target ? 0 : -1;
        }

        int left = 0, right = nums.length-1;

        while (left <= right){

            int mid = (left+right)/2;
            if( target == nums[mid]) {
                return mid;
            }

            if (nums[left] <= nums[mid]) {
                if (nums[left] <= target && nums[mid] > target) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            } else {
                if(nums[mid] < target && target <= nums[right]){
                    left = mid +1;
                }else {
                    right = mid -1;
                }
            }
        }
        return  -1;

    }
}
