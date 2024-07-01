package com.bmilk.algorithm.dfs;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class LC2065_MaximalPathQuality {
    public static void main(String[] args) {
        LC2065_MaximalPathQuality o = new LC2065_MaximalPathQuality();
        int[] values = {0,32,10,43};
        int[][] edges = {{0,1,10}, {1,2,15}, {0,3,10}};

        int i = o.maximalPathQuality(values, edges, 49);
        System.out.println(i);
    }

    int result ;
    int maxTime;
    public int maximalPathQuality(int[] values, int[][] edges, int maxTime) {

        this.result = 0;
        this.maxTime = maxTime;
        int len = values.length;
        List<List<int[]>> g = new ArrayList<>(len);
        boolean[] visit = new boolean[len];

        for (int i = 0;i < len; i++){
            g.add(new ArrayList<>());
            visit[i] = false;
        }

        for (int[] edge : edges){
            g.get(edge[0]).add(new int[]{edge[1],edge[2]});
            g.get(edge[1]).add(new int[]{edge[0],edge[2]});
        }

        visit[0] = true;
        dfs(values, g, visit, 0, values[0], 0);

        return result;
    }

    public void dfs(int[] values, List<List<int[]>> g, boolean[] visit, int time, int value, int index){
        if(time > maxTime){
            return;
        }
        if(index == 0){
            result = Math.max(result, value);
        }
        for (int[] gi : g.get(index)){
            if (visit[gi[0]]) {
                dfs(values, g, visit, time+gi[1], value, gi[0]);
            }else {
                visit[gi[0]] = true;
                dfs(values, g, visit, time+gi[1], value + values[gi[0]], gi[0]);
                visit[gi[0]] = false;
            }
        }
    }
}
