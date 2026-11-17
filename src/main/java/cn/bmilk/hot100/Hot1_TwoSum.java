package cn.bmilk.hot100;


import java.util.HashMap;
import java.util.Map;

public class Hot1_TwoSum {
    public static void main(String[] args) {
        int[] nums = new int[]{2, 7, 11, 15};
        int target = 9;
        twoSum2(nums, target);
    }

    public int[] twoSum(int[] nums, int target) {

        for (int i =0; i<nums.length-1; i++){
            for (int j = i+1; j<nums.length; j++){
                if(nums[i] + nums[j] == target){
                    return new int[]{i, j};
                }
            }
        }
        return null;
    }

    public static int[] twoSum2(int[] nums, int target) {

        Map<Integer, Integer> tmp = new HashMap<>();
        for (int i = 0; i< nums.length;i++){
            if(tmp.containsKey(target-nums[i])){
                return new int[]{tmp.get(target-nums[i]), i};
            }
            tmp.put(nums[i], i);
        }
        return null;
    }
}
