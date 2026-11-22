package cn.bmilk.hot100;

import java.util.HashSet;
import java.util.Set;

public class Hot8_LengthOfLongestSubstring {
    public int lengthOfLongestSubstring(String s) {
        int  res = 0;
        int left =0, right= 0;
        Set<Character> set = new HashSet<>();
        while (left <= right && right<s.length()){
            if(set.contains(s.charAt(right))) {
                while (s.charAt(left) != s.charAt(right)) {
                    set.remove(s.charAt(left++));
                }
                res = Math.max(res, set.size());
                left++;
                right++;
            }else {
                set.add(s.charAt(right++));
                res = Math.max(res, set.size());
            }
        }
        return res;
    }
}
