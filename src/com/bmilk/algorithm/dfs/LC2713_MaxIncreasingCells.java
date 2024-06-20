package com.bmilk.algorithm.dfs;

import java.util.Arrays;

public class LC2713_MaxIncreasingCells {
    public static void main(String[] args) {
        LC2713_MaxIncreasingCells o = new LC2713_MaxIncreasingCells();
        int[][] mat = {{3, 1}, {3, 4}};
        int i = o.maxIncreasingCells(mat);
        System.out.println(i);
    }

    int res = 0;
    int[][] dp;
    int[][] arr;
    int[] row;
    int[] col;

    public int maxIncreasingCells(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;

        dp = new int[m][n];
        arr = new int[m * n][2];
        row = new int[m];
        col = new int[n];
        int arrI = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                arr[arrI++] = new int[]{i, j};
            }
        }
        Arrays.sort(arr, (o1, o2) -> {
            int i = mat[o1[0]][o1[1]] - mat[o2[0]][o2[1]];
            return i;
        });
        int i = 0;
        while (i < arr.length) {
            i = doDP(i, mat, arr.length);
            i++;
        }

        return res;
    }

    public int doDP(int i, int[][] mat, int len) {
        int x = arr[i][0];
        int y = arr[i][1];
        dp[x][y] = 1;
        if (mat[x][row[x]] < mat[x][y]) {
            dp[x][y] = Math.max(dp[x][y], dp[x][row[x]] + 1);
        }
        if (mat[col[y]][y] < mat[x][y]) {
            dp[x][y] = Math.max(dp[x][y], dp[col[y]][y] + 1);
        }
        if (i < len - 1 && mat[x][y] == mat[arr[i + 1][0]][arr[i + 1][1]]) {
            i = doDP(i + 1, mat, len);
        }
        if (dp[x][y] > dp[x][row[x]]) {
            row[x] = y;
        }
        if (dp[x][y] > dp[col[y]][y]) {
            col[y] = x;
        }
        res = Math.max(dp[x][y], res);
        return i;
    }
}
