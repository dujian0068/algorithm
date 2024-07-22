package com.bmilk.algorithm.graph;

import java.util.*;

public class LC2101_MaximumDetonation {
    public int maximumDetonation(int[][] bombs) {
        int[] round = new int[bombs.length];
        Map<Integer, List<Integer>> edges = new HashMap<>();
        for (int i = 0; i< bombs.length; i++){
            for (int j = 0; j< bombs.length ; j++){
                if(i ==j ) continue;
                if(isConnected(bombs, i, j)){
                    edges.putIfAbsent(i, new ArrayList<>());
                    edges.get(i).add(j);
                }
            }
        }
        int res = 0;
        for (int i =0; i< bombs.length; i++){
            boolean[] visited = new boolean[bombs.length];
            Queue<Integer> queue = new LinkedList<>();
            queue.offer(i);
            visited[i] = true;
            int count = 1;
            while (!queue.isEmpty()){
                Integer poll = queue.poll();
                for (Integer j: edges.getOrDefault(poll, new ArrayList<>())){
                    if(!visited[j]){
                        queue.offer(j);
                        count++;
                        visited[j] = true;
                    }
                }
            }
            res = Math.max(count, res);
        }
        return res;
    }

    private boolean isConnected(int[][] bombs, int i, int j){
        int[] il = bombs[i];
        int[] jl = bombs[j];
        return (long) il[2] * il[2] >= (long)(il[0] - jl[0]) * (il[0] - jl[0]) + (long)(il[1] - jl[1]) * (il[1] - jl[1]);
    }
}
