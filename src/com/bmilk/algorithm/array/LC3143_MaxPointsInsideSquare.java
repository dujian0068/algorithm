package com.bmilk.algorithm.array;

import java.util.Arrays;
import java.util.Map;

public class LC3143_MaxPointsInsideSquare {
    public int maxPointsInsideSquare(int[][] points, String s) {
        int[] min1 = new int[26];
        Arrays.fill(min1, Integer.MAX_VALUE);
        int min2 = Integer.MAX_VALUE;
        int n = s.length();
        for (int i = 0; i< n ; i++){
            int x = points[i][0];
            int y = points[i][1];
            int l = s.charAt(i) - 'a';
            int d = Math.max(Math.abs(x), Math.abs(y));
            if(d < min1[l]){
                min2 = Math.min(min2, min1[l]);
                min1[l] = d;
            }else if(d < min2){
                min2 = d;
            }

        }
        int res = 0;
        for (int d : min1){
            if(d < min2){
                res++;
            }
        }
        return res;
    }
}
