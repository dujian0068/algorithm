package cn.bmilk.hot100;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Hot6_ThreeSum {

    public static void main(String[] args) {
        Hot6_ThreeSum hot6ThreeSum = new Hot6_ThreeSum();

        List<List<Integer>> lists = hot6ThreeSum.threeSum(new int[]{1,2,0,1,0,0,0,0});
        System.out.println(lists.toString());
    }
    public List<List<Integer>> threeSum(int[] nums) {

        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i<nums.length-2 && nums[i] <=0; i++){
            if(i != 0 && nums[i] == nums[i-1]){
                continue;
            }
            int left = i +1;
            int right = nums.length-1;
            while (left < right){
                if(left > i+ 1 && nums[left] == nums[left-1]){
                    left++;
                    continue;
                }
                if(-nums[i] == nums[left] + nums[right]){
                    res.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    left++;
                    right--;
                }else if(-nums[i] > nums[left] + nums[right]){
                    left++;
                }else {
                    right--;
                }
            }

        }
        return res;

    }

}
