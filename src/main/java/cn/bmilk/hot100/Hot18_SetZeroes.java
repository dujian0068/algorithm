package cn.bmilk.hot100;

import java.util.Arrays;

public class Hot18_SetZeroes {


    public void setZeroes(int[][] matrix) {
        int row = matrix.length;
        int col = matrix[0].length;

        int[][] tmp = new int[row][col];
        for (int i = 0; i< row; i++){
            System.arraycopy(matrix[i], 0, tmp[i], 0, col);
        }

        for (int i =0 ; i< row; i++){
            for (int j = 0; j < col; j++){
                if(tmp[i][j] == 0){
                    for (int k = 0; k< col; k++){
                        matrix[i][k] = 0;
                    }
                    for (int k =0; k<row; k++){
                        matrix[k][j] = 0;
                    }
                }
            }
        }
    }


    public void setZeroes2(int[][] matrix) {
        int row = matrix.length;
        int col = matrix[0].length;

        int[] rowArr = new int[row];
        int[] colArr = new int[col];
        for (int i = 0; i< row; i++){
            for (int j = 0; j< col; j++){
                if(matrix[i][j] == 0){
                    rowArr[i] = 1;
                    colArr[j] = 1;
                }
            }
        }

        for (int i = 0 ; i< row; i++){
            if(rowArr[i] == 0){
                continue;
            }
            for (int j = 0; j< col; j++){
                matrix[i][j] = 0;
            }
        }
        for (int j =0; j< col; j++){
            if(colArr[j] == 0){
                continue;
            }
            for (int i =0; i< row; i++){
                matrix[i][j] = 0;
            }
        }
    }


    public void setZeroes3(int[][] matrix) {
        int row = matrix.length;
        int col = matrix[0].length;

        int zRowFirst = 1;
        int zColFirst = 1;
        for (int i=0; i< row; i++){
            if(matrix[i][0] == 0){
                zColFirst = 0;
            }
        }
        for (int j=0; j< col; j++){
            if(matrix[0][j] == 0){
                zRowFirst = 0;
            }
        }


        for (int i = 0; i< row; i++){
            for (int j = 0; j< col; j++){
                if(matrix[i][j] == 0){
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }

        for (int i = 1 ; i< row; i++){
            if(matrix[i][0] != 0){
                continue;
            }
            for (int j =1; j< col; j++){
                matrix[i][j] = 0;
            }
        }
        for (int j =1; j< col; j++){
            if(matrix[0][j] != 0){
                continue;
            }
            for (int i =1; i< row; i++){
                matrix[i][j] = 0;
            }
        }
        if(zRowFirst == 0){
            for (int j=0; j< col; j++){
                matrix[0][j] = 0;
            }
        }

        if ( zColFirst == 0){
            for (int i=0; i< row; i++){
                matrix[i][0] = 0;
            }
        }
    }
}
