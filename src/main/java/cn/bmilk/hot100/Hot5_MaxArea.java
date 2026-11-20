package cn.bmilk.hot100;

public class Hot5_MaxArea {
    public int maxArea(int[] height) {

        int left = 0;
        int right = height.length-1;

        int res = 0;

        while (left < right){
            res = Math.max(res, (right-left)* Math.min(height[left], height[right]));
            if(height[left] > height[right]){
                right--;
            }else {
                left++;
            }
        }
        return res;

    }
}
