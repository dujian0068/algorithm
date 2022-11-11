package com.bmilk.algorithm.dfs;

public class LC200_NumIslands {
    public static void main(String[] args) {
        char[][] arr = new char[][]{{'1','1','1'}, {'0','1','0'},{'1','1','1'}};
        LC200_NumIslands service = new LC200_NumIslands();
        int i = service.numIslands(arr);
        System.out.println(i);
    }

    public int numIslands(char[][] grid) {

        int res = 0;
        for (int i =0; i<grid.length;i++){
            for (int j =0; j<grid[0].length;j++){
                if( grid[i][j] == '1'){
                    res = res+1;
                    dfs(grid, i, j);
                }
            }
        }
        return  res;
    }

    public void dfs(char[][] grid, int i, int j){
        if(i >= grid.length || j>=grid[0].length || i<0 || j<0) return;;

        if(i+1 < grid.length && grid[i+1][j] == '1'){
            grid[i+1][j] = '0';
            dfs(grid, i+1,j);
        }

        if(i-1 >= 0 && grid[i-1][j] == '1'){
            grid[i-1][j] = '0';
            dfs(grid, i-1,j);
        }
        if(j+1 < grid[0].length && grid[i][j+1] == '1'){
            grid[i][j+1] = '0';
            dfs(grid, i,j+1);
        }
        if(j-1 >=0 && grid[i][j-1] == '1'){
            grid[i][j-1] = '0';
            dfs(grid, i,j-1);
        }
    }
}


