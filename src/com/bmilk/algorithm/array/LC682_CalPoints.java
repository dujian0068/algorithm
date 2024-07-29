package com.bmilk.algorithm.array;

public class LC682_CalPoints {
    public int calPoints(String[] operations) {
        int[] scores = new int[operations.length];
        scores[0] = Integer.parseInt(operations[0]);
        int l = 1;
        for (int i = 1; i< operations.length; i++){
            if(operations[i].equals("D")) {
                scores[l] = scores[l-1] * 2;
                l++;
            }else if(operations[i].equals("C")){
                l--;
            }else if(operations[i].equals("+")){
                scores[l] = scores[l-1] + scores[l-2];
                l++;
            } else {
                scores[l] = Integer.parseInt(operations[i]);
                l++;
            }
        }
        int res = 0;
        for(int i = 0; i< l; i++){
            res += scores[i];
        }
        return res;
    }
}
