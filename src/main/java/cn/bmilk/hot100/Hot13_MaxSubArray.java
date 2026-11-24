package cn.bmilk.hot100;

import cn.bmilk.Main;

public class Hot13_MaxSubArray {
    public int maxSubArray(int[] nums) {

        int res = nums[0];

        int tmp =nums[0];
        for (int i =1; i<nums.length; i++){
            if(tmp + nums[i] <= nums[i]){
                tmp = nums[i];
            }else {
                tmp += nums[i];
            }
            res = Math.max(res, tmp);
        }
        return res;
    }
}
