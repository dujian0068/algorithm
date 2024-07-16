package com.bmilk.algorithm.array;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class LC3033_ModifiedMatrix {
    public int[][] modifiedMatrix(int[][] matrix) {

        int row = matrix.length;
        int col = matrix[0].length;

        int max;
        //Queue<Integer> queue = new LinkedList<>();
        for (int y = 0; y < col; y++){
            max = Integer.MIN_VALUE;
            for (int x = 0; x< row; x++){
                max = Math.max(matrix[x][y], max);
//                if(-1 == matrix[x][y]){
//                    queue.add(x);
//                }
            }
//            while (!queue.isEmpty()){
//                matrix[queue.poll()][y] = max;
//            }
            for (int x = 0; x< row; x++){
                if(-1 == matrix[x][y]){
                    matrix[x][y] = max;
                }
            }
        }
        return matrix;
    }
}
