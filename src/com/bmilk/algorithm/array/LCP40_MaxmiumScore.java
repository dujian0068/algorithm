package com.bmilk.algorithm.array;

import java.util.Arrays;

public class LCP40_MaxmiumScore {
    public static void main(String[] args) {
        LCP40_MaxmiumScore o = new LCP40_MaxmiumScore();
        int i = o.maxmiumScore(new int[]{3,3,3}, 1);
        System.out.println(i);
    }
    public int maxmiumScore(int[] cards, int cnt) {
        int score = 0;
        int l1 = -1;
        int l2 = -1;
        Arrays.sort(cards);

        int i = cards.length-1;
        for (int j = 0; i >=0 && j< cnt; j++, i--){
            score+= cards[i];
            if(cards[i] % 2 == 0){
                l2 = i;
            }else {
                l1 = i;
            }
        }
        if(score % 2== 0) return score;

        int next1 = -1;
        int next2 = -1;
        while ( i >=0 && (next2==-1 || next1==-1)){
            if(next1 == -1 && cards[i] %2 == 1){
                next1 = i;
            }
            if(next2 == -1 && cards[i] %2 == 0){
                next2 = i;
            }
            i--;
        }
//        if(next1 == -1 && next2 == -1){
//            return 0;
//        }
//        if(next2 == -1 && l2 == -1){
//            return 0;
//        }
//        if(next2 != -1 && l2 == -1){
//            return score - cards[l1] + cards[next2];
//        }
//        if(next2 == -1){
//           return score - cards[l2] + cards[next1];
//        }
//        if(cards[next1] + cards[l1] >= cards[next2] + cards[l2]){
//            return score - cards[l2] + cards[next1];
//        }
//        return score - cards[l1] + cards[next2];
        int score2 = score;
        if(next2 != -1){
            score = score - cards[l1] + cards[next2];
        }
        if(l2 != -1 && next1 != -1){
            score2 = score2 - cards[l2] + cards[next1];
        }
        if(score2 % 2 == 0 && 0 == score % 2 ){
            return Math.max(score2, score);
        }
        if(score2 % 2 == 0){
            return score2;
        }
        if(score %2 == 0){
            return  score;
        }
        return 0;
    }
}
