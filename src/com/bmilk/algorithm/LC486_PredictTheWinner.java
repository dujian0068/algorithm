package com.bmilk.algorithm;

public class LC486_PredictTheWinner {
    public static void main(String[] args) {
        LC486_PredictTheWinner o = new LC486_PredictTheWinner();
        boolean b = o.predictTheWinner(new int[]{1,5,233,7});
        System.out.println(b);
    }

    public boolean predictTheWinner(int[] nums) {
        return total(nums, 0, nums.length-1, 1)>=0;
    }

    private int total(int[] nums, int start, int end, int n){
        if(end<start){
            return 0;
        }
        if(n%2==1){
            int t1= nums[start] + total(nums, start+1, end, n+1);
            int t2 = nums[end] +  total(nums, start, end-1, n+1);
            return Math.max(t1, t2);
        }else {
            int t1= nums[start]*-1 + total(nums, start+1, end, n+1);
            int t2 = nums[end]*-1 +  total(nums, start, end-1, n+1);
            return Math.min(t1, t2);
        }
    }
}
