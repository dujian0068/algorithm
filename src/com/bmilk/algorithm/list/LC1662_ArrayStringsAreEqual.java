package com.bmilk.algorithm.list;

import java.util.Arrays;

public class LC1662_ArrayStringsAreEqual {
    public static void main(String[] args) {
        LC1662_ArrayStringsAreEqual service = new LC1662_ArrayStringsAreEqual();
        String[] word1 = {"ab","c"};
        String[] word2 = {"a", "bc"};
        boolean b = service.arrayStringsAreEqual(word1, word2);
        System.out.println(b);
    }

    public boolean arrayStringsAreEqual(String[] word1, String[] word2) {
        int p1 =0 ,p2=0, i1=0, i2=0;
        while (p1<word1.length && p2< word2.length){

            if(word1[p1].charAt(i1) != word2[p2].charAt(i2)) return false;
            i1++;
            i2++;
            if(i1 == word1[p1].length()){
                i1=0;
                p1++;
            }
            if(i2 == word2[p2].length()){
                i2=0;
                p2++;
            }
        }
        return p1 == word1.length && p2 == word2.length ;
    }
}
