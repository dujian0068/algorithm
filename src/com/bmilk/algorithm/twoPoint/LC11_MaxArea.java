package com.bmilk.algorithm.twoPoint;

public class LC11_MaxArea {
    public static void main(String[] args) {

    }

    public int maxArea(int[] height) {

        int max = 0;

        int left =0;
        int right = height.length-1;

        while (left<right){

            max = Math.max( (right-left) * Math.min(height[left], height[right]), max);

            if(height[left]> height[right]){
                right--;
            }else {
                left ++;
            }
        }
        return max;
    }
}
