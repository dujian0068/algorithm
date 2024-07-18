package com.bmilk.algorithm.graph;

import java.util.*;

public class LC3112_MinimumTime {

    public static void main(String[] args) {
        LC3112_MinimumTime o = new LC3112_MinimumTime();
        int[][] edges = new int[][]{{2,0,9},{1,0,5},{2,2,4},{0,1,10},{1,1,10},{1,1,10},{2,2,10},{1,1,10}};
        int[] disappear = new int[]{4,13,19};
        int[] ints = o.minimumTime(3, edges, disappear);
        System.out.println(Arrays.toString(ints));
    }
    public int[] minimumTime(int n, int[][] edges, int[] disappear) {
        List<int[]>[] adj = new List[n];
        int[] res = new int[n];
        for (int i = 0; i< n; i++){
            adj[i] = new ArrayList<>();
            res[i] = -1;
        }
        for (int[] edge : edges){
            adj[edge[0]].add(new int[]{edge[1], edge[2]});
            adj[edge[1]].add(new int[]{edge[0], edge[2]});
        }
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
        pq.offer(new int[]{0,0});
        res[0] = 0;
        while (!pq.isEmpty()){
            int[] arr = pq.poll();
            int t = arr[0];
            int u = arr[1];
            if( u > res[t] && res[t] != -1){
                continue;
            }
            for (int[] next : adj[t]){
                int v = next[0];
                int len = next[1];
                if(u + len < disappear[v] && (res[v] == -1 || u+len < res[v])){
                    pq.offer(new int[]{v, len + u});
                    res[v] = u + len;
                }
            }
        }
        return res;
    }
}
