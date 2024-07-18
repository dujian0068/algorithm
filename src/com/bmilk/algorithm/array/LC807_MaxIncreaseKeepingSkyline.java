package com.bmilk.algorithm.array;

public class LC807_MaxIncreaseKeepingSkyline {
    public int maxIncreaseKeepingSkyline(int[][] grid) {
        int[] row = new int[grid.length];
        int[] col = new int[grid[0].length];

        for (int i =0; i< grid.length;i++){
            for (int j = 0; j< grid[0].length; j++){
                row[i] = Math.max(row[i], grid[i][j]);
                col[j] = Math.max(col[j], grid[i][j]);
            }
        }
        int res = 0;
        for (int i =0; i< grid.length;i++){
            for (int j = 0; j< grid[0].length; j++){
                if(grid[i][j] == row[i] || grid[i][j] == col[j]){
                    continue;
                }
                res += Math.min(row[i], col[j]) - grid[i][j];
            }
        }
        return  res;
    }
}
