package com.bmilk.algorithm.greedy;

import javax.print.attribute.standard.PrintQuality;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class LC2813_FindMaximumElegance {
    public long findMaximumElegance(int[][] items, int k) {
        Map<Integer, PriorityQueue<int[]>> categoryMap = new HashMap<>();
        // 区分不同项目
        // 每个项目按照从大到小排序
        for (int[] item : items){
            if(!categoryMap.containsKey(item[0])){
                categoryMap.put(item[0], new PriorityQueue<>((o1, o2) -> o2[0]-o1[0]));
            }
            categoryMap.get(item[0]).add(item);
        }
        int num = categoryMap.size();



    }
}
