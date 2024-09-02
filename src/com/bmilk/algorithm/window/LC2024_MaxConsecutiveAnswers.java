package com.bmilk.algorithm.window;

public class LC2024_MaxConsecutiveAnswers {

    public static void main(String[] args) {
        LC2024_MaxConsecutiveAnswers o = new LC2024_MaxConsecutiveAnswers();
        int tfft = o.maxConsecutiveAnswers("TFFT", 1);
        System.out.println(tfft);
    }
    public int maxConsecutiveAnswers(String answerKey, int k) {

        int res = 0;
        int tmp = k;
        int left = 0;
        int right = 0;
        int len = answerKey.length();
        while (right< len){
            while (right < len && (k > 0 || answerKey.charAt(right) == 'T')){
                if(answerKey.charAt(right) == 'F'){
                    k--;
                }
                right ++;
            }
            res = Math.max(right-left, res);
            if(right == len){
                break;
            }
            while (k <=0 && left <= right){
                if(answerKey.charAt(left) == 'F'){
                    k++;
                }
                left++;
            }
        }
        left = 0;
        right = 0;
        k = tmp;
        while (right< len){
            while (right< len && (k > 0 || answerKey.charAt(right) == 'F')){
                if(answerKey.charAt(right) == 'T'){
                    k--;
                }
                right ++;
            }
            res = Math.max(right-left, res);
            if(right == len){
                break;
            }
            while (k <=0 && left <= right){
                if(answerKey.charAt(left) == 'T'){
                    k++;
                }
                left++;
            }
        }
        return res;
    }

}
