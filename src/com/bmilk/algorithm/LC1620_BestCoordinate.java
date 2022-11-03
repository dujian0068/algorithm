package com.bmilk.algorithm;

public class LC1620_BestCoordinate {

    public static void main(String[] args) {

    }

    public int[] bestCoordinate(int[][] towers, int radius) {
        int maxX=0;
        int maxY = 0;
        for (int[] ints : towers) {
            maxX = Math.max(maxX, ints[0]);
            maxY = Math.max(maxY, ints[1]);
        }

        int cx = 0, cy = 0;
        int r = 0;
        for (int x=0;x<=maxX; x++){
            for (int y =0;y<=maxY;y++){
                int num =0;
                for(int[] tower:  towers){
                    int dLen = dLen(x, y, tower);
                    if(dLen <= radius * radius){
                        double sqrt = Math.sqrt(dLen);
                        num += (int) Math.floor(tower[2] / (1 + sqrt));
                    }
                }
                if(num>r){
                    cx = x;
                    cy= y;
                    r = num;
                }
            }
        }
        return new int[]{cx, cy};
    }

    public int dLen(int x, int y, int[] tower){
        return  (tower[0] - x) * (tower[0] - x) + (tower[1] - y) * (tower[1] - y);
    }
}
