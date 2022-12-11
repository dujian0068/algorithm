package com.bmilk.algorithm.string;

import com.sun.deploy.util.StringUtils;

public class LC165_CompareVersion {
    public static void main(String[] args) {
        String version1 = "1.0", version2 = "1.0.0";

        LC165_CompareVersion service = new LC165_CompareVersion();
        int i = service.compareVersion(version1, version2);
        System.out.println(i);
    }

    public int compareVersion(String version1, String version2) {
        String[] v1 = version1.split("\\.");
        String[] v2 = version2.split("\\.");

        int l1 = v1.length;
        int l2= v2.length;
        int max = Math.max(l1, l2);
        for (int i =0; i<max; i++){
            String s1 = null;
            String s2 = null;
            if(i<l1) s1 = v1[i];
            if(i<l2) s2 = v2[i];
            int compareString = compareString(s1, s2);
            if( compareString != 0) return compareString;
        }
        return 0;
    }

    public int compareString(String str1, String str2){
        int i1 = 0;
        int i2 = 0;
        if (str1 != null) i1 = Integer.parseInt(str1);
        if (str2 != null) i2 = Integer.parseInt(str2);
        return Integer.compare(i1, i2);
    }
}
