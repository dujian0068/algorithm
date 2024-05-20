package com.bmilk.algorithm.bfs;

import java.util.LinkedList;
import java.util.Queue;

public class LC407_TrapRainWater {

    public static void main(String[] args) {
        LC407_TrapRainWater o = new LC407_TrapRainWater();
        int[][] heightMap = {{1,4,3,1,3,2}, {3,2,1,3,2,4}, {2,3,3,2,3,1}};
        int i = o.trapRainWater(heightMap);
        System.out.println(i);
    }

    public int trapRainWater(int[][] heightMap) {
        int row = heightMap.length;
        int col = heightMap[0].length;
        if(row <= 2 || col <= 1){
            return 0;
        }

        int[][] water = new int[row][col];
        for (int i = 0; i<row; i++){
            for (int j =0; j<col; j++){
                water[i][j]= Integer.MAX_VALUE;
                if(i == 0|| i==row-1 || j==0 || j==col-1){
                    water[i][j] = heightMap[i][j];
                }
            }
        }

        int x;
        int y;
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{1,1});
        while (!queue.isEmpty()){
            int[] poll = queue.poll();
            x= poll[0];
            y = poll[1];
            int newH = Math.max(Math.min(Math.min(water[x-1][y], water[x+1][y]), Math.min(water[x][y-1], water[x][y+1])), heightMap[x][y]);
            if(water[x][y] != newH){
                water[x][y] = newH;
                if(x-1 > 0){
                    queue.add(new int[]{x-1,y});
                }
                if(x+1 < row-1){
                    queue.add(new int[]{x+1,y});
                }
                if(y-1 > 0){
                    queue.add(new int[]{x,y-1});
                }
                if(y+1 < col-1){
                    queue.add(new int[]{x, y+1});
                }
            }
        }
        int result = 0;
        for (int i = 1; i<row-1; i++){
            for (int j =1; j<col-1; j++){
                result += water[i][j] - heightMap[i][j];
            }
        }
        return  result;
    }
}
