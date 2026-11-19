package cn.bmilk.hot100;

import javax.swing.*;
import java.util.*;
import java.util.stream.IntStream;

public class Hot2_GroupAnagrams {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> tmp  = new HashMap<>();
        for (String str: strs){
            char[] charArray = str.toCharArray();
            Arrays.sort(charArray);
            String string = new String(charArray);
            tmp.computeIfAbsent(string, k -> new ArrayList<>()).add(str);
        }
        return new ArrayList<>(tmp.values());

    }
}
