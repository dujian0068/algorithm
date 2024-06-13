package com.bmilk.algorithm.greedy;

import javax.print.attribute.standard.PrintQuality;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class LC2813_FindMaximumElegance {

    public static void main(String[] args) {
        LC2813_FindMaximumElegance o = new LC2813_FindMaximumElegance();
        int[][] items = {{5, 4}, {6, 6}, {8, 4}, {6, 6}, {7, 6}, {1, 6}, {4, 2}};
        long maximumElegance = o.findMaximumElegance(items, 5);
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

        int sumProfit = 0;
        Map<Integer, Integer> categoryNumMap = new HashMap<>();
        while (priorityQueue.size() < k) {
            for (PriorityQueue<int[]> tmp : categoryMap.values()) {
                if (!tmp.isEmpty()) {
                    queue.add(tmp);
                }
            }

            while (priorityQueue.size() < k && !queue.isEmpty()) {
                int[] poll = queue.poll().poll();
                priorityQueue.add(poll);
                sumProfit += poll[0];
                categoryNumMap.merge(poll[1], 1, (a, b) -> categoryNumMap.get(poll[b]) + b);
            }
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
        long result = sumProfit + categoryNumMap.size() * categoryNumMap.size();
        while (!queue.isEmpty()) {
            PriorityQueue<int[]> pollQueue = queue.poll();
            int[] poll = pollQueue.poll();

            int[] peek = priorityQueue.peek();

            int afterSize = 0;
            if (poll[1] == peek[1]) {
                afterSize = categoryNumMap.size();
            } else {
                int tmp = categoryNumMap.get(peek[1]) > 1 ? categoryNumMap.size() : categoryNumMap.size() - 1;
                afterSize = categoryNumMap.containsKey(poll[1]) ? tmp : tmp + 1;
            }

            long afterResult = sumProfit - peek[0] + poll[0] + afterSize * afterSize;
            if (afterResult >= result) {
                priorityQueue.poll();
                priorityQueue.add(poll);
                if (!pollQueue.isEmpty()) {
                    queue.add(pollQueue);
                }
                if (afterSize != categoryNumMap.size()) {
                    PriorityQueue<int[]> newQueue = new PriorityQueue<>();
                    newQueue.add(peek);
                    queue.add(newQueue);
                }

                Integer remove = categoryNumMap.remove(peek[1]);
                if (remove > 1) {
                    categoryNumMap.put(peek[1], remove - 1);
                }
                categoryNumMap.put(poll[1], categoryNumMap.get(poll[1]) + 1);
                result = afterResult;
            }
        }
        return result;
    }
}
