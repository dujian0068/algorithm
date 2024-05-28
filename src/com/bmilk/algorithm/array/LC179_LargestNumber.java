package com.bmilk.algorithm.array;

import java.util.*;
import java.util.stream.Collectors;

public class LC179_LargestNumber {
    public static void main(String[] args) {
        int[] nums = {3,30,34,5,9};
        LC179_LargestNumber o = new LC179_LargestNumber();
        String s = o.largestNumber(nums);
        System.out.println(s);
    }

    public String largestNumber(int[] nums) {
        Integer[] arr = new Integer[nums.length];
        for (int i = 0; i< nums.length; i++){
            arr[i] = nums[i];
        }
        Arrays.sort(arr, (x, y)->{
            int sx = 10;
            int sy = 10;
            while (sx <= x){
                sx *= 10;
            }
            while (sy <= y){
                sy*=10;
            }
            return y * sx + x - x*sy-y;
        });
        if(arr[0] == 0){
            return "0";
        }

        StringBuilder sb = new StringBuilder();
        for (Integer num : arr){
            sb.append(num);
        }
        return sb.toString();
    }

}
