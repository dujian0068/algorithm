package com.bmilk.algorithm.dfs;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
//todo
public class LC2741_SpecialPerm {
    public static void main(String[] args) {
        LC2741_SpecialPerm o = new LC2741_SpecialPerm();
        int i = o.specialPerm(new int[]{1,2,4,8,16,32,64,128,256,512,1024,2048,4096,8192});
        System.out.println(i);
    }

    private int result = 0;
    private int mod = 1000000007;

    HashMap<Integer, Set<Integer>> link = new HashMap<>();
    public int specialPerm(int[] nums) {

        for (int num : nums){
            link.put(num, new HashSet<>());
        }
        for (int i = 0; i< nums.length; i++){
            for (int j = i+1; j<nums.length; j++){
                if(nums[i]%nums[j]==0|| nums[j]%nums[i]==0){
                    link.get(nums[i]).add(nums[j]);
                    link.get(nums[j]).add(nums[i]);
                }
            }
        }
        Set<Integer> tmp = new HashSet<>();
        for (int num : nums){
            tmp.add(num);
            dfs(num, tmp, nums.length);
        }
        return result;
    }


    private void dfs(int before, Set<Integer> set, int all){
        if(set.size() == all){
            result = (result +1)%mod;
            return;
        }
        
        for (int num : link.get(before)){
            if(set.contains(num)) continue;
            set.add(num);
            dfs(num, set, all);
            set.remove(num);
        }
    }
}
