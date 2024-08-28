package com.bmilk.algorithm.dp;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class LC3144_MinimumSubstringsInPartition {
    public int minimumSubstringsInPartition(String s) {

        int n = s.length();
        int[] dp = new int[n+1];
        Arrays.fill(dp, n);
        dp[0] = 0;
        for (int i = 1; i<= n ; i++){
            Map<Character, Integer> countC = new HashMap<>();
            int maxCount = 0;
            for (int j = i; j>=1; j--){
                countC.put(s.charAt(j-1), countC.getOrDefault(s.charAt(j-1), 0)+1);
                maxCount = Math.max(maxCount, countC.get(s.charAt(j-1)));
                if(maxCount * countC.size() == (i - j +1) && dp[j-1] != n){
                    dp[i] = Math.min(dp[i], dp[j-1]+1);
                }
            }
        }
        return dp[n];

    }
}
