package com.bmilk.algorithm.dfs;

import java.util.ArrayList;
import java.util.List;

public class LC93_RestoreIpAddresses {

    int len;
    List<String> result = new ArrayList<>();

    public static void main(String[] args) {
        LC93_RestoreIpAddresses o = new LC93_RestoreIpAddresses();
        List<String> strings = o.restoreIpAddresses("101023");
        System.out.println(strings);
    }


    public List<String> restoreIpAddresses(String s) {
        len = s.length();
        dfs(s, new StringBuilder(), 0, 0, true);
        return result;

    }

    public void dfs(String s,StringBuilder builder, int start, int count, boolean first){
        if( count >3 ||(count == 3 && len -start >3)){
            return;
        }

        if( start == len && count == 3){
            result.add(builder.toString());
        }

        if(!first){
            builder.append(".");
            count++;
        }
        int sL = builder.length();
        for (int i = start; i<start + 3 && i<len;i++){
            String subStr = s.substring(start, i+1);
            if(check(subStr)){
                builder.append(subStr);
                dfs(s, builder, i+1, count, false);
                builder.delete(sL, builder.length());
            }
        }
        if(!first){
            builder.delete(sL-1, builder.length());
        }
    }




    private boolean check(String s){
        if("0".equals(s)) return true;
        if(s.startsWith("0")) return false;

        int num = Integer.parseInt(s);
        return num <= 255 && num>=0;
    }
}
