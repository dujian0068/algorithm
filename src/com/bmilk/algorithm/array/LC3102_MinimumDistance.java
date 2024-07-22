package com.bmilk.algorithm.array;

public class LC3102_MinimumDistance {
    public static void main(String[] args) {
        int[][] points = {{3,10},{5,15},{10,2},{4,4}};
        LC3102_MinimumDistance o = new LC3102_MinimumDistance();
        int i = o.minimumDistance(points);
        System.out.println(i);
    }
    public int minimumDistance(int[][] points) {
        int res = Integer.MAX_VALUE;
        for (int i= 0; i< points.length-1; i++){
            int tmp = 0;
            for (int j = i+1; j< points.length; j++){
                tmp = Math.max(tmp, getDis(points[i], points[j]));
            }
            res = Math.min(tmp, res);
        }
        return res;
    }

    private int getDis(int[] p1, int[] p2){
        return Math.abs(p1[0] - p2[0]) + Math.abs(p1[1] - p2[1]);
    }
}
