package com.bmilk.algorithm.dp;

import java.util.ArrayList;
import java.util.List;

public class LC78_Subsets {

    public static void main(String[] args) {
        LC78_Subsets o = new LC78_Subsets();
        List<List<Integer>> subsets = o.subsets(new int[]{1, 2, 3});
        System.out.println(subsets);
    }


    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        result.add(new ArrayList<>());

        for (int i =0; i<nums.length;i++){
            int count = result.size();
            for (int j = 0; j<count;j++){
                List<Integer> newList = new ArrayList<>(result.get(j));
                newList.add(nums[i]);
                result.add(newList);
            }
        }
        return result;
    }
}
