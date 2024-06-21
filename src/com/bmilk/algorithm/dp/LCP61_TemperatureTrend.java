package com.bmilk.algorithm.dp;

public class LCP61_TemperatureTrend {

    public int temperatureTrend(int[] temperatureA, int[] temperatureB) {
        int res = 0;
        int yesterday = 0;
         for (int i = 1; i< temperatureA.length; i++){
             if(temperatureA[i] > temperatureA[i-1] && temperatureB[i]> temperatureB[i-1]){
                 yesterday +=1;
             }else if(temperatureA[i] == temperatureA[i-1] && temperatureB[i]== temperatureB[i-1]){
                 yesterday +=1;
             }else if(temperatureA[i] < temperatureA[i-1] && temperatureB[i]< temperatureB[i-1]){
                 yesterday += 1;
             }else {
                 yesterday = 0;
             }
             res = Math.max(res, yesterday);
         }
         return res;
    }
}
