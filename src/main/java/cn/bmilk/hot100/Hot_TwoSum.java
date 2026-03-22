package cn.bmilk.hot100;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Hot_TwoSum {

    public static void main(String[] args) {
        int[] arr = {2, 7, 11, 15};
        int target = 9;
        Hot_TwoSum obj = new Hot_TwoSum();
        int[] ints = obj.twoSum(arr, target);
        System.out.println(Arrays.toString(ints));

    }

    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if(map.containsKey(target- nums[i])){
                return new int[]{i, map.get(target - nums[i])};
            }
            map.put(nums[i], i);
        }
        return null;
    }


}
