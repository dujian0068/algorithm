package cn.bmilk.hot100;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Hot_lengthOfLongestSubstring {

    public int lengthOfLongestSubstring(String s) {

        Set<Character> set = new HashSet<>();

        int left = 0;
        int right = 0;
        int res = 0;
        while (right < s.length()) {
            while (right < s.length() && !set.contains(s.charAt(right))) {
                set.add(s.charAt(right++));
            }
            res = Math.max(res, right - left);
            set.remove(s.charAt(left++));
        }
        return Math.max(res, right - left);

    }
}
