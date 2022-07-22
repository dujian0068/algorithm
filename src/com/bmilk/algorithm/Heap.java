package com.bmilk.algorithm;

import javax.security.auth.callback.Callback;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Heap<E extends Comparable> {

    private List<E> queue;

    public Heap(List<E> queue) {
        this.queue = queue;
    }


    public static void main(String[] args) {
        Integer[] q = new Integer[]{1, 23, 6, 22, 78, 18, 3, 34, 43, 2, 9, 33};
        List<Integer> list = new ArrayList<Integer>(Arrays.asList(q));
        Heap<Integer> heap = new Heap<>(list);
        heap.buildHeap();
        System.out.println(heap);
        heap.add(44);
        heap.siftUp(heap.size() - 1);
        System.out.println(heap);
        heap.sort();
        System.out.println(heap);
    }

    public void add(E e) {
        queue.add(e);
    }

    public int size() {
        return queue.size();
    }

    public void sort() {
        int N = this.size() - 1;
        for (int i = N ; i >= 0; i--) {
            swap(0, i);
            siftDown(0, i);
        }
    }

    public void buildHeap() {
        int i = (queue.size() >>> 1) - 1;
        while (i >= 0) {
            siftDown(i);
            i--;
        }
    }


    private void siftUp(int k) {
        while (k > 0) {
            int parent = (k - 1) >>> 1;
            if (!less(parent, k)) break;
            swap(parent, k);
            k = parent;
        }
    }

    private void siftDown(int k) {
        int mid = queue.size() >>> 1;

        while (k < mid) {
            int child = (k << 1) + 1;
            int r = child + 1;
            if (r < queue.size() && less(child, r)) child = r;
            if (!less(k, child)) break;
            swap(k, child);
            k = child;

        }
    }

    private void siftDown(int k, int N) {
        int mid = N >>> 1;

        while (k < mid) {
            int child = (k << 1) + 1;
            int r = child + 1;
            if (r < N && less(child, r)) child = r;
            if (!less(k, child)) break;
            swap(k, child);
            k = child;
        }
    }

    private boolean less(int i, int j) {
        return queue.get(i).compareTo(queue.get(j)) < 0;
    }

    private void swap(int i, int j) {
        E e = queue.get(i);
        queue.set(i, queue.get(j));
        queue.set(j, e);
    }

    @Override
    public String toString() {
        return queue.toString();
    }
}
