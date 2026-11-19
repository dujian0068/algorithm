package cn.bmilk.hot100;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Hot3_LongestConsecutive {
    public int longestConsecutive(int[] nums) {
        if(null == nums  || 0 == nums.length){
            return 0;
        }
        Set<Integer> set = new HashSet<>(nums.length);

        for (int num : nums){
            set.add(num);
        }

        int res = 1;
        for (int num :set){
            if(!set.contains(num -1)){
                int tmp = 1;
                int index = num;
                while (set.contains(index++)){
                    tmp++;
                }
                res = Math.max(tmp, res);
            }
        }
        return res;
    }


}
