package cn.bmilk.hot100;

import java.util.HashMap;
import java.util.Map;

public class Hot10_SubarraySum {

    public static void main(String[] args) {
        int[] nums = new int[]{1, 1, 1};
        int k = 2;
        Hot10_SubarraySum hot10SubarraySum = new Hot10_SubarraySum();
        int i = hot10SubarraySum.subarraySum2(nums, k);
        System.out.println(i);
    }

    public int subarraySum(int[] nums, int k) {
        if(null == nums || nums.length ==0){
            return 0;
        }
        int len = nums.length;
        int[] tmp = new int[len];

        tmp[0] = nums[0];
        for (int i =1;i<len;i++){
            tmp[i] = nums[i] + tmp[i-1];
        }
        int res =0;
        for (int i = 0; i<len; i++){
            if(tmp[i] == k){
                res+=1;
            }

            for (int j=0; j<i; j++){
                if(tmp[i] - tmp[j] == k){
                    res +=1;
                }
            }
        }
        return res;

    }



    public int subarraySum2(int[] nums, int k) {
        if(null == nums || nums.length ==0){
            return 0;
        }

        int tmp = 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        int res =0;
        for (int num : nums) {
            tmp += num;
            int r = tmp - k;
            if (null != map.get(r)) {
                res += map.get(r);
            }
            int count = map.computeIfAbsent(tmp, t -> 0);
            map.put(tmp, count + 1);
        }
        return res;
    }
}
