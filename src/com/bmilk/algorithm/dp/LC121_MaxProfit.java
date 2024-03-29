package com.bmilk.algorithm.dp;

public class LC121_MaxProfit {
    public static void main(String[] args) {
        LC121_MaxProfit o = new LC121_MaxProfit();
        int[] prices = {7,1,5,3,6,4};
        int i = o.maxProfit(prices);
        System.out.println(i);
    }

    public int maxProfit(int[] prices) {

        int result = 0;
        int min = prices[0];
        for (int i = 1; i<prices.length; i++){
            result = Math.max(result, prices[i]-min);
            min = Math.min(min, prices[i]);
        }
        return  result;

    }
}
