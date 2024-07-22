package com.bmilk.algorithm.prefixsum;

public class LC3096_MinimumLevels {
    public int minimumLevels(int[] possible) {
        int aliceScore = possible[0] == 0 ? -1 : 1;
        int bobScore = 0;
        for (int i = 1; i< possible.length; i++){
            if(possible[i] == 0){
                bobScore -= 1;
            }else {
                bobScore += 1;
            }
        }
        if(aliceScore > bobScore){
            return 1;
        }
        for ( int i = 1; i< possible.length-1; i++){
            if(possible[i] == 0){
                bobScore += 1;
                aliceScore -=1;
            }else {
                bobScore -= 1;
                aliceScore +=1;
            }
            if (aliceScore > bobScore){
                return i+1;
            }
        }
        return -1;
    }
}
