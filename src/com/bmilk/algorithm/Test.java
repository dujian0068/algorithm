package com.bmilk.algorithm;

import com.bmilk.algorithm.node.TreeNode;
import com.bmilk.algorithm.tree.LC144_PreorderTraversal;
import com.sun.org.apache.bcel.internal.generic.NEW;
import sun.nio.ch.ThreadPool;

import java.util.*;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.AbstractQueuedSynchronizer;
import java.util.concurrent.locks.ReentrantLock;

public class Test {
    public static void main(String[] args) {
        Test test = new Test();
        int[] nums = {1,3,-1,0,1,4,6,7};
        List<Integer> integers = test.maxValue2(nums, 3);
        System.out.println(integers);
    }

    public ArrayList<Integer> GetLeastNumbers_Solution(int [] input, int k) {
        PriorityQueue<Integer> queue = new PriorityQueue<>(k, (o1, o2)-> o2.compareTo(o1));

        for (int value : input){
            if(queue.size()<k){
                queue.add(value);
            }else {
                if( queue.peek() > value){
                    queue.poll();
                    queue.add(value);
                }
            }
        }
        return new ArrayList<>(queue);
    }

    public List<Integer> maxValue(int[] nums, int k){
        PriorityQueue<Integer> pQ = new PriorityQueue<>(k, (a,b)->b-a);

        int len = nums.length;
        List<Integer> res = new ArrayList<>();

        for (int i =0 ; i<k ;i++){
            pQ.add(nums[i]);
        }

        res.add(pQ.peek());
        for (int i = k;i<len; i++){
            pQ.remove(nums[i-k]);
            pQ.add(nums[i]);
            res.add(pQ.peek());
        }
        return res;
    }

    private int count = 0;
    public void request(){
        ReentrantLock lock = new ReentrantLock();


        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                while (true){
                    try {
                        lock.lock();
                        if(count >= 10000){
                            return;
                        }
                        // 访问wwww.alipay.com
                        System.out.println("访问wwww.alipay.com" + "times ====" +count + "   thread===" + Thread.currentThread());
                        count++;
                    }finally {
                        lock.unlock();
                    }
                }
            }
        };
        List<Thread> threadList = new ArrayList<>();
        for (int i= 0; i<20; i++){
            Thread thread = new Thread(runnable);
            threadList.add(thread);
            thread.start();
        }
    }

    private AtomicInteger atomicInteger = new AtomicInteger(0);
    public void request2(){
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                while (atomicInteger.get() < 10000){
                    atomicInteger.addAndGet(1);
                    // 访问wwww.alipay.com
                    System.out.println("访问wwww.alipay.com" + "times ====" +atomicInteger.get() + "   thread===" + Thread.currentThread());

                }
            }
        };
        for (int i= 0; i<20; i++){
            Thread thread = new Thread(runnable);
            thread.start();
        }
    }

    public List<Integer> maxValue2(int[] nums, int k) {
        List<Integer> res = new ArrayList<>();

        LinkedList<Integer> queue = new LinkedList<>();
        int len = nums.length;

        for (int right = 0; right < len; right++) {
            while (!queue.isEmpty() && nums[right] > nums[queue.peekLast()]) {
                queue.removeLast();
            }

            queue.addLast(right);

            int left = right - k + 1;
            if (queue.peekFirst() < left) {
                queue.removeFirst();
            }
            if (right >= k - 1) {
                res.add(nums[queue.peekFirst()]);
            }
        }
        int q =1;
        double n = q;
        return res;
    }
}
