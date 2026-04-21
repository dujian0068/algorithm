package cn.bmilk.hot100;

import java.util.*;

public class Hot_groupAnagrams {

    public static void main(String[] args) {
        Hot_groupAnagrams h = new Hot_groupAnagrams();
        List<List<String>> lists = h.groupAnagrams(new String[]{"eat", "tea", "tan", "ate", "nat", "bat"});




    }

    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();

        for (String str : strs) {

            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String key = new String(chars);

            map.computeIfAbsent(key, k ->new ArrayList<>()).add(str);
        }
        List<List<String>> res = new ArrayList<>();
        for (String key : map.keySet()) {
            res.add(new ArrayList<>(map.get(key)));
        }
        return res;
    }

}
