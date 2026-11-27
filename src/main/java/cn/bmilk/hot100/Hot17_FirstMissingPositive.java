package cn.bmilk.hot100;

public class Hot17_FirstMissingPositive {
    public static void main(String[] args) {
        Hot17_FirstMissingPositive hot17FirstMissingPositive = new Hot17_FirstMissingPositive();
        int[] nums = new int[]{0,0};
        System.out.println(hot17FirstMissingPositive.firstMissingPositive(nums));
    }
    public int firstMissingPositive(int[] nums) {
        int i=0;
        int len = nums.length-1;
        int  out  = Integer.MAX_VALUE;
        while (i<=len){
            while (nums[i] != i && nums[i] >= 0 && nums[i] <= nums.length){
                if(nums[i] == nums.length){
                    out = nums[i];
                    nums[i] = -1;
                    break;
                }
                if(nums[nums[i]] == nums[i]){
                    break;
                }
                int tmp = nums[nums[i]];
                nums[nums[i]] = nums[i];
                nums[i] = tmp;
            }
            i++;
        }
        i = 1;
        for (; i< nums.length; i++){
            if(nums[i] != i){
                return i;
            }
        }
        return out == nums.length ? nums.length+1: nums.length;

    }


}
