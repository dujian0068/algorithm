package com.bmilk.algorithm.greedy;

import java.util.Arrays;

public class LC881_NumRescueBoats {
    public int numRescueBoats(int[] people, int limit) {
        Arrays.sort(people);
        int result = 0;
        int left = 0;
        int right = people.length-1;
        while (left <= right){
            if(people[right] + people[left] > limit){
                right --;
            }else if(people[right] + people[left] <= limit){
                right--;
                left++;
            }
            result++;
        }
        return result;
    }
}
