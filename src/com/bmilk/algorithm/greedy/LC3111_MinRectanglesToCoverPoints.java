package com.bmilk.algorithm.greedy;

import java.util.Arrays;
import java.util.Comparator;

public class LC3111_MinRectanglesToCoverPoints {
    public int minRectanglesToCoverPoints(int[][] points, int w) {
        Arrays.sort(points, Comparator.comparingInt(o -> o[0]));
        int res = 1;
        int start = points[0][0];
        for (int[] point : points){
            if(point[0] - start > w){
                res++;
                start = point[0];
            }
        }
        return res;
    }
}
