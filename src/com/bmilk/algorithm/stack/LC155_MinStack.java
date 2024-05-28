package com.bmilk.algorithm.stack;

import java.util.LinkedList;

public class LC155_MinStack {

    public static void main(String[] args) {
        LC155_MinStack o = new LC155_MinStack();

        o.push(-2);
        o.push(0);
        o.push(-3);
        System.out.println(o.getMin());
        o.pop();
        System.out.println(o.top());
        System.out.println(o.getMin());


    }
    private LinkedList<Integer> stack;
    private LinkedList<Integer> minStack;

    public LC155_MinStack() {
        stack = new LinkedList<>();
        minStack = new LinkedList<>();
    }

    public void push(int val) {
        stack.addLast(val);
        if(minStack.isEmpty()){
            minStack.addLast(val);
            return;
        }
        Integer i = minStack.peekLast();
        minStack.addLast(Math.min(i, val));
    }

    public void pop() {
        Integer p = stack.pollLast();
        minStack.pollLast();
    }

    public int top() {
        return stack.peekLast();
    }

    public int getMin() {
        return minStack.peekLast();
    }
}
