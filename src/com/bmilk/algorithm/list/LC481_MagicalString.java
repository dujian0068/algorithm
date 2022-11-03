package com.bmilk.algorithm.list;

import java.util.ArrayList;
import java.util.List;

public class LC481_MagicalString {
    public static void main(String[] args) {
        LC481_MagicalString lc481_magicalString = new LC481_MagicalString();
        int i = lc481_magicalString.magicalString(7);
        System.out.println(i);
    }

    public int magicalString(int n) {

        char[] chars = new char[n+2];
        chars[0] = '1';
        chars[1] = '2';
        chars[2] = '2';
        char s = '1';
        for (int i=2,j=3;j<n;i++){
            chars[j++] = s;
            if(chars[i] == '2') {
                chars[j++] = s;
            }
            s = '1'== s ? '2':'1';
        }
        int res =0;
        for(int i=0;i<n;i++){
            if(chars[i] == '1'){
                res++;
            }
        }
        return res;


    }
}
