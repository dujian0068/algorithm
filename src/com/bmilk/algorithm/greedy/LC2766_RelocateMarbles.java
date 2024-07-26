package com.bmilk.algorithm.greedy;

import java.util.*;

public class LC2766_RelocateMarbles {
    public List<Integer> relocateMarbles(int[] nums, int[] moveFrom, int[] moveTo) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums){
            set.add(num);
        }

        for (int i = 0; i< moveFrom.length; i++){
            set.remove(moveFrom[i]);
            set.add(moveTo[i]);
        }
        List<Integer> res = new ArrayList<>();
        for (int num : set){
            res.add(num);
        }
        res.sort(Comparator.comparingInt(o -> o));
        return res;

    }
}
