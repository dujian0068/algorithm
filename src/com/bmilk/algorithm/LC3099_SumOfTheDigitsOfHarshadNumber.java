package com.bmilk.algorithm;

public class LC3099_SumOfTheDigitsOfHarshadNumber {

    public int sumOfTheDigitsOfHarshadNumber(int x) {
        int tmp = 0;
        int x1 = x;
        while (x1 != 0){
            tmp += x1 %10;
            x1 = x1 /10;
        }
        return x%tmp == 0? tmp:-1;
    }
}
