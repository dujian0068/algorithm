package com.bmilk.algorithm.bfs;

import java.util.*;

public class LC127_LadderLength {

    public static void main(String[] args) {

        LC127_LadderLength o = new LC127_LadderLength();
        List<String> wordList = new ArrayList<>();
        wordList.add("hot");
        wordList.add("dot");
        wordList.add("dog");
        wordList.add("lot");
        wordList.add("log");
        wordList.add("cog");

        int i = o.ladderLength("hit", "cog", wordList);
        System.out.println(i);

    }


    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Map<String,Integer> wordMap = new HashMap<>();
        for (String word: wordList){
            wordMap.put(word, Integer.MAX_VALUE);
        }
        wordMap.put(beginWord, 0);
        if(!wordMap.containsKey(endWord)){
            return 0;
        }
        Queue<String> queue = new LinkedList<>();
        queue.add(beginWord);
        int count = 1;
        while (!queue.isEmpty()){
            count ++;
            int len = queue.size();
            for (int i =0; i<len; i++){
                String poll = queue.poll();
                Iterator<String> iterator = wordList.iterator();
                while (iterator.hasNext()){
                    String next = iterator.next();
                    if( check(poll, next)){
                        queue.add(next);
                        Integer integer = wordMap.get(next);
                        wordMap.put(next, Math.min(integer, count));
                        iterator.remove();
                    }
                }
            }
        }
        if(wordMap.get(endWord) == Integer.MAX_VALUE) return 0;
        return wordMap.get(endWord);

    }


    private boolean check(String word1, String word2){
        int count = 0;
        if(word1.length() != word2.length()){
            return false;
        }

        for (int i = 0; i< word1.length(); i++){
            if(word1.charAt(i) != word2.charAt(i)){
                count ++;
                if(count >1){
                    return false;
                }
            }
        }
        return true;

    }

}
