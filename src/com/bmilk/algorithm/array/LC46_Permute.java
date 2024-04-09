package com.bmilk.algorithm.array;

import java.util.ArrayList;
import java.util.List;

public class LC46_Permute {

    private List<List<Integer>> result = new ArrayList<>();

    public static void main(String[] args) {
        LC46_Permute o = new LC46_Permute();
        int[] nums = {1,2,3,4};
        List<List<Integer>> permute = o.permute(nums);
        System.out.println(permute);
    }

    public List<List<Integer>> permute(int[] nums) {
        int size = nums.length;
        List<Integer> tmp = new ArrayList<>();
        int[] p = new int[size];

        for (int i =0; i<size; i++){
            p[i] = 1;
            tmp.add(nums[i]);
            permute(nums, p, size, tmp);
            tmp.remove(tmp.size()-1);
            p[i] = 0;
        }
        return result;
    }

    public void permute(int[] nums, int[] p, int size, List<Integer> tmp) {
        if(tmp.size() == size){
            result.add(new ArrayList<>(tmp));
        }
        for (int i =0; i<size; i++){
            if(p[i] == 1) continue;
            p[i] = 1;
            tmp.add(nums[i]);
            permute(nums, p, size, tmp);
            tmp.remove(tmp.size()-1);
            p[i] = 0;
        }

    }

}
