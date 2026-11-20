package cn.bmilk.hot100;

public class Hot4_MoveZeroes {
    public void moveZeroes(int[] nums) {
        if(null == nums || nums.length <=1){
            return;
        }
        int slow = 0;
        int quick = slow;
        while (quick < nums.length){
            while (quick<nums.length && nums[quick] == 0){
                quick++;
            }
            if(quick>= nums.length){
                break;
            }
            nums[slow] = nums[quick];
            slow++;
            quick++;
        }
        while (slow<nums.length){
            nums[slow++] =0;
        }
    }
}

