package com.bmilk.algorithm.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class LC56_Merge {

    public static void main(String[] args) {
        int[][] intervals = {{1,3},{2,6},{8,10},{15,18}};
        LC56_Merge service = new LC56_Merge();
        service.merge(intervals);
    }

    public int[][] merge(int[][] intervals) {

        Arrays.sort(intervals, Comparator.comparingInt(x -> x[0]));

        System.out.println(intervals);
        int begin = intervals[0][0];
        int end = intervals[0][1];

        List<int[]> merged = new ArrayList<int[]>();
        for (int i=1; i<intervals.length;i++){
            if(end < intervals[i][0]){
                int[] arr = {begin, end};
                merged.add(arr);
                begin = intervals[i][0];
                end = intervals[i][1];
            }else if(end >= intervals[i][0] && end<= intervals[i][1]){
                end = intervals[i][1];
            }
        }
        int[] arr = {begin, end};
        merged.add(arr);
        return merged.toArray(new int[merged.size()][]);
    }
}
