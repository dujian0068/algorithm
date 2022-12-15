package com.bmilk.algorithm;

public class Test2 {

    public static void main(String[] args) {
       String s1 = "hdsgfgdha";

        String substring = s1.substring(0, 1);
        System.out.println(substring);
    }

    public int maxValue(int[] nums){
        if(null == nums || nums.length==0){
            return 0;
        }

        int max = nums[0];
        int pre = 0;
        for(int i =0; i<nums.length; i++){
            int f = Math.max(pre + nums[i], nums[i]);
            max = Math.max(f, max);
            pre = f;
        }
        return max;
    }

}
