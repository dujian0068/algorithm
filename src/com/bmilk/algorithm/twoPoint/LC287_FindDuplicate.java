package com.bmilk.algorithm.twoPoint;

public class LC287_FindDuplicate {
    public static void main(String[] args) {
        LC287_FindDuplicate o = new LC287_FindDuplicate();

        int duplicate = o.findDuplicate(new int[]{3,1,3,4,2});
        System.out.println(duplicate);
    }

    public int findDuplicate(int[] nums) {
        int slow = 0 ;
        int quick = 0;
        do {
            slow = nums[slow];
            quick = nums[nums[quick]];
        }while (slow != quick);
        slow = 0;
        while (slow != quick){
            slow = nums[slow];
            quick = nums[quick];
        }
        return slow;

    }
}
