package com.bmilk.algorithm.heap;

import java.util.PriorityQueue;

public class LC407_TrapRainWater {

    public static void main(String[] args) {
        LC407_TrapRainWater o  = new LC407_TrapRainWater();
        int[][] heightMap = {{3,3,3,3,3}, {3,2,2,2,3}, {3,2,1,2,3},
                {3,2,2,2,3}, {3,3,3,3,3}};
        int i = o.trapRainWater(heightMap);
        System.out.println(i);
    }

    public int trapRainWater(int[][] heightMap) {

        int result = 0;

        int row = heightMap.length;
        int col = heightMap[0].length;

        int[][] water = new int[row][col];

        PriorityQueue<int[]> queue = new PriorityQueue<>((o1,o2)->o1[2]-o2[2]);

        for (int i =0; i< row; i++){
            for (int j = 0; j< col; j++){
                if(i==0 || i==row-1 || j==0|| j== col-1){
                    water[i][j] = heightMap[i][j];
                    queue.add(new int[]{i,j,heightMap[i][j]});
                }else {
                    water[i][j] = -1;
                }
            }
        }
        int x;
        int y;
        int h;
        while (!queue.isEmpty()){
            int[] poll = queue.poll();
            x = poll[0];
            y = poll[1];
            h = poll[2];
            if(x>0 && water[x-1][y] == -1){
                if(heightMap[x-1][y] <= h){
                    water[x-1][y] = h;
                }else {
                    water[x-1][y] = heightMap[x-1][y];
                }
                queue.add(new int[]{x-1, y, water[x-1][y]});
                result += water[x-1][y] - heightMap[x-1][y];
            }
            if(x<row-1 && water[x+1][y] == -1){
                if(heightMap[x+1][y] <= h){
                    water[x+1][y] = h;
                }else {
                    water[x+1][y] = heightMap[x+1][y];
                }
                queue.add(new int[]{x+1, y, water[x+1][y]});
                result += water[x+1][y] - heightMap[x+1][y];
            }

            if(y>0 && water[x][y-1] == -1){
                if(heightMap[x][y-1] <= h){
                    water[x][y-1] = h;
                }else {
                    water[x][y-1] = heightMap[x][y-1];
                }
                queue.add(new int[]{x, y-1, water[x][y-1]});
                result += water[x][y-1] - heightMap[x][y-1];
            }

            if(y<col-1 && water[x][y+1] == -1){
                if(heightMap[x][y+1] <= h){
                    water[x][y+1] = h;
                }else {
                    water[x][y+1] = heightMap[x][y+1];
                }
                queue.add(new int[]{x, y+1, water[x][y+1]});
                result += water[x][y+1] - heightMap[x][y+1];
            }

        }
        return result;
    }
}
