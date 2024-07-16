package com.bmilk.algorithm.array;

import java.util.HashSet;
import java.util.Set;

public class LC2956_FindIntersectionValues {
    public int[] findIntersectionValues(int[] nums1, int[] nums2) {
        Set<Integer> set1 = new HashSet<>();
        Set<Integer> set2 = new HashSet<>();
        for (int n : nums1){
            set1.add(n);
        }
        int res2 = 0;
        for (int n : nums2){
            if(set1.contains(n)){
                res2++;
            }
            set2.add(n);
        }
        int res1 = 0;
        for (int n : nums1){
            if(set2.contains(n)){
                res1++;
            }
        }
        return new int[]{res1, res2};

    }
}
