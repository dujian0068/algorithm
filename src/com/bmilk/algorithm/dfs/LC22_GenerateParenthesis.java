package com.bmilk.algorithm.dfs;

import java.util.ArrayList;
import java.util.List;

public class LC22_GenerateParenthesis {
    List<String> result = new ArrayList<>();

    public static void main(String[] args) {
        LC22_GenerateParenthesis o = new LC22_GenerateParenthesis();
        List<String> strings = o.generateParenthesis(1);
        System.out.println(strings.toString());
    }
    public List<String> generateParenthesis(int n) {
        dfs(n, n , new StringBuilder());
        return result;
    }

    public void dfs(int left, int right, StringBuilder sb){
        if(left> right){
            return;
        }
        if(left == 0 && right == 0){
            result.add(sb.toString());
            return;
        }
        if(left == right){
            sb.append("(");
            dfs(left-1, right, sb);
        }else if(left == 0){
            sb.append(")");
            dfs(left, right-1, sb);
        }else {
            sb.append("(");
            dfs(left-1, right, sb);
            sb.delete(sb.length()-1, sb.length());
            sb.append(")");
            dfs(left, right-1, sb);
        }
        sb.delete(sb.length()-1, sb.length());
    }
}
