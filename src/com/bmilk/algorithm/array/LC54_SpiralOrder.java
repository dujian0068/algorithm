package com.bmilk.algorithm.array;

import java.util.ArrayList;
import java.util.List;

public class LC54_SpiralOrder {
    public static void main(String[] args) {

        int[][] matrix = {{1,2,3,4},{5,6,7,8},{9,10,11,12}};
        LC54_SpiralOrder service = new LC54_SpiralOrder();
        List<Integer> integers = service.spiralOrder(matrix);
        System.out.println(integers);

    }
    public List<Integer> spiralOrder(int[][] matrix) {
        int row = matrix.length;
        int col = matrix[0].length;
        int[][] tmp = new int[row][col];

        List<Integer> res = new ArrayList<>();
        int x = 0, y=0;
        while (res.size() != row * col) {
            while (y < col && tmp[x][y] != 1) {
                res.add(matrix[x][y]);
                tmp[x][y] = 1;
                y++;
            }
            y--;
            x++;

            while (x < row && tmp[x][y] != 1) {
                res.add(matrix[x][y]);
                tmp[x][y] = 1;
                x++;
            }
            x--;
            y--;
            while (y >= 0 && tmp[x][y] != 1) {
                res.add(matrix[x][y]);
                tmp[x][y] = 1;
                y--;
            }
            y++;
            x--;
            while (x >= 0 && tmp[x][y] != 1) {
                res.add(matrix[x][y]);
                tmp[x][y] = 1;
                x--;
            }
            x++;
            y++;
        }
        return res;
    }
}
