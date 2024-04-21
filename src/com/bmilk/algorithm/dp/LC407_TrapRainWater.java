package com.bmilk.algorithm.dp;

public class LC407_TrapRainWater {

    public static void main(String[] args) {
        int[][] heightMap = {{1, 4, 3, 1, 3, 2}, {3, 2, 1, 3, 2, 4}, {2, 3, 3, 2, 3, 1}};
        LC407_TrapRainWater o = new LC407_TrapRainWater();
        int i = o.trapRainWater(heightMap);
        System.out.println(i);

    }

    public int trapRainWater(int[][] heightMap) {

        int row = heightMap.length;
        int col = heightMap[0].length;

        int[][] bfs = new int[row][col];
        for (int i = 0; i < row; i++) {
            System.arraycopy(heightMap[i], 0, bfs[i], 0, col);
        }
        boolean update;
        do {
            update = false;
            for (int i = 1; i < row - 1; i++) {
                for (int j = 1; j < col - 1; j++) {
                    int min = Math.min(Math.min(bfs[i - 1][j], bfs[i + 1][j]), Math.min(bfs[i][j - 1], bfs[i][j + 1]));
                    if (bfs[i][j] < min) {
                        bfs[i][j] = min;
                        update = true;

                    }
                }
            }
        } while (update);

        int result = 0;
        for (int i = 1; i < row - 1; i++) {
            for (int j = 1; j < col - 1; j++) {
                result += bfs[i][j] > heightMap[i][j] ? bfs[i][j] - heightMap[i][j] : 0;
            }
        }
        return result;
    }
}
