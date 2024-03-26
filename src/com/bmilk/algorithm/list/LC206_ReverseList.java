package com.bmilk.algorithm.list;

public class LC206_ReverseList {
    public static void main(String[] args) {
        LC206_ReverseList o = new LC206_ReverseList();
        ListNode node2 = new ListNode(2);
        ListNode node1 = new ListNode(1,node2);
        ListNode node = o.reverseList(node1);
        while (null != node){
            System.out.println(node.val);
        }
    }

    public ListNode reverseList(ListNode head) {
        if(head == null){
            return null;
        }
        ListNode tail = new ListNode();
        reverseList(head, tail);
        head.next = null;
        return tail.next;
    }

    public void reverseList(ListNode node, ListNode tail) {
        if( null == node.next){
            tail.next = node;
            return;
        }
        reverseList(node.next, tail);
        node.next.next = node;
    }

    static class ListNode{
        private int val;
        private ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
}
