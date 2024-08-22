package com.bmilk.algorithm.dfs;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

public class LC3154_WaysToReachStair {
    public int waysToReachStair(int k) {
        return dfs(1, 0, 0, k, new HashMap<>());
    }

    private int dfs(int i, int j, int before, int k, Map<Long, Integer> memo){
        if(i > k+1 ){
            return 0;
        }
        long mask = (long)i << 32 | (long)j << 1 | before;
        if(memo.containsKey(mask)){
            return memo.get(mask);
        }
        int res = i == k? 1:0;
        res += dfs(i + (1<<j), j+1, 0, k, memo);
        if(before == 0 && i>0){
            res += dfs(i-1, j, 1, k, memo);
        }
        memo.put(mask, res);
        return res;

    }
}
