package com.bmilk.algorithm.dfs;

public class LC695_MaxAreaOfIsland {
    int result;
    int count;
    int row;
    int col;

    public int maxAreaOfIsland(int[][] grid) {

        result = 0;
        row = grid.length;
        col = grid[0].length;

        for (int i=0; i<row; i++){
            for (int j = 0 ; j< col ; j++){

                if(grid[i][j] == 1){
                    count = 0;
                    dfs(grid, i, j);
                    result = Math.max(count, result);
                }
            }
        }
        return result;

    }

    private void dfs(int[][] grid, int x, int y){
        if(x <0 || x>=row || y<0 || y>=col ){
            return;
        }
        if(grid[x][y] != 1){
            return;
        }
        grid[x][y] = 2;
        count++;
        dfs(grid, x+1, y);
        dfs(grid, x-1, y);
        dfs(grid, x, y+1);
        dfs(grid, x, y-1);
    }
}
