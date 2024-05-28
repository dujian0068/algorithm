package com.bmilk.algorithm.array;

import java.util.ArrayList;
import java.util.List;

public class LC2951_FindPeaks {

    public List<Integer> findPeaks(int[] mountain) {
        List<Integer> result = new ArrayList<>();

        for (int i =1; i<mountain.length-1; i++){
            if(mountain[i] > mountain[i-1] && mountain[i]>mountain[i+1]){
                result.add(i);
            }
        }
        return result;
    }
}
