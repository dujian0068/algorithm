package com.bmilk.algorithm;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class LC146_LRUCache {

    public static void main(String[] args) {
        LC146_LRUCache o = new LC146_LRUCache(1);

        o.put(2,1);
        o.get(2);

    }

    private Map<Integer, Node> map;
    private int capacity;

    private Node header;
    private Node tail;
    private int size;


    public LC146_LRUCache(int capacity) {
        this.header = new Node();
        this.tail = new Node();
        this.header.next = tail;
        this.tail.before = header;
        this.size = 0;
        this.map = new HashMap<>();
        this.capacity = capacity;
    }

    public int get(int key) {
        if(!map.containsKey(key)){
            return -1;
        }
        moveToHeader(key);
        return map.get(key).value;

    }

    public void put(int key, int value) {
        if(map.containsKey(key)){
            moveToHeader(key);
            map.get(key).value = value;
            return;
        }
        if(size == capacity){
            Node node = removeTail();
            map.remove(node.key);
        }
        Node newNode = new Node(key, value);
        addNodeInHeader(newNode);
        map.put(key, newNode);
    }

    private void moveToHeader(int key){
        Node node = removeNode(key);
        addNodeInHeader(node);
    }

    private void addNodeInHeader(Node node){
        node.next = header.next;
        header.next.before = node;
        header.next = node;
        node.before = header;
        size+=1;
    }

    private Node removeNode(int key){
        Node node = map.get(key);
        node.before.next = node.next;
        node.next.before = node.before;
        node.before = null;
        node.next = null;
        size-=1;
        return node;
    }

    private Node removeTail(){
        return removeNode(tail.before.key);
    }

    class Node{
        Integer key;
        Integer value;
        Node next;
        Node before;
        Node(){

        }
        Node(int key, int value){
            this.key = key;
            this.value = value;
        }
    }

}
