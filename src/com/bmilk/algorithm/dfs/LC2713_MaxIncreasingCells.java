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
        // 从小到大排序 状态转转移一定是从最小的开始
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
        // 如果当前值比他做在行的最大的严格递增的位置都大，那么可以从这个位置转移至当前位置
        if (mat[x][row[x]] < mat[x][y]) {
            dp[x][y] = Math.max(dp[x][y], dp[x][row[x]] + 1);
        }
        // 如果当前值比他做在列的最大的严格递增的位置都大，那么可以从这个位置转移至当前位置
        if (mat[col[y]][y] < mat[x][y]) {
            dp[x][y] = Math.max(dp[x][y], dp[col[y]][y] + 1);
        }
        // 有可能有与当前数相同的数，他们的转移需要从上一个比他严格小的位置转移
        // 之所以先转移这些值而不是先更新行、列最大值是因为防止下一个值和当前值在同行或者同列，这样转移就会异常
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
