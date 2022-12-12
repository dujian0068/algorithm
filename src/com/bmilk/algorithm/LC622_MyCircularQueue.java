package com.bmilk.algorithm;

public class LC622_MyCircularQueue {
    private int size;
    private int[] values;
    private int head;
    private int tail;

    public LC622_MyCircularQueue(int k) {
        values = new int[k];
        size = 0;
        head = 0;
        tail = 0;
    }

    public boolean enQueue(int value) {
        if(size == values.length){
            return false;
        }
        if( tail == values.length){
            tail = 0;
        }
        values[tail] = value;
        tail++;
        size++;
        return true;
    }

    public boolean deQueue() {
        if( size == 0 ){
            return false;
        }

        if(head == values.length){
            head = 0;
        }
        head ++;
        size--;
        return true;
    }

    public int Front() {
        if(size == 0) return -1;
        if(head == values.length){
            head = 0;
        }
        return values[head];
    }

    public int Rear() {
        if(size == 0) return -1;

        return values[tail-1];
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isFull() {
        return size == values.length;
    }

    public static void main(String[] args) {

        LC622_MyCircularQueue service = new LC622_MyCircularQueue(3);
        System.out.println(service.enQueue(1));
        System.out.println(service.enQueue(2));
        System.out.println(service.enQueue(3));
        System.out.println(service.enQueue(4));
        System.out.println(service.Rear());
        System.out.println(service.isFull());
        System.out.println(service.Front());
        System.out.println(service.Front());
        System.out.println(service.deQueue());
        System.out.println(service.deQueue());
        System.out.println(service.deQueue());
        System.out.println(service.deQueue());
        System.out.println(service.enQueue(4));
        System.out.println(service.Front());

        System.out.println(service.Rear());
        System.out.println(service.isFull());
        System.out.println(service.isEmpty());

    }
}
