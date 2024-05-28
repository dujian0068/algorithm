package com.bmilk.algorithm.bfs;

import java.util.*;

public class LC17_LetterCombinations {

    public static void main(String[] args) {
        LC17_LetterCombinations o = new LC17_LetterCombinations();
        List<String> strings = o.letterCombinations("");
        System.out.println(strings);
    }

    private static Map<Character, String> numMap = new HashMap<>();
    static {
        numMap.put('2', "abc");
        numMap.put('3', "def");
        numMap.put('4', "ghi");
        numMap.put('5', "jkl");
        numMap.put('6', "mno");
        numMap.put('7', "pqrs");
        numMap.put('8', "tuv");
        numMap.put('9', "wxyz");
    }

    public List<String> letterCombinations(String digits) {
        if(null == digits || digits.length() ==0 ){
            return new ArrayList<>();
        }
        Queue<String> queue = new LinkedList<>();
        queue.add("");
        for (char c : digits.toCharArray()){
            int len = queue.size();
            for (int i = 0 ; i<len; i++){
                String poll = queue.poll();
                for (char c1 : numMap.get(c).toCharArray()){
                    queue.add(poll + c1);
                }
            }
        }
        return new ArrayList<>(queue);
    }
}
