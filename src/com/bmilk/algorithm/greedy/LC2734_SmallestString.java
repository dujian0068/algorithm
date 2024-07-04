package com.bmilk.algorithm.greedy;

public class LC2734_SmallestString {
    public static void main(String[] args) {
        LC2734_SmallestString o = new LC2734_SmallestString();
        String aaaaaaaaa = o.smallestString("cbabc");
        System.out.println(aaaaaaaaa);
    }
    public String smallestString(String s) {
        StringBuilder result = new StringBuilder();
        int i = 0;
        while (i < s.length() && s.charAt(i) == 'a'){
            result.append('a');
            i++;
        }
        if(s.length() == result.length()){
            result.deleteCharAt(result.length()-1);
            result.append('z');
            return result.toString();
        }
        while (i < s.length() && s.charAt(i) != 'a'){
            result.append((char)(s.charAt(i)-1));
            i++;
        }
        result.append(s.substring(i));
        return result.toString();

    }
}
