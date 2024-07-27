package com.bmilk.algorithm.greedy;

import java.util.Arrays;

public class LC3106_GetSmallestString {
    public String getSmallestString(String s, int k) {
        char[] res = s.toCharArray();
        for (int i = 0; i< s.length(); i++){
            int dis = Math.min(s.charAt(i) - 'a', 'z' - s.charAt(i) +1);
            if(dis <= k){
                res[i] = 'a';
                k -= dis;
            }else {
                res[i] -= k;
                break;
            }
        }
        return new String(res);

    }
}
