package com.bmilk.algorithm.string;

import java.math.BigDecimal;

public class LC2288_DiscountPrices {
    public static void main(String[] args) {
        LC2288_DiscountPrices o = new LC2288_DiscountPrices();
        String s = o.discountPrices("$7383692 5q $5870426", 64);
        System.out.println(s);
    }
    public String discountPrices(String sentence, int discount) {
        String[] s = sentence.split(" ");
        StringBuilder sb = new StringBuilder();
        BigDecimal discount2 = new BigDecimal(100-discount).divide(new BigDecimal(100));
        for (String str: s){
            if(!str.startsWith("$")){
                append(str, sb);
                continue;
            }
            boolean needDis = true;
            for (int i = 1; i< str.length(); i++){
                if('0'> str.charAt(i) || '9' < str.charAt(i) ){
                    needDis = false;
                    break;
                }
            }
            if(str.length() == 1 || !needDis){
                append(str, sb);
                continue;
            }
            BigDecimal bigDecimal = new BigDecimal(str.substring(1, str.length()));
            append("$"+bigDecimal.multiply(discount2).setScale(2, BigDecimal.ROUND_HALF_UP), sb);
        }
        return sb.toString();
    }

    private void  append(String str, StringBuilder sb){
        sb.append(sb.length() == 0 ? str : " "+str);
    }
}
