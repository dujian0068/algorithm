package com.bmilk.algorithm.stack;

import java.util.Stack;

public class LC232_MyQueue {
}
class MyQueue {
    private Stack<Integer> inStack;
    private Stack<Integer> outStack;

    public MyQueue() {
        inStack = new Stack<>();
        outStack = new Stack<>();
    }

    public void push(int x) {
        inStack.push(x);
    }

    public int pop() {
        if(!outStack.isEmpty()){
            return outStack.pop();
        }
        transfer();
        return outStack.pop();

    }

    public int peek() {
        if(!outStack.isEmpty()){
            return outStack.peek();
        }
        transfer();
        return outStack.peek();
    }

    public boolean empty() {
        return inStack.isEmpty() && outStack.isEmpty();
    }

    private void transfer(){
        if(!outStack.isEmpty()){
            return;
        }
        while (!inStack.isEmpty()){
            outStack.push(inStack.pop());
        }
    }
}