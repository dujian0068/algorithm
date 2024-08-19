package com.bmilk.algorithm.dp;

public class LC3152_isArraySpecial {
    public boolean[] isArraySpecial(int[] nums, int[][] queries) {
       int len = nums.length;
       int[] dp = new int[len];
       dp[0] = 1;
       for (int i = 1; i< len; i++){
           if(((nums[i]^nums[i-1]) & 1)==1 ){
               dp[i] = dp[i-1] +1;
           }else {
               dp[i] = 1;
           }
       }
       boolean[] res = new boolean[queries.length];
       for (int i = 0; i< queries.length; i++){
           int x = queries[i][0];
           int y = queries[i][1];
           res[i] = y - x + 1 <= dp[y];
       }
       return res;
    }
}
