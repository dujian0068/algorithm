package com.bmilk.algorithm.array;
public class BM73_LongestPalindrome {
    public static void main(String[] args) {

    }

    public int getLongestPalindrome(String s) {

        if(s.length()<2) return s.length();
        int res = 0;

        for (int i = 0; i<s.length(); i++){
            int tmp1 = help(s, i, i);
            int tmp2 = help(s, i, i+1);
            int tmp = Math.max(tmp2, tmp1);
            res = Math.max(tmp, res);
        }
        return res;
    }

    public int help(String s, int left, int right){
        while (left>=0 && right< s.length()){
            if(s.charAt(left) == s.charAt(right)){
                left--;
                right++;
            }else {
                break;
            }
        }
        return right-left+1 -2;
    }
}
