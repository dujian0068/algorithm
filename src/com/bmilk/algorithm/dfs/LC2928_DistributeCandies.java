package com.bmilk.algorithm.dfs;

import java.util.List;

public class LC2928_DistributeCandies {
    public static void main(String[] args) {
        LC2928_DistributeCandies o = new LC2928_DistributeCandies();

        int i = o.distributeCandies(5, 2);
        System.out.println(i);
    }

    int result = 0;
    public int distributeCandies(int n, int limit) {
        dfs(n, limit, 0, 0);
        return result;
    }

    private void dfs(int n, int limit, int sum, int ch){
        if(ch == 3 ){
            if(sum == n){
                result++;
            }
            return;
        }
        if(sum>n){
            return;
        }
        for (int i =0; i<=limit; i++){
            dfs(n,limit, sum+i, ch+1);
        }
    }


}
