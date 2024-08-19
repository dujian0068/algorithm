package com.bmilk.algorithm;

import java.util.List;

public class LC676_MagicDictionary {
    private String[] dictionary;
    public LC676_MagicDictionary() {

    }

    public void buildDict(String[] dictionary) {
        this.dictionary = dictionary;
    }

    public boolean search(String searchWord) {
        for (String word : dictionary){
            if(word.length() != searchWord.length()) continue;
            int dif = 0;
            for (int i = 0; i< searchWord.length(); i++){
                if(word.charAt(i) != searchWord.charAt(i)){
                    dif++;
                    if(dif > 1){
                        break;
                    }
                }
            }
            if(dif ==1){
                return true;
            }
        }
        return false;
    }
}
