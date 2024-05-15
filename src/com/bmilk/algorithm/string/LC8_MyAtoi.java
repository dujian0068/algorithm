package com.bmilk.algorithm.string;

public class LC8_MyAtoi {

    public static void main(String[] args) {
        LC8_MyAtoi o = new LC8_MyAtoi();
        int i = o.myAtoi("   +0 123");
        System.out.println(i);
    }
    public int myAtoi(String s) {
        if(null == s || "".equals(s)){
            return 0;
        }
        int p = 1;
        int i =0;
        while (i < s.length() && ' '==s.charAt(i)){
            i++;
        }
        if(i>=s.length()) return 0;
        if('-'==s.charAt(i)){
            p = -1;
            i++;
        }else if( '+' == s.charAt(i)){
            i++;
        }else if('9'< s.charAt(i) || '0' > s.charAt(i)){
            return 0;
        }
        int res = 0;

        while (i<s.length()){
            if(s.charAt(i)<='9' && s.charAt(i)>='0'){
                int tmp = s.charAt(i)-'0';
                if(res > (Integer.MAX_VALUE-tmp) /10 ){
                    return -1==p ? Integer.MIN_VALUE : Integer.MAX_VALUE;
                }
                res = res*10 + tmp;
            }else{
                return res * p;
            }
            i++;
        }
        return res * p;
    }

}
