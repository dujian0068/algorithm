package com.bmilk.algorithm.dfs;

import java.util.Arrays;

public class LC698_CanPartitionKSubsets {
    public static void main(String[] args) {
        LC698_CanPartitionKSubsets o = new LC698_CanPartitionKSubsets();
        boolean b = o.canPartitionKSubsets(new int[]{4, 5, 9, 3, 10, 2, 10, 7, 10, 8, 5, 9, 4, 6, 4, 9}, 5);
        System.out.println(b);
    }

    int per;
    boolean[] dp;
    int count = 0;
    public boolean canPartitionKSubsets(int[] nums, int k) {
        int sum = Arrays.stream(nums).sum();
        if(sum%k != 0) return false;
        per = sum/k;
        Arrays.sort(nums);
        int len = nums.length;
        if(nums[len-1] > per) return false;
        dp = new boolean[len];
        Arrays.fill(dp, false);
        while (count < k){
            if(dfs(len-1, 0, nums)){
                count++;
            }else {
                return false;
            }
        }
        return true;
    }



    private boolean dfs(int l, int sum, int[] nums){
        if(sum == per) return true;
        for (int i = l; i>=0; i--){
            if(dp[i] || sum + nums[i] > per) continue;
            dp[i] = true;
            if(dfs(i-1, sum + nums[i], nums)) return true;
            dp[i] = false;
        }
        return false;
    }

}
