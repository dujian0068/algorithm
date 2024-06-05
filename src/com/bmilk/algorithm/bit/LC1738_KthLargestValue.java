package com.bmilk.algorithm.bit;

import oracle.jrockit.jfr.parser.FLREventInfo;

import java.util.*;

public class LC1738_KthLargestValue {
    public static void main(String[] args) {
        LC1738_KthLargestValue o = new LC1738_KthLargestValue();
        int[][] matrix = {{5,2},{1,6}};
        int i = o.kthLargestValue(matrix, 3);
        System.out.println(i);
    }

    public int kthLargestValue(int[][] matrix, int k) {
        int row = matrix.length;
        int col = matrix[0].length;

        int[][] xor = new int[row][col];
        List<Integer> list = new ArrayList<>(row*col);
        xor[0][0] = matrix[0][0];
        list.add(xor[0][0]);
        for (int i = 1; i<col; i++){
            xor[0][i] = matrix[0][i] ^ xor[0][i-1];
            list.add(xor[0][i]);
        }
        for (int i = 1; i<row; i++){
            xor[i][0] = matrix[i][0] ^ xor[i-1][0];
            list.add(xor[i][0]);
        }

        for (int i =1; i<row; i++){
            for (int j =1; j<col; j++){
                xor[i][j] = xor[i-1][j-1] ^ xor[i-1][j] ^ xor[i][j-1] ^ matrix[i][j];
                list.add(xor[i][j]);
            }
        }
        return quickSelect(list, k);
    }

    public static int quickSelect(List<Integer> list, int k) {
        int low = 0;
        int high = list.size() - 1;

        while (low <= high) {
            int p = hoarePartition(list, low, high);
            if (p == k) {
                return list.get(p);
            } else if (p > k) {
                high = p;
            } else {
                low = p + 1;
            }
        }
        return Integer.MAX_VALUE; // 当k不在范围内时返回
    }

    public static int hoarePartition(List<Integer> list, int low, int high) {
        int pivot = list.get(low); // 使用第一个元素作为基准元素
        int i = low - 1;
        int j = high + 1;
        while (true) {
            while (list.get(++i) < pivot); // 寻找大于等于pivot的元素
            while (list.get(--j) > pivot); // 寻找小于等于pivot的元素
            if (i >= j) {
                return j; // 返回的是分区点的索引
            }
            swap(list, i, j);
        }
    }

    public static void swap(List<Integer> list, int i, int j) {
        int temp = list.get(i);
        list.set(i,list.get(j));
        list.set(j, temp);
    }

}
