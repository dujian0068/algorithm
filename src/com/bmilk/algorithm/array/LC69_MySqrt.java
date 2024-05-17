package com.bmilk.algorithm.array;

public class LC69_MySqrt {
    public static void main(String[] args) {
        LC69_MySqrt o = new LC69_MySqrt();
        int i = o.mySqrt(1);
        System.out.println(i);
    }


    public int mySqrt(int x) {

        int left = 0;
        int right = x;
        int mid = (right-left)/2 + left;
        while ( true){
            if( (long)mid * mid <=x && (long)(mid+1)*(mid+1) > x){
                return mid;
            }
            if((long)mid * mid > x){
                right = mid -1;
                mid = (right-left)/2 + left;
            }else if(mid * mid <x){
                left = mid+1;
                mid = (right-left)/2 + left;
            }
        }
    }
}
