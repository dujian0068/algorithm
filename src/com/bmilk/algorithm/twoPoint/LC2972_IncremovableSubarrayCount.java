package com.bmilk.algorithm.twoPoint;

import com.sun.jmx.snmp.SnmpUnknownSubSystemException;

public class LC2972_IncremovableSubarrayCount {
    public static void main(String[] args) {
        LC2972_IncremovableSubarrayCount o = new LC2972_IncremovableSubarrayCount();
        long l = o.incremovableSubarrayCount(new int[]{6, 5, 4, 3, 7, 8, 9});
        System.out.println(l);
    }
    public long incremovableSubarrayCount(int[] nums) {
        long result = 0;
        int left = 0;
        int len = nums.length;
        while (left + 1 < len && nums[left] < nums[left+1]){
            left++;
        }
        if(left == len -1){
            return (long) len * (len+1) /2;
        }
        int right = len-1;
        result += left + 2;
        while (right >= left){
            while (left>=0  && nums[left] >= nums[right]){
                left--;
            }
            result += left + 2;
            right --;
            if(nums[right] >= nums[right+1]){
                break;
            }
        }
        return result;
    }

}
