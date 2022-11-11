package com.bmilk.algorithm.list;

import java.util.ArrayList;
import java.util.List;

public class LC46_Permute {
    public static void main(String[] args) {
        LC46_Permute service = new LC46_Permute();
        int[] nums = {1,2,3};
        List<List<Integer>> permute = service.permute(nums);
        System.out.println(permute);
    }

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();

        List<Integer> tmp = new ArrayList<>();

        permute(nums, tmp, res);
        return res;
    }



    public void permute(int[] nums,List<Integer> tmp, List<List<Integer>> res) {
        if(tmp.size() == nums.length){
            res.add(new ArrayList<>(tmp));
        }

        for (int num : nums){
            if(tmp.contains(num)){
                continue;
            }
            tmp.add(num);
            permute(nums, tmp, res);
            tmp.remove(tmp.size()-1);
        }
    }


}
