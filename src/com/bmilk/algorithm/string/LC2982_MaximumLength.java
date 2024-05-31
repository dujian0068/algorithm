package com.bmilk.algorithm.string;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class LC2982_MaximumLength {

    public int maximumLength(String s) {
        int slow = 0;
        int quick = 0;
        Map<Character, LinkedList<Integer>> numMap = new HashMap<>();
        while (quick < s.length()) {
            while (quick < s.length() && s.charAt(slow) == s.charAt(quick)){
                quick++;
            }
            buildMap(numMap, s.charAt(slow), quick-slow);
            slow = quick;
        }
        return searchResult(numMap);
    }

    public int searchResult(Map<Character, LinkedList<Integer>> numMap) {
        int result = 0;
        for (LinkedList<Integer> list : numMap.values()) {
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
        return 0 == result ? -1 : result;
    }

    private void buildMap(Map<Character, LinkedList<Integer>> numMap, char c, int len) {
        LinkedList<Integer> list = numMap.get(c);
        if (list == null) {
            list = new LinkedList<>();
            list.add(len);
            numMap.put(c, list);
            return;
        }

        int listSize = list.size();
        for (int i = 0; i < listSize; i++) {
            if (len >= list.get(i)) {
                list.add(i, len);
                break;
            }
        }
        if (list.size() == listSize && listSize < 3) {
            list.addLast(len);
        }
        while (list.size() > 3) {
            list.pollLast();
        }
    }
}
