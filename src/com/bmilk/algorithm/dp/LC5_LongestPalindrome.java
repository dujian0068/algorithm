package com.bmilk.algorithm.dp;

public class LC5_LongestPalindrome {
    public static void main(String[] args) {
        String s = "cbbd";
        LC5_LongestPalindrome o = new LC5_LongestPalindrome();
        String s1 = o.longestPalindrome(s);
        System.out.println(s1);
    }


    /**
     * 一维dp
     * @param s
     * @return
     */
    public String longestPalindrome(String s, int a) {
        if( null == s || 0== s.length() || 1==s.length() ){
            return s;
        }
        int len = s.length();
        int[] dp = new int[len];
        dp[0] = 0;
        int max = 0;
        int l = 0;
        for (int i =1; i<len; i++){
            if(dp[i-1] != 0 && s.charAt(i) == s.charAt(dp[i-1]-1)){
                dp[i] = dp[i-1] - 1;
            }else {
                int start = dp[i-1];
                int left = start;
                int right = i;
                boolean tmp = true;
                while (left <= right){
                    if(s.charAt(left) == s.charAt(right)){
                        left++;
                        right--;
                        tmp = true;
                    }else {
                        start++;
                        left = start;
                        right = i;
                        tmp = false;
                    }
                }
                if(tmp){
                    dp[i] = start;
                }
            }
            if((i -dp[i]) > max ){
                max = i-dp[i];
                l = i;
            }
        }
        return s.substring(dp[l], l+1);
    }


    /**
     * 二维dp
     */

    public String longestPalindrome(String s) {
        if( null == s || 0== s.length() || 1==s.length() ){
            return s;
        }
        int len = s.length();
        int left = 0, right = 0;
        int max = 0;
        boolean[][] dp = new boolean[len][len];

        for (int i = 0 ; i< len; i++){
           dp[i][i] = true;
        }

        for (int i = len-1; i>=0; i--){
            for (int j = i+1; j< len; j++){
                if(s.charAt(i) == s.charAt(j) && (dp[i+1][j-1] || j-i == 1)){
                    dp[i][j] = true;
                    if(j -i + 1 > max){
                        max = j-i +1;
                        left = i;
                        right = j;
                    }
                }
            }
        }
        return s.substring(left, right+1);

    }

    }
