package com.bmilk.algorithm.array;

public class LC463_IslandPerimeter {



    public int islandPerimeter(int[][] grid) {

        int count=0;
        int c =0;

        int row = grid.length;
        int col = grid[0].length;

        for (int i= 0; i< row; i++){
            for (int j = 0; j<col; j++){
                if(grid[i][j] ==1){
                    count++;

                    if(i + 1 < row && grid[i+1][j] == 1) c++;
                    if(i -1 >= 0 && grid[i-1][j] == 1) c++;
                    if(j + 1 < col && grid[i][j+1] == 1) c++;
                    if(j - 1 >=0 && grid[i][j-1] == 1) c++;

                }

            }
        }
        return count *4 -c;

    }
}
