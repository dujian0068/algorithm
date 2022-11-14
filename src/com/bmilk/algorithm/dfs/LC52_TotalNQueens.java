package com.bmilk.algorithm.dfs;

public class LC52_TotalNQueens {

    public static void main(String[] args) {

        LC52_TotalNQueens service = new LC52_TotalNQueens();
        long start = System.currentTimeMillis();
        int i = service.totalNQueens(16);
        System.out.println(System.currentTimeMillis()-start);
        System.out.println(i);

    }

    // n*n棋盘
    int[][] queue;
    // 哪一个列已经有皇后
    boolean[] col;
    // 斜线
    boolean[] dg;
    // 反斜线
    boolean[] ndg;
    int res = 0;

    public int totalNQueens(int n) {
        queue = new int[n][n];
        col = new boolean[n];
        dg = new boolean[2 * n];
        ndg = new boolean[2 * n];
        dfs(n, 0);
        return  res;

    }

    public void dfs(int n, int row){
        if(row >= n){
            res ++ ;
            return;
        }

        for (int j = 0; j < n; j++) {
            // col[j]第j列放过皇后
            // dg[row+j] 斜线方向有皇后
            // ndg[row - j + n]  反斜线上有皇后
            if(col[j] || dg[row+j] || ndg[row - j + n]){
                continue;
            }
            col[j] = dg[row + j] = ndg[row - j + n] = true;
            queue[row][j] = 1;

            dfs(n, row+1);

            col[j] = dg[row + j] = ndg[row - j + n] = false;
            queue[row][j] = 0;
        }
    }
}
