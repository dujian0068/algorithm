package com.bmilk.algorithm.array;


public class LC2748_CountBeautifulPairs {
    public static void main(String[] args) {
        LC2748_CountBeautifulPairs o = new LC2748_CountBeautifulPairs();
        int i = o.countBeautifulPairs(new int[]{756, 1324, 2419, 495, 106, 111, 1649, 1474, 2001, 1633, 273, 1804, 2102, 1782, 705, 1529, 1761, 1613, 111, 186, 412});
        System.out.println(i);
    }

    public int countBeautifulPairs(int[] nums) {
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            int num1 = nums[i];
            while (num1 >= 10) {
                num1 /= 10;
            }
            for (int j = i + 1; j < nums.length; j++) {
                res += check(num1, nums[j]) ? 1 : 0;
            }
        }
        return res;
    }

    private boolean check(int num1, int num2) {
        num2 = num2 % 10;
        for (int i = 2; i <= Math.min(num1, num2); i++) {
            if (num1 % i == 0 && num2 % i == 0) {
                return false;
            }
        }
        return true;
    }
}
