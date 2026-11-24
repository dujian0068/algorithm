package cn.bmilk.hot100;

import java.util.*;

public class Hot11_MaxSlidingWindow {
    public static void main(String[] args) {
        int[] nums = new int[]{1};
        int k = 3;
        Hot11_MaxSlidingWindow hot11MaxSlidingWindow = new Hot11_MaxSlidingWindow();
        int[] ints = hot11MaxSlidingWindow.maxSlidingWindow(nums, k);
        Arrays.asList(ints).forEach(System.out::println);
    }

    public int[] maxSlidingWindow(int[] nums, int k) {
        List<Integer> resList = new ArrayList<>();
        Deque<Integer> queue = new ArrayDeque<>();
        queue.add(0);
        for (int i = 1; i< nums.length && i < k; i++){
            while ( !queue.isEmpty() && nums[queue.peekFirst()]<= nums[i]){
                queue.pollFirst();
            }
            while (!queue.isEmpty() && nums[queue.peekLast()] <=nums[i]){
                queue.pollLast();
            }
            queue.add(i);
        }
        resList.add(nums[queue.peekFirst()]);
        for (int i = k; i< nums.length; i++){
            if(queue.peekFirst() == i -k){
                queue.pollFirst();
            }
            while ( !queue.isEmpty() && nums[queue.peekFirst()]<= nums[i]){
                queue.pollFirst();
            }
            while (!queue.isEmpty() && nums[queue.peekLast()] <=nums[i]){
                queue.pollLast();
            }
            queue.add(i);
            resList.add(nums[queue.peekFirst()]);
        }

        int[] res = new int[resList.size()];
        for (int i = 0; i<resList.size(); i++){
            res[i] = resList.get(i);
        }
        return res;
    }
}
