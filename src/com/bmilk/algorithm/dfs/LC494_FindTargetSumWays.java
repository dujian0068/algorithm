package com.bmilk.algorithm.dfs;



//todo
public class LC494_FindTargetSumWays {

    private int result = 0;
    public int findTargetSumWays(int[] nums, int target) {
        dfs(nums, 0, 0, target);
        return result;
    }

    private void dfs(int[] nums, int index, int sum, int target){
        if(index >= nums.length){
            if(sum == target){
                result++;
            }
            return;
        }
        dfs(nums, index+1, sum+(nums[index] * -1), target);
        dfs(nums, index+1, sum + nums[index], target);
    }

}
