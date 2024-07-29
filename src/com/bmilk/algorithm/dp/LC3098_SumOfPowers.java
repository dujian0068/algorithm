package com.bmilk.algorithm.dp;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class LC3098_SumOfPowers {
    static final int MOD = 1000000007, INF = 0x3f3f3f3f;
    public int sumOfPowers(int[] nums, int k) {
        int n = nums.length;
        int res = 0;
        Map<Integer, Integer>[][] dp = new HashMap[n][k+1];
        for(int i = 0; i< n;i++){
            for (int j = 0; j< k+1; j++){
                dp[i][j] = new HashMap<Integer, Integer>();
            }
        }
        Arrays.sort(nums);
        for (int i = 0; i< n ;i++){
            dp[i][1].put(INF, 1);
            for (int j = 0; j< i; i++){
                int diff = Math.abs(nums[i] - nums[j]);
                for (int p = 2; p<=k; p++){
                    for (Map.Entry<Integer, Integer> entry : dp[j][p-1].entrySet()){
                        int  v = entry.getKey();
                        int count = entry.getValue();
                        int currentKey = Math.min(diff, v);
                        dp[i][p].put(currentKey, (dp[i][p].getOrDefault(currentKey, 0) + count) % MOD);
                    }
                }
            }
            for (Map.Entry<Integer, Integer> entry : dp[i][k].entrySet()){
                int v = entry.getKey();
                int count = entry.getValue();
                res = (int)((res +1L *v*count %MOD) %MOD);
            }

        }
        return res;
    }
}
