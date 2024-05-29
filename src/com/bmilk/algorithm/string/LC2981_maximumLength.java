package com.bmilk.algorithm.string;

import java.util.*;

public class LC2981_maximumLength {
    public static void main(String[] args) {
        LC2981_maximumLength o = new LC2981_maximumLength();
        int aaaa = o.maximumLength2("cccerrrecdcdccedecdcccddeeeddcdcddedccdceeedccecde");
        System.out.println(aaaa);
    }

    public int maximumLength(String s) {
        int result = -1;
        for (int i = 0; i <= s.length() - 3; i++) {
            for (int j = i + 1; j <= s.length() - 2; j++) {
                if (j - i <= result) {
                    continue;
                }
                if (!check(s, i, j)) {
                    continue;
                }
                if (checkTimes(s, s.substring(i, j), 3)) {
                    result = Math.max(result, j - i);
                }

            }
        }
        return result;

    }

    private boolean check(String str, int start, int end) {
        char c = str.charAt(start);
        for (int i = start + 1; i < end; i++) {
            if (str.charAt(i) != c) return false;
        }
        return true;
    }

    private boolean checkTimes(String str1, String str2, int times) {
        int t = 0;
        for (int i = 0; i < str1.length() - str2.length() + 1; i++) {
            if (str1.substring(i, i + str2.length()).equals(str2)) {
                t++;
                if (t >= times) {
                    return true;
                }
            }
        }
        return false;
    }


    public int maximumLength2(String s) {
        Map<Character, LinkedList<Integer>> charMap = new HashMap<>();


        int begin = 0;
        int end = 0;
        while (end < s.length()) {
            while (end < s.length() && s.charAt(begin) == s.charAt(end)) {
                end++;
            }
            charMapPut(s.charAt(begin), end - begin, charMap);
            begin = end;
        }
        int result = searchResult(charMap);
        return result == 0 ? -1 : result;
    }

    private int searchResult(Map<Character, LinkedList<Integer>> charMap) {
        int result = 0;
        for (LinkedList<Integer> list : charMap.values()) {
            result = Math.max(result, list.get(0) - 2);
            if (list.size() >= 2) {
                if (list.get(0) == list.get(1)) {
                    result = Math.max(result, list.get(0) - 1);
                } else {
                    result = Math.max(result, list.get(1));
                }
            }
            if (list.size() == 3) {
                result = Math.max(result, list.get(2));
            }
        }
        return result;
    }

    private void charMapPut(char c, int len, Map<Character, LinkedList<Integer>> charMap) {
        LinkedList<Integer> list = charMap.get(c);
        if (null == list) {
            list = new LinkedList<>();
            list.addLast(len);
            charMap.put(c, list);
            return;
        }
        int ll = list.size();
        for (int i = 0; i <= ll; i++) {
            if (i == ll) {
                list.addLast(len);
                break;
            }
            if (list.get(i) <= len) {
                list.add(i, len);
                break;
            }
        }
        while (list.size() > 3) {
            list.pollLast();
        }
    }
}
