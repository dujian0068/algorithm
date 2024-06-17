package com.bmilk.algorithm.string;

public class LC521_FindLUSlength {
    public int findLUSlength(String a, String b) {
        return a.equals(b)? -1: Math.max(a.length(), b.length());
    }
}