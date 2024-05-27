package com.bmilk.algorithm.dfs;

import javax.swing.*;
import java.util.Arrays;
import java.util.List;

public class LC2028_MissingRolls {

    public static void main(String[] args) {
        LC2028_MissingRolls o = new LC2028_MissingRolls();
        int[] ints = o.missingRolls(new int[]{1,5,6}, 3, 4);
        System.out.println(Arrays.toString(ints));
    }


    public int[] missingRolls(int[] rolls, int mean, int n) {
        int[] result = new int[n];
        int ex = 0;
        for (int num : rolls) {
            ex += num;
        }

        int num  = mean * (rolls.length + n) -ex;

        if( num > 6 * n || num < n){
            return new int[0];
        }
        mean = num /n;
        for (int i =0; i< n;i++ ){
            result[i]  = mean;
        }
        for (int i = 0; i<num %n;i++){
            result[i] = result[i]+1;
        }


        return result;
    }

}
