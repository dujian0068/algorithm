package com.bmilk.algorithm.twoPoint;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LC15_ThreeSum {

    public static void main(String[] args) {
        int[] nums = new int[]{-2,0,0,2,2};
        LC15_ThreeSum o = new LC15_ThreeSum();
        List<List<Integer>> lists = o.threeSum(nums);
        System.out.println(lists);
    }

    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);

        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i<=nums.length - 3; i++){
            if(i>0 && nums[i] == nums[i-1]) continue;
            for (int x= i+1 , y = nums.length-1; x<y;){
                if(nums[i] + nums[x] + nums[y] == 0){
                    List<Integer> tmp = new ArrayList<Integer>();
                    tmp.add(nums[i]);
                    tmp.add(nums[x]);
                    tmp.add(nums[y]);
                    result.add(tmp);
                    x++;
                    while (x < y && nums[x-1] == nums[x]){
                        x++;
                    }
                    y--;
                }else if(nums[i] + nums[x] + nums[y] > 0){
                    y--;
                }else {
                    x++;
                }
            }
        }
        return result;
    }
}
