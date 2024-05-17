package com.bmilk.algorithm.bfs;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class LC542_UpdateMatrix {

    public static void main(String[] args) {
        LC542_UpdateMatrix o = new LC542_UpdateMatrix();
        int[][] mat ={ {0,0,0},{0,1,0}, {1,1,1}};
        int[][] result = o.updateMatrix(mat);
        for (int[] tmp : result){
            System.out.println(Arrays.toString(tmp));

        }

    }
    public int[][] updateMatrix(int[][] mat) {
        int row = mat.length;
        int col = mat[0].length;
        int[][] result = new int[row][col];

        Queue<int[]> partitionQueue = new LinkedList<>();
        for (int i = 0; i<row;i++){
            for (int j = 0; j<col; j++){
                result[i][j] = 0;
                if(mat[i][j] == 0){
                    partitionQueue.add(new int[]{i, j});
                }
            }
        }
        while (!partitionQueue.isEmpty()){
            int[] partition = partitionQueue.poll();
            int i = partition[0];
            int j = partition[1];

            if(i-1>=0 && mat[i-1][j] != 0 ){
                if(result[i-1][j] == 0 || result[i-1][j] > result[i][j]+1){
                    result[i-1][j] = result[i][j]+1;
                    partitionQueue.add(new int[]{i-1,j});
                }
            }
            if(i+1<row && mat[i+1][j] != 0){
                if(result[i+1][j] == 0 || result[i+1][j] > result[i][j]+1){
                    result[i+1][j] = result[i][j]+1;
                    partitionQueue.add(new int[]{i+1,j});
                }
            }
            if(j-1>=0 && mat[i][j-1] != 0 ){
                if(result[i][j-1] == 0 || result[i][j-1] > result[i][j]+1){
                    result[i][j-1] = result[i][j]+1;
                    partitionQueue.add(new int[]{i,j-1});
                }
            }
            if(j+1<col && mat[i][j+1] != 0){
                if(result[i][j+1] == 0 || result[i][j+1] > result[i][j]+1){
                    result[i][j+1] = result[i][j]+1;
                    partitionQueue.add(new int[]{i,j+1});
                }
            }
        }
        return result;
    }

}
