package cn.bmilk.hot100;

public class Hot16_ProductExceptSelf {
    public static void main(String[] args) {
        Hot16_ProductExceptSelf hot16ProductExceptSelf = new Hot16_ProductExceptSelf();
        hot16ProductExceptSelf.productExceptSelf(new int[]{-1, 1, 0, -3, 3});
    }
    public int[] productExceptSelf(int[] nums) {

        int[] res = new int[nums.length];
        res[0] = 1;
        for (int i = 1; i<nums.length; i++ ){
            res[i] = nums[i-1] * res[i-1];
        }
        int  tmp = nums[nums.length-1];
        for (int i = nums.length-2; i>=0; i--){
            res[i] = tmp * res[i];
            tmp*=nums[i];
        }
        return res;
    }

}
