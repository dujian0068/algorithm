package cn.bmilk.hot100;

import java.util.HashSet;
import java.util.Set;

public class Hot_longestConsecutive {

    public static void main(String[] args) {
        Hot_longestConsecutive obj = new Hot_longestConsecutive();
        int i = obj.longestConsecutive(new int[]{100,4,200,1,3,2});
        System.out.println(i);
    }

    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        int res = 0;
       for (int num : set) {

           if(!set.contains(num-1)){
               int num2  = num+1;
               int tmp = 1;
               while (set.contains(num2)) {
                   tmp++;
                   num2++;
               }
               res = Math.max(res,tmp);
           }
       }
       return res;
    }
}
