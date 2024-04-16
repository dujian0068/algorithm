package com.bmilk.algorithm.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LC54_SpiralOrder {

    public static void main(String[] args) {
        LC54_SpiralOrder o = new LC54_SpiralOrder();
        int[][] matrix = {{1,2,3, 4},{5,6,7,8},{9,10,11,12}};
        List<Integer> integers = o.spiralOrder(matrix);
        System.out.println(integers);
    }

    public List<Integer> spiralOrder(int[][] matrix) {
        if(null == matrix || matrix.length == 0 || matrix[0].length == 0){
            return new ArrayList<>();
        }
        List<Integer> result= new ArrayList<>();
        int[] leftUp = {0, 0};
        int[] leftDown = {matrix.length - 1, 0};
        int[] rightUP = {0, matrix[0].length - 1};
        int[] rightDown = {matrix.length - 1, matrix[0].length - 1};
        int size =  matrix.length * matrix[0].length;
        while (result.size() != size){
            for (int i = leftUp[1]; i <= rightUP[1]; i++){
                result.add(matrix[leftUp[0]][i]);
            }
            if(result.size() == size) break;
            leftUp[0]++;
            rightUP[0]++;
            for (int i = rightUP[0]; i <= rightDown[0]; i++){
                result.add(matrix[i][rightUP[1]]);
            }
            if(result.size() == size) break;
            rightUP[1]--;
            rightDown[1]--;
            for (int i = rightDown[1]; i >= leftDown[1]; i--){
                result.add(matrix[leftDown[0]][i]);
            }
            if(result.size() == size) break;
            leftDown[0]--;
            rightDown[0]--;
            for (int i = leftDown[0]; i >= leftUp[0]; i--){
                result.add(matrix[i][leftUp[1]]);
            }
            if(result.size() == size) break;
            leftUp[1]++;
            leftDown[1]++;
        }

        return result;

    }
}
