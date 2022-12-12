package com.bmilk.algorithm.window;

import java.util.HashSet;
import java.util.Set;

public class LC3_LengthOfLongestSubstring {

    public static void main(String[] args) {
        LC3_LengthOfLongestSubstring service = new LC3_LengthOfLongestSubstring();
        int abcabcbb = service.lengthOfLongestSubstring("bbbbb");
        System.out.println(abcabcbb);

    }

    public int lengthOfLongestSubstring(String s) {
        Set<Character> set = new HashSet<>();

        int left = 0;
        int right = 0;
        int res = 0;
        while (right < s.length()){
            while (set.contains(s.charAt(right))){
                set.remove(s.charAt(left++ ));
            }
            set.add(s.charAt(right++));
            res = Math.max(set.size(), res);
        }
        return  res;
    }
}
