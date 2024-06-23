package com.bmilk.algorithm.string;

import javax.swing.*;

public class LC520_DetectCapitalUse {

    public static void main(String[] args) {
        LC520_DetectCapitalUse o = new LC520_DetectCapitalUse();
        boolean ffffffffffffffffffffF = o.detectCapitalUse("ffffffffffffffffffffF");
        System.out.println(ffffffffffffffffffffF);
    }
    public boolean detectCapitalUse(String word) {
        return allUP(word) || firstUpOrNoUp(word);
    }

    private boolean allUP(String word){
        if(null == word || word.isEmpty()){
            return true;
        }
        for (int i =0; i<word.length(); i++){
            if(word.charAt(i) < 'A' || word.charAt(i) > 'Z' ){
                return false;
            }
        }
        return true;
    }

    private boolean firstUpOrNoUp(String word){
        if(null == word || word.isEmpty()){
            return true;
        }
        for (int i = 1; i<word.length();i++){
            if(word.charAt(i) < 'a' || word.charAt(i) >'z'){
                return false;
            }
        }
        return true;
    }
}
