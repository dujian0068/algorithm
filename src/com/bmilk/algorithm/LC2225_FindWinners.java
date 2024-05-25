package com.bmilk.algorithm;

import java.util.*;

public class LC2225_FindWinners {
    public List<List<Integer>> findWinners(int[][] matches) {
        Set<Integer> loserOneSet = new HashSet<>();
        Set<Integer> loser = new HashSet<>();

        for (int[] match : matches){
            if(!loser.contains(match[1])){
                loserOneSet.add(match[1]);
                loser.add(match[1]);
            }else {
                loserOneSet.remove(match[1]);
            }
        }
        List<List<Integer>> result = new ArrayList<>();

        Set<Integer> winSet = new HashSet<>();
        for (int[] match : matches){
            if(!loser.contains(match[0])){
                winSet.add(match[0]);
            }
        }
        List<Integer> win = new ArrayList<>(winSet);
        win.sort((Comparator.comparingInt(o -> o)));
        List<Integer> loserOne = new ArrayList<>(loserOneSet);
        loserOne.sort((Comparator.comparingInt(o -> o)));
        result.add(win);
        result.add(loserOne);
        return result;
    }

}
