package com.bmilk.algorithm.dp;

public class BM66_LCS {
    public static void main(String[] args) {
        BM66_LCS service = new BM66_LCS();
        String lcs = service.LCS("2LQ74WK8Ld0x7d8FP8l61pD7Wsz1E9xOMp920hM948eGjL9Kb5KJt80", "U08U29zzuodz16CBZ8xfpmmn5SKD80smJbK83F2T37JRqYfE76vh6hrE451uFQ100ye9hog1Y52LDk0L52SuD948eGjLz0htzd5YF9J1Y6oI7562z4T2");
        System.out.println(lcs);
    }

    public String LCS (String str1, String str2) {
        int n = str1.length();
        int m = str2.length();
        char[] c1 = str1.toCharArray();
        char[] c2 = str2.toCharArray();

        int max =0;
        int ep =0;
        int[][] dp = new int[n+1][m+1];
        for (int i =0 ;i<=n;i++){
            dp[i][0] = 0;
        }
        for (int i =0 ;i<=m;i++){
            dp[0][i] = 0;
        }

        for (int i =1; i<=n;i++){
            for (int j =1; j<=m;j++){
                if(c1[i-1] == c2[j-1]){
                    dp[i][j] = dp[i-1][j-1]+1;
                    if(max < dp[i][j]){
                        max = dp[i][j];
                        ep = i;
                    }
                }else {
                    dp[i][j] = 0;
                }
            }
        }
        return str1.substring(ep-max, ep);
    }
}
