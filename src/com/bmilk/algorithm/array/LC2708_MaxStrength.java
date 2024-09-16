package com.bmilk.algorithm.array;

import java.util.Arrays;

public class LC2708_MaxStrength {

    public static void main(String[] args) {
        LC2708_MaxStrength o = new LC2708_MaxStrength();
        long l = o.maxStrength(new int[]{6, -3, -4, 8, 4, 7, 6, 4, 7, 7, -3, -6, 9});
        System.out.println(l);
    }
    public long maxStrength(int[] nums) {
        long res = 1;
        int maxMid = Integer.MIN_VALUE;
        int count_ = 0;
        int count0 = 0;
        for (int num : nums) {
            if (num != 0) {
                res *= num;
                if (num < 0) {
                    maxMid = Math.max(maxMid, num);
                    count_ += 1;
                }
            } else {
                count0 += 1;
            }
        }
        if(count0 == nums.length) return 0;
        if(nums.length == 1 && count_ == nums.length) return res;
        if(count_ == nums.length) return res > 0? res : res/maxMid;
        if(count0 > 0 && count_ == 1 && (count_ + count0) == nums.length) return 0;
        return res > 0? res : res/maxMid;
    }
}
