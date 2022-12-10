package com.bmilk.algorithm.array;

public class LC59_GenerateMatrix {

    public static void main(String[] args) {

        LC59_GenerateMatrix service = new LC59_GenerateMatrix();
        int[][] ints = service.generateMatrix(3);
        System.out.println(ints);
    }

    public int[][] generateMatrix(int n) {
        int max = n*n;
        int[][] res = new int[n][n];

        int i=1;
        int x=0;
        int y=0;
        while (i<=max){
            while (y<n && res[x][y] == 0){
                res[x][y++] = i++;
            }
            x++;
            y--;
            while (x<n && res[x][y] == 0){
                res[x++][y] = i++;
            }
            x--;
            y--;
            while (y >=0 && res[x][y] == 0){
                res[x][y--] = i++;
            }
            y++;
            x--;
            while (x >=0 && res[x][y] == 0){
                res[x--][y] = i++;
            }
            x++;
            y++;
        }
        return  res;
    }
}
