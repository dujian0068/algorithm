package com.bmilk.algorithm.dp;

import javax.security.sasl.SaslServer;

public class LC64_MinPathSum {
    public static void main(String[] args) {

        int[][] grid = {{1,2,3},{4,5,6}};
        LC64_MinPathSum service = new LC64_MinPathSum();
        int i = service.minPathSum(grid);
        System.out.println(i);
    }

    public int minPathSum(int[][] grid) {
        if(null == grid) return 0;
        int row = grid.length;
        int col = grid[0].length;

        for (int i=1;i<col;i++){
            grid[0][i] = grid[0][i] + grid[0][i-1];

        }

        for (int i=1; i<row;i++){
            grid[i][0] = grid[i][0] + grid[i-1][0];
        }
        for (int i=1;i<row; i++){
            for (int j=1;j<col; j++){
                grid[i][j] = Math.min(grid[i-1][j], grid[i][j-1]) + grid[i][j];

            }
        }

        return grid[row-1][col-1];
    }
}
