package com.bmilk.algorithm.array;

public class LC215_FindKthLargest {

    public static void main(String[] args) {
        int[] nums = {3,2,3,1,2,4,5,5,6};
        LC215_FindKthLargest o = new LC215_FindKthLargest();
        int kthLargest = o.findKthLargest(nums, 4);
        System.out.println(kthLargest);
    }


    public int findKthLargest(int[] nums, int k) {
        if(null == nums || nums.length<k){
            return 0;
        }

        int left = 0;
        int right = nums.length-1;
        while (true){
            int i = left, j = right;
            int tmp = nums[i];
            while (i < j){
                while (i<j && nums[j] <= tmp) j--;
                if(i < j){
                    nums[i] = nums[j];
                }
                while (i< j && nums[i] > tmp) i++;
                if(i< j){
                    nums[j] = nums[i];
                }
            }
            nums[i] = tmp;
            if(i == k-1){
                return tmp;
            }else if( k-1 > i){
                left = i+1;
            }else {
                right = i-1;
            }
        }

    }

}
