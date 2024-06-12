package com.bmilk.algorithm;

public class LC2806_AccountBalanceAfterPurchase {
    public int accountBalanceAfterPurchase(int purchaseAmount) {
        int low =  purchaseAmount % 10;
        if(low >= 5){
            purchaseAmount += (10-low);
        }else {
            purchaseAmount -=low;
        }
        return 100-purchaseAmount;

    }
}
