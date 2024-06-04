package com.bmilk.algorithm.array;

import java.util.Arrays;

public class LC2965_FindMissingAndRepeatedValues {

    public static void main(String[] args) {
        LC2965_FindMissingAndRepeatedValues o = new LC2965_FindMissingAndRepeatedValues();
        int[][] grid = {{9,1,7}, {8,9,2},{3,4,6}};
        int[] missingAndRepeatedValues = o.findMissingAndRepeatedValues(grid);
        System.out.println(Arrays.toString(missingAndRepeatedValues));
    }

    public int[] findMissingAndRepeatedValues(int[][] grid) {
        int a = 0;
        int b = 0;
        int n = grid.length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                while (grid[i][j] != i * n + j + 1) {
                    int x = (grid[i][j] - 1) / n;
                    int y = grid[i][j] - 1 - x * n;
                    if (grid[x][y] == x * n + y + 1) {
                        a = grid[x][y];
                        break;
                    }
                    int tmp = grid[i][j];
                    grid[i][j] = grid[x][y];
                    grid[x][y] = tmp;
                }

            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] != i * n + j + 1) {
                    b = i * n + j + 1;
                }
            }
        }
        return new int[]{a, b};
    }
}
