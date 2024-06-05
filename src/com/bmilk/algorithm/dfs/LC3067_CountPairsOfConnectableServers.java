package com.bmilk.algorithm.dfs;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class LC3067_CountPairsOfConnectableServers {

    public int[] countPairsOfConnectableServers(int[][] edges, int signalSpeed) {
        int n = edges.length+1;
        List<int[]>[] neighbors = new ArrayList[n];
        for (int i = 0; i<n; i++){
            neighbors[i] = new ArrayList<>();
        }
        for (int[] edge : edges){
            neighbors[edge[0]].add(new int[]{edge[1], edge[2]});
            neighbors[edge[1]].add(new int[]{edge[0], edge[2]});
        }
        int[] result = new int[n];
        for (int i= 0; i<n;i++){
            int childCount = 0;
            for (int[] child : neighbors[i]){
                int count = dfs(child[0], i, child[1], signalSpeed, neighbors);
                result[i] += count * childCount;
                childCount += count;
            }
        }
        return result;
    }

    private int dfs(int node, int parent, int distance, int signalSpeed, List<int[]>[] neighbors){
        int count = distance % signalSpeed ==0 ? 1: 0;
        for (int[] child : neighbors[node]){
            if(child[0] == parent){
                continue;
            }
            count += dfs(child[0], node, child[1] + distance, signalSpeed, neighbors);
        }
        return count;
    }
}
