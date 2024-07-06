package com.bmilk.algorithm;

public class LC3101_CountAlternatingSubarrays {

    public static void main(String[] args) {
        LC3101_CountAlternatingSubarrays o = new LC3101_CountAlternatingSubarrays();
        long l = o.countAlternatingSubarrays(new int[]{1,0,1,0});
        System.out.println(l);
    }
    public long countAlternatingSubarrays(int[] nums) {
        if(nums.length == 1){
            return 1;
        }
        long result = 0L;
        int start;
        int end = 0;
        while (end < nums.length){
            start = end;
            end += 1;
            while (end < nums.length && nums[end] != nums[end-1]){
                end++;
            }
            int tmp = end -start;
            result += (long) (tmp + 1) * (tmp/2);
            if (tmp %2 !=0){
                result += ((tmp/2)+1);
            }
        }
        return result;
    }

}
