package com.bmilk.algorithm.dfs;

public class LC419_CountBattleships {
    public int countBattleships(char[][] board) {
        int row = board.length;
        int col = board[0].length;
        int result = 0;

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (board[i][j] != 'X') {
                    continue;
                }
                result++;
                board[i][j] = 'O';
                dfs(board, i + 1, j, row, col, 'x');
                dfs(board, i, j + 1, row, col, 'y');
            }
        }
        return result;
    }

    private void dfs(char[][] board, int x, int y, int row, int col, char path) {
        if (x >= row || y >= col) {
            return;
        }
        if (board[x][y] != 'X') return;
        board[x][y] = 'O';
        if (path == 'x') {
            dfs(board, x + 1, y, row, col, path);
        } else {
            dfs(board, x, y + 1, row, col, path);
        }
    }

    public static void main(String[] args) {
        LC419_CountBattleships o = new LC419_CountBattleships();
        char[][] board = {{'X', 'X', 'X'}};
        o.countBattleships2(board);


    }

    public int countBattleships2(char[][] board) {
        int result = 0;
        int row = board.length;
        int col = board[0].length;


        for (int i = 0; i< row; i++){
            for (int j = 0; j<col; j++){
                if(board[i][j] != 'X'){
                    continue;
                }
                if(i==0 && j ==0 ){
                    result++;
                }else if( i == 0 && board[i][j-1] != 'X'){
                    result ++;
                }else if(j ==0 && board[i-1][j] != 'X'){
                    result++;
                }else if(i >0 && j>0 && board[i-1][j] != 'X' && board[i][j-1]!= 'X'){
                    result++;
                }
            }
        }
        return result;
    }

}
