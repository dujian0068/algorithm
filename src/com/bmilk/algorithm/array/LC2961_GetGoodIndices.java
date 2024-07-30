package com.bmilk.algorithm.array;

import sun.rmi.runtime.Log;

import java.util.ArrayList;
import java.util.List;

public class LC2961_GetGoodIndices {
    public static void main(String[] args) {
        LC2961_GetGoodIndices o = new LC2961_GetGoodIndices();
        int[][] va = {{10,1,10,9}};
        List<Integer> goodIndices = o.getGoodIndices(va, 1);
        System.out.println(goodIndices);
    }

    public List<Integer> getGoodIndices(int[][] variables, int target) {
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i< variables.length; i++){
            if(check(variables[i], target)){
                res.add(i);
            }
        }
        return  res;
    }

    private boolean check(int[] nums, int target){
        int a = nums[0];
        int b = nums[1];
        int c = nums[2];
        int m = nums[3];
        return powMod(powMod( a, b, 10), c, m) % m == target;

    }

    private int powMod(int num1, int num2, int mod){
        if(num2 == 1) return num1 % 10;
        int tmp = 1;
        if(num2 %2 == 1) {
            tmp = num1;
            num2 -= 1;
        }

        int ic = powMod(num1, num2/2, mod);
        return ic * ic * tmp % mod;
    }
}
