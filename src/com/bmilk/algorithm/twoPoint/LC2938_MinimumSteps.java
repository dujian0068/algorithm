package com.bmilk.algorithm.twoPoint;

public class LC2938_MinimumSteps {

    public long minimumSteps(String s) {
        if(null == s || s.length() <=1){
            return 0;
        }
        int left = 0;
        int right = s.length()-1;
        long result = 0;
        while (left < right){
            while (left< right && s.charAt(left) == '0'){
                left ++;
            }
            while (left< right && s.charAt(right) == '1'){
                right--;
            }
            result += (right-left);
            right--;
            left++;
        }
        return result;
    }


}
