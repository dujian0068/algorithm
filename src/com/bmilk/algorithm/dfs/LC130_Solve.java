package com.bmilk.algorithm.dfs;

import java.util.Arrays;

public class LC130_Solve {

    private int col;
    private int row;

    public static void main(String[] args) {
        char[][] board = {{'X','X','X','X','O','X'},
                {'O','X','X','O','O','X'},
                {'X','O','X','O','O','O'},
                {'X','O','O','O','X','O'},
                {'O','O','X','X','O','X'},
                {'X','O','X','O','X','X'}};
        LC130_Solve o = new LC130_Solve();
        o.solve(board);
        System.out.println(Arrays.deepToString(board));
    }
    public void solve(char[][] board) {
        if(null == board || 0 == board.length){
            return;
        }
        row = board.length;
        col = board[0].length;

        for (int i = 0; i< row; i++){
            for (int j = 0; j< col; j++){
                if(board[i][j] == 'O' && (i ==0 || j==0 || i==row-1 || j== col-1)){
                    solve(board, i, j);
                }
            }
        }

        for (int i = 0; i< row; i++){
            for (int j = 0; j< col; j++){
                if(board[i][j] == 'O'){
                    board[i][j] = 'X';
                }
                if(board[i][j] == 'A'){
                    board[i][j] = 'O';
                }
            }
        }

    }
    public void solve(char[][] board, int x , int y){
        if( x < 0 || x>=row || y <0 || y>=col){
            return;
        }
        if(board[x][y] != 'O'){
            return;
        }
        board[x][y] = 'A';
        solve(board, x+1 ,y);
        solve(board, x-1 ,y);
        solve(board, x ,y+1);
        solve(board, x ,y-1);
    }
}
