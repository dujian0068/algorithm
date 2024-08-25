package com.bmilk.algorithm.bit;

public class LC3133_MinEnd {
    public long minEnd(int n, int x) {
        n--;
        long ans = x;
        int i =0;
        int j =0;
        while ((n>>j)>0){
            if((ans>> i & 1)==0){
                ans |= (long)(n>>j & 1)<<i;
                j++;
            }
            i++;
        }
        return ans;
    }
}
