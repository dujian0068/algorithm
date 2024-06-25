package com.bmilk.algorithm.greedy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LC2732_GoodSubsetofBinaryMatrix {
    public List<Integer> goodSubsetofBinaryMatrix(int[][] grid) {
        List<Integer> result = new ArrayList<>();
        if(grid.length == 1){
            for (int i =0; i<grid[0].length; i++){
                if(grid[0][i] != 0){
                    return result;
                }
            }
            result.add(0);
            return result;
        }

        for (int i = 0; i<grid.length; i++){
            for (int j = i+1; j<grid.length; j++){
                if(check(grid[i], grid[j])){
                    result.add(i);
                    result.add(j);
                    return result;
                }
            }
        }
        return result;
    }

    private boolean check(int[] nums1, int[] nums2){
        for (int i = 0; i<nums1.length; i++){
            if((nums1[i] & nums2[i]) != 0 ){
                return false;
            }
        }
        return true;
    }
}
