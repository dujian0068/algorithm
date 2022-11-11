package com.bmilk.algorithm.list;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LC47_PermuteUnique {
    public static void main(String[] args) {
        int[] nums = new int[]{1,1,2};
        LC47_PermuteUnique service = new LC47_PermuteUnique();
        List<List<Integer>> lists = service.permuteUnique(nums);
        System.out.println(lists);
    }

    public List<List<Integer>> permuteUnique(int[] nums) {
        boolean[] mark = new boolean[nums.length];
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> tmp = new ArrayList<>();
        Arrays.sort(nums);

        permuteUnique(nums, res, tmp, mark);
        return res;

    }

    public void permuteUnique(int[] nums, List<List<Integer>> res, List<Integer> tmp, boolean[] mark) {
        if(tmp.size() == nums.length ) {
            res.add(new ArrayList<>(tmp));
            return;
        }

        for (int i=0; i< nums.length;i++){
            if(mark[i] || i > 0 && nums[i] == nums[i-1] && !mark[i-1]){
                continue;
            }
            mark[i] = true;
            tmp.add(nums[i]);
            permuteUnique(nums, res, tmp, mark);
            tmp.remove(tmp.size()-1);
            mark[i] = false;
        }

    }
}
