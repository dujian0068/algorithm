package com.bmilk.algorithm.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class LC56_Merge {

    public int[][] merge(int[][] intervals) {

        if(null == intervals || intervals.length <= 1){
            return intervals;
        }

        Arrays.sort(intervals, Comparator.comparingInt(o -> o[0]));
        List<int[]> lists = new ArrayList<>();
        int[] arr = new int[2];
        arr[0]=intervals[0][0];
        arr[1]=intervals[0][1];
        lists.add(arr);
        for (int i =1; i< intervals.length; i++){
            if(intervals[i][0] <= arr[1]){
                if(intervals[i][1] > arr[1]){
                    arr[1] =intervals[i][1];
                }
            }else {
                arr = new int[2];
                arr[0]=intervals[i][0];
                arr[1]=intervals[i][1];
                lists.add(arr);
            }
        }
        int[][] result = new int[lists.size()][2];
        for (int i= 0; i<lists.size();i++){
            result[i]= lists.get(i);
        }
        return result;
    }
}
