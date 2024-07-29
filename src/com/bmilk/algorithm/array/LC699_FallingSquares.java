package com.bmilk.algorithm.array;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class LC699_FallingSquares {
    public List<Integer> fallingSquares(int[][] positions) {
        int len = positions.length;
        List<Integer> hs = new ArrayList<>();
        for (int i = 0; i< len; i++){
            int left = positions[i][0];
            int right = positions[i][1] + left -1;
            int h = positions[i][1];
            for (int j =0; j<i; j++){
                int l = positions[j][0];
                int r = positions[j][1] + l -1;
                if(right >= l && r>=left){
                    h = Math.max(h, hs.get(i) + positions[i][1]);
                }
            }
            hs.add(h);
        }
        for (int i =1; i<len; i++){
            hs.set(i, Math.max(hs.get(i), hs.get(i-1)));
        }
        return hs;

    }
}
