package com.bmilk.algorithm.array;

public class LC3040_MaxOperations {
    public static void main(String[] args) {
        LC3040_MaxOperations o = new LC3040_MaxOperations();
        int i = o.maxOperations(new int[]{2,2,1,2,1});
        System.out.println(i);
    }

    public int maxOperations(int[] nums) {
        if(nums.length < 2){
            return 0;
        }

        int right = nums.length-1;
        int left =0;
        int[][] tmpArr = new int[3][2];
        tmpArr[0][0] = nums[left] + nums[left + 1];
        tmpArr[1][0] = nums[right] + nums[right-1];
        tmpArr[2][0] = nums[left] + nums[right];

        int[][] dp = new int[nums.length][nums.length];

        int result = 0;
        for(int[] tmp : tmpArr){
            for (int i = 0; i<nums.length; i++){
                for (int j = 0; j<nums.length; j++){
                    dp[i][j] = -1;
                }
            }
            result = Math.max(dfs(0, nums.length-1, nums, tmp[0], dp), result);
        }

        return result;
    }

    private int dfs(int left, int right, int[] nums, int score, int[][] dp){
        if(right - left < 1){
            return 0;
        }
        if(dp[left][right] != -1){
            return dp[left][right];
        }
        int result = 0;
        if(nums[left] + nums[left + 1] == score){
            result = Math.max(dfs(left +2, right, nums, score, dp) + 1, result);
        }
        if(nums[left] + nums[right] == score){
            result = Math.max(dfs(left+1, right-1, nums, score, dp) + 1, result);
        }
        if(nums[right] + nums[right-1] == score){
            result = Math.max(dfs(left, right-2, nums, score, dp) + 1, result);
        }
        dp[left][right] = result;
        return result;
    }
}
