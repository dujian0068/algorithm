package com.bmilk.algorithm.window;

import java.util.*;

public class LC2831_LongestEqualSubarray {

    public static void main(String[] args) {
        LC2831_LongestEqualSubarray o = new LC2831_LongestEqualSubarray();
        List<Integer> nums = Arrays.asList(1,1,2,2,1,1);
        int i = o.longestEqualSubarray(nums, 1);
        System.out.println(i);
    }

    public int longestEqualSubarray(List<Integer> nums, int k) {

        Map<Integer, List<Integer>> numMap = new HashMap<>();
        for (int i = 0; i<nums.size(); i++){
            List<Integer> integers = numMap.get(nums.get(i));
            if(null == integers){
                integers = new ArrayList<>();
                numMap.put(nums.get(i), integers);
            }
            integers.add(i);
        }

        int res = 0;
        for (Integer i : numMap.keySet()){
            List<Integer> integers = numMap.get(i);
            int quick = 0;
            int slow = 0;
            while (slow <= quick && quick < integers.size()){
                if(integers.get(quick) - integers.get(slow) +1 - (quick-slow+1) <= k){
                    res = Math.max(res, quick-slow+1);
                    quick++;
                }else {
                    slow++;
                }
            }
        }
        return res;
    }
}
