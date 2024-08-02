package com.bmilk.algorithm.prefixsum;

import java.util.Arrays;

public class LC3128_NumberOfRightTriangles {
    public long numberOfRightTriangles(int[][] grid) {
        int row = grid.length;
        int col = grid[0].length;
        int[] rowCount = new int[row];
        int[] colCount = new int[col];
        for (int i = 0 ;i< row; i++) {
            for (int j = 0; j< col; j++){
                rowCount[i] += grid[i][j];
                colCount[j] += grid[i][j];
            }
        }
        long res =0;
        for (int i = 0 ; i< row; i++){
            for(int j = 0; j< col; j++){
                if( 1 == grid[i][j]){
                    res += ((long)(rowCount[i] -1)) * ((long)(colCount[j] -1));
                }
            }
        }
        return res;

    }
}
