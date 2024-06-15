package com.bmilk.algorithm.greedy;

import java.util.*;

public class LC2813_FindMaximumElegance {

    public static void main(String[] args) {
        LC2813_FindMaximumElegance o = new LC2813_FindMaximumElegance();
//        int[][] items = new int[100000][2];
//        for (int i = 1; i<= 100000; i++){
//            items[i-1] = new int[]{1000000000, i};
//        }
        int[][] items = {{1, 1}, {4, 1}};
        long maximumElegance = o.findMaximumElegance2(items, 1);
        System.out.println(maximumElegance);
    }

    public long findMaximumElegance(int[][] items, int k) {
        Map<Integer, PriorityQueue<int[]>> categoryMap = new HashMap<>();
        // 区分不同项目
        // 每个项目按照从大到小排序
        for (int[] item : items) {
            if (!categoryMap.containsKey(item[1])) {
                categoryMap.put(item[1], new PriorityQueue<>((o1, o2) -> o2[0] - o1[0]));
            }
            categoryMap.get(item[1]).add(item);
        }
        PriorityQueue<int[]> priorityQueue = new PriorityQueue<>(Comparator.comparingInt(o -> o[0]));
        PriorityQueue<PriorityQueue<int[]>> queue = new PriorityQueue<>((o1, o2) -> {
            int[] peek1 = o1.peek();
            int[] peek2 = o2.peek();
            return peek2[0] - peek1[0];
        });
        for (PriorityQueue<int[]> tmp : categoryMap.values()) {
            if (!tmp.isEmpty()) {
                queue.add(tmp);
            }
        }
        long sumProfit = 0;
        Map<Integer, Integer> categoryNumMap = new HashMap<>();
        while (!queue.isEmpty() && priorityQueue.size() < k) {
            int[] tmp = queue.poll().poll();
            priorityQueue.add(tmp);
            sumProfit += tmp[0];
            categoryNumMap.put(tmp[1], 1);
        }
        while (!queue.isEmpty()) {
            int[] tmp = queue.poll().poll();
            categoryMap.remove(tmp[1]);
        }

        for (PriorityQueue<int[]> tmp : categoryMap.values()) {
            if (!tmp.isEmpty()) {
                queue.add(tmp);
            }
        }

        while (priorityQueue.size() < k && !queue.isEmpty()) {
            PriorityQueue<int[]> pollQueue = queue.poll();
            int[] tmp = pollQueue.poll();
            priorityQueue.add(tmp);
            sumProfit += tmp[0];
            categoryNumMap.put(tmp[1], categoryNumMap.get(tmp[1]) + 1);
            if (!pollQueue.isEmpty()) {
                queue.add(pollQueue);
            }
        }
        long result = sumProfit + ((long) categoryNumMap.size() * (long) categoryNumMap.size());

        while (!queue.isEmpty()) {
            PriorityQueue<int[]> pollQueue = queue.poll();
            int[] tmp = pollQueue.poll();
            int[] poll = priorityQueue.poll();
            priorityQueue.add(tmp);
            sumProfit = sumProfit - poll[0] + tmp[0];
            int count = categoryNumMap.get(poll[1]);
            if (count > 1) {
                categoryNumMap.put(poll[1], count - 1);
            } else {
                categoryNumMap.remove(poll[1]);
            }
            categoryNumMap.put(tmp[1], categoryNumMap.get(tmp[1]) == null ? 1 : categoryNumMap.get(tmp[1]) + 1);

            result = Math.max(result, sumProfit + (long) categoryNumMap.size() * (long) categoryNumMap.size());

            if (!pollQueue.isEmpty()) {
                queue.add(pollQueue);
            }
        }
        return result;
    }

    public long findMaximumElegance2(int[][] items, int k) {
        Arrays.sort(items, ((o1, o2) -> o2[0] - o1[0]));

        Set<Integer> categorySet = new HashSet<>();
        long profitSum = 0;
        Stack<int[]> stack = new Stack<>();
        for (int i = 0; i<k ; i++){
            int[] item = items[i];
            profitSum += item[0];
            if(categorySet.contains(item[1])){
                stack.push(item);
            }else {
                categorySet.add(item[1]);
            }
        }
        int p = k;
        long result = profitSum + (long)categorySet.size() * (long)categorySet.size();
        while (!stack.isEmpty() && p < items.length){
            int[] item = items[p++];
            if (categorySet.contains(item[1])){
                continue;
            }
            int[] pop = stack.pop();
            categorySet.add(item[1]);
            profitSum = profitSum - pop[0] + item[0];
            result = Math.max(result, profitSum + (long) categorySet.size()*(long) categorySet.size());
        }
        return result;
    }

}
