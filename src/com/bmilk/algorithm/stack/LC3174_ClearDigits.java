package com.bmilk.algorithm.stack;

import java.util.Stack;

public class LC3174_ClearDigits {

    public String clearDigits(String s) {

        StringBuilder res = new StringBuilder();
        for (int i = 0; i< s.length(); i++){
            char c = s.charAt(i);
            if('0'<=c && '9'>= c){
                if(res.length()>0){
                    res.delete(res.length()-1,res.length());
                }
            }else {
                res.append(c);
            }
        }
        return res.toString();

    }
}
