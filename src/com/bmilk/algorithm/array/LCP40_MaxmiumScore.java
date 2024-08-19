package com.bmilk.algorithm.array;

import java.util.Arrays;

public class LCP40_MaxmiumScore {
    public static void main(String[] args) {
        int[] cards = {3,3,1};
        LCP40_MaxmiumScore o = new LCP40_MaxmiumScore();
        int i = o.maxmiumScore(cards, 1);
        System.out.println(i);
    }
    public int maxmiumScore(int[] cards, int cnt) {
        Arrays.sort(cards);
        int l1 = cards.length;
        int l2 = cards.length;
        int score = 0;
       int i = cards.length-1;
        for (int j = 0 ;i >= 0 && j< cnt; i--, j++){
            score += cards[i];
            if(cards[i] % 2 == 1){
                l1 = i;
            }else {
                l2 = i;
            }
        }
        if(score % 2==0){
            return score;
        }
        if(i == -1){
            return 0;
        }
        int next1 = Integer.MIN_VALUE;
        int next2 = Integer.MIN_VALUE;
        while (i>=0 && (next1  == Integer.MIN_VALUE || next2 == Integer.MIN_VALUE)){
            if(cards[i] % 2 == 1 && next1  == Integer.MIN_VALUE){
                next1 = i;
            }else if(cards[i] % 2 == 0 && next2  == Integer.MIN_VALUE){
                next2 = i;
            }
            i--;
        }
        if(next1  == Integer.MIN_VALUE && next2 == Integer.MIN_VALUE){
            return 0;
        }
        if(next1 == Integer.MIN_VALUE){
            return score - cards[l1] + cards[next2];
        }
        if(next2 == Integer.MIN_VALUE){
            return score - cards[l2] + cards[next1];
        }
        if(cards[l1] + cards[next1] > cards[l2] + cards[next2]){
            return score - cards[l2] + cards[next1];
        }
        return score - cards[l1] + cards[next2];
    }
}
