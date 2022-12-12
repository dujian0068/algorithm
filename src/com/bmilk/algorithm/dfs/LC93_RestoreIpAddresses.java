package com.bmilk.algorithm.dfs;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class LC93_RestoreIpAddresses {
    public static void main(String[] args) {

        LC93_RestoreIpAddresses service = new LC93_RestoreIpAddresses();
        List<String> strings = service.restoreIpAddresses("101023");
        System.out.println(strings);
    }

    public List<String> restoreIpAddresses(String s) {
        if(s.length() <4 || s.length()>12) return new ArrayList<>();
        List<String> res = new ArrayList();
        Stack<String> tmp = new Stack<>();
        dfs(res, tmp, 0, s);
        return res;
    }

    public void dfs(List<String> res, Stack<String> tmp, int start, String s){
        if(tmp.size()>4 && start != s.length()){
            return;
        }

        if(tmp.size() == 4 && start == s.length()){
            String buildString = buildString(tmp);
            res.add(buildString);
            return;
        }

        for (int i =start ;i<s.length();i++){
            String substring = s.substring(start, i + 1);
            if(substring.length() > 1 && substring.startsWith("0")){
                return;
            }
            if(Integer.parseInt(substring) > 255){
                return;
            }
            tmp.push(substring);

            dfs(res, tmp, i+1, s);
            tmp.pop();
        }

    }

    private String buildString(Stack<String> stringStack){
        List<String> strings = new ArrayList<>(stringStack);
        StringBuilder sb = new StringBuilder();
        for (int i =0; i< 4;i++){
            sb.append(strings.get(i));
            if(i<3){
                sb.append(".");
            }
        }
        return sb.toString();
    }
}
