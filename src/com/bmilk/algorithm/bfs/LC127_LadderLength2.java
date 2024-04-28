package com.bmilk.algorithm.bfs;

import java.util.*;

public class LC127_LadderLength2 {

    public static void main(String[] args) {

        LC127_LadderLength2 o = new LC127_LadderLength2();
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

    private Map<String, List<String>> wordIdListMap = new HashMap<>();
    private Map<String, Set<String>> wordIdSetMap = new HashMap<>();


    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Map<String,Integer> wordMap = new HashMap<>();
        for (String word : wordList){
            wordMap.put(word, Integer.MAX_VALUE);
            buildWordIdList(word);
        }
        wordMap.put(beginWord, Integer.MAX_VALUE);
        buildWordIdList(beginWord);
        if(!wordMap.containsKey(endWord)) return 0;

        Queue<String> queue = new LinkedList<>();
        queue.add(beginWord);
        int count = 1;
        while (!queue.isEmpty()){
            int len = queue.size();
            count++;
            for (int i =0; i<len; i++){
                String poll = queue.poll();
                List<String> wordIdList = wordIdListMap.get(poll);
                for (String wordId : wordIdList){
                    Set<String> wordSet = wordIdSetMap.get(wordId);{
                        for (String word: wordSet){
                            if(!word.equals(poll) && wordMap.get(word) > count){
                                wordMap.put(word, count);
                                queue.add(word);
                            }
                        }
                    }

                }
            }

        }

        if(wordMap.get(endWord) == Integer.MAX_VALUE) return 0;
        return wordMap.get(endWord);

    }


    private void buildWordIdList(String word){
        List<String> wordIdList = new ArrayList<>();

        char[] chars = word.toCharArray();
        for (int i =0; i<chars.length; i++){
            char tmp = chars[i];
            chars[i] = '*';
            wordIdList.add(Arrays.toString(chars));
            Set<String> wordSet = wordIdSetMap.computeIfAbsent(Arrays.toString(chars), k -> new HashSet<>());
            wordSet.add(word);
            chars[i] = tmp;
        }
        wordIdListMap.put(word,wordIdList);
    }

}
