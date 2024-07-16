package com.bmilk.algorithm.string;

public class LC2710_RemoveTrailingZeros {
    public String removeTrailingZeros(String num) {

        int i = num.length()-1;
        while (i >= 0) {
            if(num.charAt(i) != '0'){
                return num.substring(0, i+1);
            }
            i--;
        }

        return "";
    }
}
