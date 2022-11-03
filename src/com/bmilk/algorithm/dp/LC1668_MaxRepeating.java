package com.bmilk.algorithm.dp;

public class LC1668_MaxRepeating {

    public static void main(String[] args) {
        LC1668_MaxRepeating service = new LC1668_MaxRepeating();
        int i = service.maxRepeating("abab", "ab");
        System.out.println(i);

    }

    public int maxRepeating(String sequence, String word) {
        int sL = sequence.length();
        int wL = word.length();
        if(wL>sL) return 0;
        int[] dp = new int[sL+1];
        for (int i=0; i<wL;i++){
            dp[i] = 0;
        }
        int res = 0;
        for (int i= wL; i<=sL;i++){

            if(sequence.subSequence(i-wL, i).equals(word)){
                dp[i] = 1 + dp[i-wL];
            }else {
                dp[i] = 0;
            }

            if(dp[i]> res) res = dp[i];
        }
        return res;

    }
}
