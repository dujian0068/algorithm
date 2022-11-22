package com.bmilk.algorithm.array;

public class LC5_LongestPalindrome  {
    public static void main(String[] args) {

    }

    public String longestPalindrome(String s) {
        if(s.length()<2) return s;

        String res = "";

        for (int i =0; i<s.length(); i++){
            String tmp1 = help(s, i, i);
            String tmp2 = help(s, i, i+1);
            String tmp = tmp1.length()>tmp2.length()?tmp1:tmp2;
            res = res.length()>tmp.length()?res:tmp;
        }
        return res;
    }

    public String help(String s, int left , int right){
        while (left>=0 && right<s.length()){
            if(s.charAt(left)  == s.charAt(right)){
                left--;
                right++;
            }else {
                break;
            }
        }
        return s.substring(left+1, right);
    }
}
