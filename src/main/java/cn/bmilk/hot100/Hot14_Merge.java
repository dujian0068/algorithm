package cn.bmilk.hot100;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Hot14_Merge {
    public int[][] merge(int[][] intervals) {

        Arrays.sort(intervals, (Comparator.comparingInt(o -> o[0])));

        List<int[]> resList = new ArrayList<>();
        resList.add(intervals[0]);
        for (int i = 1; i< intervals.length; i++){
            int[] last = resList.getLast();
            if(last[1] < intervals[i][0]){
                resList.add(intervals[i]);
            }else if (last[1] >= intervals[i][0] && last[1] < intervals[i][1]){
                last[1] = intervals[i][1];
            }
        }
        int[][] res  = new int[resList.size()][2];
        int index = 0;
        for (int[] ints : resList) {
            res[index++] = ints;
        }
        return res;
    }
}
