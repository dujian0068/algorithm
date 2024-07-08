package com.bmilk.algorithm.array;

public class LC958_CheckMove {

    public static void main(String[] args) {
        char[][] board = {
                {'W','B','W','.','.','W','W','.'},
                {'W','B','.','W','W','W','B','W'},
                {'.','B','B','.','B','W','B','W'},
                {'.','.','B','B','B','W','W','.'},
                {'B','B','.','B','.','.','.','B'},
                {'.','W','B','.','.','B','.','B'},
                {'.','W','.','W','.','W','B','W'},
                {'W','.','B','.','W','W','B','.'}
        };
        LC958_CheckMove o = new LC958_CheckMove();
        boolean b = o.checkMove(board, 4, 6, 'W');
        System.out.println(b);
    }


    public boolean checkMove(char[][] board, int rMove, int cMove, char color) {
        return row(board, rMove, cMove, color) ||
                col(board, rMove, cMove, color) ||
                mid_1(board, rMove, cMove, color) ||
                mid1(board, rMove, cMove, color);
    }

    private boolean row(char[][] board, int rMove, int cMove, char color){
        boolean hasNull = false;
        int i = cMove-1;
        for (; i>=0 ; i--){
            if (board[rMove][i] == '.'){
                hasNull = true;
                break;
            }
            if(board[rMove][i] == color){
                break;
            }
        }
        if(!hasNull && i>=0 && cMove-i+1 >=3){
            return true;
        }
        hasNull= false;
        i = cMove+1;
        for (; i<board[0].length ; i++){
            if (board[rMove][i] == '.'){
                hasNull = true;
                break;
            }
            if(board[rMove][i] == color){
                break;
            }
        }
        if(!hasNull && i< board[0].length && i-cMove+1 >= 3){
            return true;
        }
        return false;
    }

    private boolean col(char[][] board, int rMove, int cMove, char color){
        boolean hasNull = false;
        int i = rMove-1;
        for (; i >=0; i--){
            if(board[i][cMove] == '.'){
                hasNull= true;
                break;
            }
            if(board[i][cMove] == color){
                break;
            }
        }
        if(!hasNull && i>=0 && rMove -i +1 >=3){
            return true;
        }
        hasNull = false;
        i = rMove +1;
        for (; i < board.length; i++){
            if(board[i][cMove] == '.'){
                hasNull= true;
                break;
            }
            if(board[i][cMove] == color){
                break;
            }
        }
        if(!hasNull && i <board.length && i - rMove +1 >=3){
            return true;
        }
        return false;
    }

    private boolean mid_1(char[][] board, int rMove, int cMove, char color){
        boolean hasNull = false;
        int i = rMove-1;
        int j = cMove -1;

        for (; i>=0 && j>=0 ; i--, j--){
            if (board[i][j] == '.'){
                hasNull = true;
                break;
            }
            if(board[i][j] == color){
                break;
            }
        }
        if(!hasNull && i>=0 && j>=0 && rMove-i+1 >=3){
            return true;
        }
        hasNull= false;
        i = rMove+1;
        j = cMove +1;
        for (; i< board.length && j < board[0].length ; i++, j++){
            if (board[i][j] == '.'){
                hasNull = true;
                break;
            }
            if(board[i][j] == color){
                break;
            }
        }
        if(!hasNull && i < board.length && j < board[0].length && i-rMove+1 >= 3){
            return true;
        }
        return false;
    }

    private boolean mid1(char[][] board, int rMove, int cMove, char color){
        boolean hasNull = false;
        int i = rMove-1;
        int j = cMove + 1;

        for (; i>=0 && j<board[0].length ; i--, j++){
            if (board[i][j] == '.'){
                hasNull = true;
                break;
            }
            if(board[i][j] == color){
                break;
            }
        }
        if(!hasNull && i >= 0 && j < board[0].length && rMove-i+1 >=3){
            return true;
        }
        hasNull= false;
        i = rMove+1;
        j = cMove -1;
        for (; i< board.length && j >=0  ; i++, j--){
            if (board[i][j] == '.'){
                hasNull = true;
                break;
            }
            if(board[i][j] == color){
                break;
            }
        }
        if(!hasNull && i< board.length && j >=0 && i-rMove+1 >= 3){
            return true;
        }
        return false;
    }
}
