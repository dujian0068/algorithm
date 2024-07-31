package com.bmilk.algorithm.array;

import javax.swing.*;

public class LC3233_NonSpecialCount {
    public static void main(String[] args) {
        LC3233_NonSpecialCount o = new LC3233_NonSpecialCount();
        int i = o.nonSpecialCount(4, 16);
        System.out.println(i);
    }
    public int nonSpecialCount(int l, int r) {
        int max = (int)Math.sqrt(r);
        int min = (int)Math.sqrt(l);
        int[] record = new int[max+1];
        for (int i = 2; i<= max; i++){
            for (int j = i; j<= max/i; j++){
                record[i*j] = -1;
            }
        }
        int res = r-l+1;
        for (int i = Math.max(min, 2); i< max+1; i++){
            if(record[i] == 0){
                int num = i * i;
                if(num >= l && num <= r){
                    res--;
                }
            }
        }
        return res;
    }
}
