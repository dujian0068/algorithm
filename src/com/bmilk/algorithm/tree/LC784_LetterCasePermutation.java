package com.bmilk.algorithm.tree;

import java.util.*;
import java.util.stream.Collectors;

public class LC784_LetterCasePermutation {

    public static void main(String[] args) {
        LC784_LetterCasePermutation so = new LC784_LetterCasePermutation();
        List<String> res = so.letterCasePermutation("a1b2");
        System.out.println(res);
    }

    public List<String> letterCasePermutation(String s) {
        char[] chars = s.toCharArray();
        List<String> res = new ArrayList<>();
        letterCasePermutation(chars, 0, res);
        return new ArrayList<>(res);
    }

    public void letterCasePermutation(char[] chars, int index,   List<String> res) {
        if(index == chars.length){
            res.add(new String(chars));
            return ;
        }
        chars[index] = Character.toLowerCase(chars[index]);
        letterCasePermutation(chars, index+1, res);
        if(chars[index]>='A'){
            chars[index] = Character.toUpperCase(chars[index]);
            letterCasePermutation(chars, index+1,  res);
        }
    }


}
