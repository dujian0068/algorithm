package com.bmilk.algorithm.dfs;

import java.util.ArrayList;
import java.util.List;

public class LC22_GenerateParenthesis {
    public static void main(String[] args) {
        LC22_GenerateParenthesis service = new LC22_GenerateParenthesis();
        List<String> strings = service.generateParenthesis(2);
        System.out.println(strings);
    }


    public List<String> generateParenthesis(int n) {
        if(n ==0) return new ArrayList<>();
        List<String> res = new ArrayList<>();
        dfs(0, 0, new char[2 * n],n, res);
        return res;
    }

    public void dfs(int left, int right, char[]chars, int n, List<String> res){
        if(right > left || left>n || right>n){
            return;
        }
        if(left == right  && left == n){
            res.add(new String(chars));
            return;
        }
        chars[left + right] = '(';
        dfs(left+1, right, chars, n, res);
        chars[left + right] = ')';
        dfs(left, right+1, chars, n, res);
    }
}
