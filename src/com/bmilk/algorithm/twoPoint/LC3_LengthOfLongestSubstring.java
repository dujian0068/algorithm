package com.bmilk.algorithm.twoPoint;

import java.util.HashSet;
import java.util.Set;

public class LC3_LengthOfLongestSubstring {

    public static void main(String[] args) {
        LC3_LengthOfLongestSubstring o = new LC3_LengthOfLongestSubstring();
        int aaaaa = o.lengthOfLongestSubstring("abcabcbb");
        System.out.println(aaaaa);
    }

    public int lengthOfLongestSubstring(String s) {
        if(null == s || s.length()==0){
            return 0;
        }
        int result = 0;
        int quick = 0 ;
        int slow = 0;
        Set<Character> charSet = new HashSet<>();
        for (;quick<s.length(); quick++){

            while (charSet.contains(s.charAt(quick))){
                charSet.remove(s.charAt(slow++));
            }
            charSet.add(s.charAt(quick));
            result = Math.max(quick - slow + 1, result);
        }
        return result;
    }
}
