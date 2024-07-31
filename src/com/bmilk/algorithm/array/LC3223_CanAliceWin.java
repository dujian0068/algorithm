package com.bmilk.algorithm.array;

public class LC3223_CanAliceWin {

    public boolean canAliceWin(int[] nums) {
        int count = 0;
        for (int num : nums){
            if( num > 0 && num <10){
                count += num;
            }else {
                count -= num;
            }
        }
        return count != 0;
    }
}
