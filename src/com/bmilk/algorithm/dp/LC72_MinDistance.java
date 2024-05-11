package com.bmilk.algorithm.dp;

public class LC72_MinDistance {

    public static void main(String[] args) {
        LC72_MinDistance o = new LC72_MinDistance();
        int i = o.minDistance("distance", "springbok");
        System.out.println(i);
    }

    public int minDistance(String word1, String word2) {
        if((null == word1 || "".equals(word1)) && (null == word2 || "".equals(word2))) return 0;
        if(null == word1 || "".equals(word1)) return word2.length();
        if(null == word2 || "".equals(word2)) return word1.length();

        int row = word1.length();
        int col = word2.length();

        int[][] dp = new int[row+1][col+1];
        for (int i = 0; i<= row; i++){
            dp[i][0]= i;
        }
        for (int j = 0; j<= col; j++){
            dp[0][j]= j;
        }

        for (int i = 1; i<= row; i++){
            for (int j =1; j<= col; j++){
                if(word1.charAt(i-1) == word2.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1];
                }else {
                    int min = Math.min(Math.min(dp[i-1][j], dp[i][j-1]),dp[i-1][j-1]);
                    dp[i][j] = min+1;
                }
            }
        }
        return dp[row][col];


    }
}
