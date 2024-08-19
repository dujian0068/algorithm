package com.bmilk.algorithm.dp;

public class LC3234_NumberOfSubstrings {
    public static void main(String[] args) {
        LC3234_NumberOfSubstrings o = new LC3234_NumberOfSubstrings();
        int i = o.numberOfSubstrings("101101");
        System.out.println(i);
    }
    public int numberOfSubstrings(String s) {
        int res = 0;
        int len = s.length();
        int maxLen0 = (int)Math.sqrt(len);
        for (int i = 0; i < len; i++){
            int len0 =0;
            int len1 = 0;
            for (int j = i; j< len; j++){
                if(s.charAt(j) == '0'){
                    len0++;
                }else {
                    len1++;
                }
                if(len0 > maxLen0){
                    break;
                }
                if(len0 * len0 <= len1){
                    res++;
                }
            }
        }
        return res;
    }
}
