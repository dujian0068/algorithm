package com.bmilk.algorithm.string;

import java.util.List;

public class LC2844_MinimumOperations {
    public static void main(String[] args) {
        LC2844_MinimumOperations o = new LC2844_MinimumOperations();
        int i = o.minimumOperations("2245047");
        System.out.println(i);
    }
    public int minimumOperations(String num) {
        int res = num.length();
        int zL = Integer.MAX_VALUE;
        int fL = Integer.MAX_VALUE;
        for (int i = num.length()-1; i>=0; i--){
            if (num.charAt(i) == '0'){
                if(zL == Integer.MAX_VALUE){
                    zL = i;
                }else {
                    res = Math.min(res, num.length() -  i -2);
                    zL = i;
                }
            }else if (num.charAt(i) == '5'){
                fL = i;
                if(zL != Integer.MAX_VALUE){
                    res = Math.min(res, num.length() -  i -2);
                }
            }else if((num.charAt(i) == '2' || num.charAt(i) == '7') && fL != Integer.MAX_VALUE){
                res = Math.min(res, num.length() -  i -2);
            }
        }
        if(res == num.length() && zL != Integer.MAX_VALUE){
            res = num.length()-1;
        }

        return res;

    }
}
