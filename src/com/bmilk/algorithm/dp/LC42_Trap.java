package com.bmilk.algorithm.dp;

import java.util.ArrayList;

public class LC42_Trap {


    public static void main(String[] args) {
        LC42_Trap o = new LC42_Trap();
        int[] height = {0,1,0,2,1,0,1,3,2,1,2,1};
        int trap = o.trap(height);
        System.out.println(trap);


    }

    public int trap(int[] height) {

        if(null == height || height.length == 1){
            return 0;
        }

        int[][] dp = new int[height.length][2];

        int len = height.length;
        dp[0][0] = 0;
        dp[len-1][1] =0;
        for (int i = 1 ;i<len; i++){
            dp[i][0] = Math.max(dp[i-1][0], height[i-1]);
        }
        for (int i= len-2 ;i>=0; i--){
            dp[i][1] = Math.max(dp[i+1][1], height[i+1]);
        }
        int result = 0;
        for (int i=0; i<len;i++){
            if((Math.min(dp[i][0], dp[i][1]) - height[i]) > 0){
                result += (Math.min(dp[i][0], dp[i][1]) - height[i]);
            }
        }
        return result;
    }

}
