package com.bmilk.algorithm.string;

public class LC551_CheckRecord {
    public boolean checkRecord(String s) {
        int A = 0;
        int L = 0;
        for (int i = 0; i< s.length(); i++){
            if(s.charAt(i) == 'A'){
                A++;
            }
            if(s.charAt(i) == 'L'){
                L++;
            }else {
                L =0;
            }
            if( A >= 2 || L >=3){
                return false;
            }

        }
        return true;

    }
}
