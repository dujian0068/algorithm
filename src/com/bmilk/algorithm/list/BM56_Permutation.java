package com.bmilk.algorithm.list;

import java.util.ArrayList;
import java.util.Arrays;

public class BM56_Permutation {
    public static void main(String[] args) {
        BM56_Permutation service = new BM56_Permutation();

        ArrayList<String> ab = service.Permutation("ab");
        System.out.println(ab);
    }

    public ArrayList<String> Permutation(String str) {
        ArrayList<String> res = new ArrayList<>();
        char[] chars = str.toCharArray();
        boolean[] mark = new boolean[chars.length];
        ArrayList<Character> tmp = new ArrayList<>();

        Arrays.sort(chars);
        Permutation(chars, res, tmp, mark);
        return res;
    }

    public void Permutation(char[] chars,ArrayList<String> res , ArrayList<Character> tmp, boolean[] mark){
        if(tmp.size() == chars.length){

            res.add(charToString(tmp));
            return;
        }

        for (int i =0; i<chars.length;i++){

            if(mark[i] || i>0 && chars[i] == chars[i-1] && !mark[i-1]){
                continue;
            }

            mark[i] = true;
            tmp.add(chars[i]);
            Permutation(chars, res, tmp, mark);
            tmp.remove(tmp.size()-1);
            mark[i]= false;
        }
    }

    private String charToString(ArrayList<Character> tmp){
        StringBuilder sb = new StringBuilder();
        for (Character character : tmp){
            sb.append(character);
        }
        return sb.toString();

    }
}
