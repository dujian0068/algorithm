package cn.bmilk.hot100;

public class Hot7_Trap {
    public static void main(String[] args) {
        Hot7_Trap hot7Trap = new Hot7_Trap();
        int[] height = new int[]{4, 2, 0, 3, 2, 5};
        System.out.println(hot7Trap.trap(height));
    }

    public int trap(int[] height) {
        int[][] tmp =new int[2][height.length];
        int len = height.length-1;
        tmp[0][0] = height[0];
        tmp[1][len] = height[len];

        for (int i =1; i< height.length; i++){
            tmp[0][i] = Math.max(tmp[0][i-1], height[i]);
        }
        for (int i = len-1; i>=0; i--){
            tmp[1][i] = Math.max(tmp[1][i+1], height[i]);
        }
        int res = 0;
        for (int i = 1; i< len; i++){
            res += Math.max(Math.min(tmp[0][i], tmp[1][i])-height[i], 0);
        }
        return res;
    }
}
