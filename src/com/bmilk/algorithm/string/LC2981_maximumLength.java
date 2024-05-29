package com.bmilk.algorithm.string;

public class LC2981_maximumLength {
    public static void main(String[] args) {
        LC2981_maximumLength o = new LC2981_maximumLength();
        int aaaa = o.maximumLength("cccerrrecdcdccedecdcccddeeeddcdcddedccdceeedccecde");
        System.out.println(aaaa);
    }

    public int maximumLength(String s) {
        int result = -1;
        for (int i = 0; i<=s.length() -3; i++){
            for (int j = i+1; j<=s.length()-2; j++){
                if(j-i<=result){
                    continue;
                }
                if(!check(s, i, j)){
                    continue;
                }
               if(checkTimes(s, s.substring(i, j), 3)){
                   result = Math.max(result, j-i);
               }

            }
        }
        return result;

    }
    private boolean check(String str, int start, int end){
        char c = str.charAt(start);
        for (int i = start+1; i<end;i++){
            if(str.charAt(i) != c) return false;
        }
        return true;
    }

    private boolean checkTimes(String str1, String str2, int times){
        int t = 0;
        for (int i = 0; i<str1.length()-str2.length()+1; i++){
            if(str1.substring(i, i+ str2.length()).equals(str2)){
                t++;
                if(t>=times){
                    return true;
                }
            }
        }
        return false;
    }
}
