package cn.bmilk.hot100;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Hot9_FindAnagrams {

    public static void main(String[] args) {
        String s = "cbaebabacd";
        String p = "abc";
        Hot9_FindAnagrams hot9FindAnagrams = new Hot9_FindAnagrams();
        List<Integer> anagrams = hot9FindAnagrams.findAnagrams(s, p);
        System.out.println(anagrams.toString());
    }
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> res = new ArrayList<>();

        if(p.length() > s.length() || p.isEmpty()){
            return res;
        }
        if(p.length() == s.length() && p.equals(s)){
            res.add(0);
            return res;
        }
        int left = 0;
        int right = p.length()-1;
        Map<Character, Integer> pMap = buildMap(p);
        Map<Character, Integer> helpMap = buildMap(s.substring(0, p.length()));
        char[] charArray = s.toCharArray();
        while (right < s.length()){
            if(pMap.equals(helpMap)){
                res.add(left);
            }
            right++;
            if(right >= s.length()){
                break;
            }
            Integer i = helpMap.computeIfAbsent(charArray[right], k -> 0);
            helpMap.put(charArray[right], i+1);
            Integer i1 = helpMap.get(charArray[left]);
            if( i1 -1 > 0){
                helpMap.put(charArray[left], i1-1);
            }else {
                helpMap.remove(charArray[left]);
            }
            left++;
        }
        return res;
    }



    public Map<Character, Integer> buildMap(String s){
        Map<Character, Integer> res = new HashMap<>();
        for (Character c : s.toCharArray()){
            Integer i = res.computeIfAbsent(c, k -> 0);
            res.put(c, i+1);
        }
        return res;
    }
}
