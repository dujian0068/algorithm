package com.bmilk.algorithm.dfs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LC59_SolveNQueens {
    public static void main(String[] args) {

        LC59_SolveNQueens service = new LC59_SolveNQueens();
        List<List<String>> lists = service.solveNQueens(4);
        System.out.println(lists);
    }

    boolean[] col ;
    boolean[] dg;
    boolean[] ndg;
    char[][] queue ;

    public List<List<String>> solveNQueens(int n) {
        col = new boolean[n];
        dg = new boolean[2*n];
        ndg = new boolean[2*n];
        queue = new char[n][n];
        for (int i=0;i<n;i++){
            for (int j =0; j<n;j++){
                queue[i][j]= '.';
            }
        }

        List<List<String>> res = new ArrayList<>();
        dfs(n, 0, res);
        return res;

    }


    public void dfs(int n, int row, List<List<String>> res){
        if(row>=n){
            res.add(buildString(queue));
            return;
        }
        for (int j =0; j< n; j++){
            if(col[j] || dg[row + j] || ndg[row-j+n]){
                continue;

            }
            col[j] = dg[row + j] = ndg[row-j+n] = true;
            queue[row][j] = 'Q';

            dfs(n, row+1, res);
            col[j] = dg[row + j] = ndg[row-j+n] = false;
            queue[row][j] = '.';
        }

    }

    private List<String> buildString(char[][] queue){
        List<String> list = new ArrayList<>();
        for (char[] q : queue){
            list.add(new String(q));
        }
        return list;
    }
}
