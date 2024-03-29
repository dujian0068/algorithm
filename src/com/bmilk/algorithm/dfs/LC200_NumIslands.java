package com.bmilk.algorithm.dfs;

public class LC200_NumIslands {


    public static void main(String[] args) {
        char[][] grid = {{'1','1','1'}, {'0','1','0'}, {'1','1','1'}};
        LC200_NumIslands o = new LC200_NumIslands();
        int i = o.numIslands(grid);
        System.out.println(i);
    }

    public int numIslands(char[][] grid) {
        int result =0 ;
        int row = grid.length;
        int col = grid[0].length;

        for (int x = 0; x<row; x++){
            for (int y = 0; y<col; y++){
                if(grid[x][y] == '1'){
                    result++;
                    check(grid, x, y, row, col);
                }
            }
        }
        return result;
    }

    public void check(char[][] grid, int x, int y, int row, int col){
        if(x >= row || y>= col || 0>x || 0>y || grid[x][y] == '0'|| grid[x][y] == '2') return;
        if(grid[x][y] == '1'){
            grid[x][y] = '2';
        }
        check(grid, x-1, y, row, col);
        check(grid, x, y-1, row, col);
        check(grid, x+1, y, row, col);
        check(grid, x, y+1, row, col);
    }

}
