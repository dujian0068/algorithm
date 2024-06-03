package com.bmilk.algorithm.array;

public class LC1103_DistributeCandies {
    public int[] distributeCandies(int candies, int num_people) {
        int[] result = new int[num_people];
        int i =0;
        int c = 1;
        while (candies > 0){
            if(c > candies){
                result[i] += candies;
            }else {
                result[i] += c;
            }
            candies -=c;
            c++;
            i = (i+1)%num_people;
        }
        return result;
    }
}
