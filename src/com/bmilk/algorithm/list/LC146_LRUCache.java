package com.bmilk.algorithm.list;

import java.util.HashMap;
import java.util.Map;

public class LC146_LRUCache {

    private Node head;
    private Node tail;

    private Map<String, Node> map ;
    private int capacity;
    private int length;



    public static void main(String[] args) {

    }


    public LC146_LRUCache(int capacity) {
        head = new Node();
        tail = new Node();
        head.next = tail;
        tail.pre = head;
        map = new HashMap<>(capacity);
        this.capacity = capacity;
        length = 0;
    }

    public int get(int key) {
        Node node = map.get(String.valueOf(key));
        if (node == null){
            return  -1;
        }
        node.pre.next = node.next;
        node.next.pre = node.pre;

        node.pre = head;
        node.next = head.next;
        head.next.pre = node;
        head.next = node;
        return node.value;
    }

    public void set(int key, int value) {
        Node node = new Node(key, value);
        map.put(String.valueOf(key), node);
        node.pre = head;
        node.next = head.next;
        head.next.pre = node;
        head.next = node;
        length ++;
        if(length > capacity){
            Node remove = tail.pre;
            tail.pre = remove.pre;
            remove.pre.next = tail;
            map.remove(String.valueOf(remove.key));
        }
    }

    class Node{
        public int key;
        public int value;
        public Node pre;
        public Node next;

        public Node(int key, int value){
            this.key = key;
            this.value = value;
        }

        public Node(){
        }
    }
}
