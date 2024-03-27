package com.bmilk.algorithm.list;

public class LC206_ReverseList {
    public static void main(String[] args) {
        LC206_ReverseList o = new LC206_ReverseList();
        ListNode node5 = new ListNode(5);
        ListNode node4 = new ListNode(4, node5);
        ListNode node3 = new ListNode(3, node4);

        ListNode node2 = new ListNode(2, node3);
        ListNode node1 = new ListNode(1,node2);
        // ListNode node = o.reverseList(node1);
        ListNode node = o.reverseList_withLoop(node1);
        while (null != node){
            System.out.println(node.val);
            node= node.next;
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


    public ListNode reverseList_withLoop(ListNode head) {
        if(null == head || null == head.next){
            return head;
        }
        ListNode p1 = head;
        ListNode p2 = p1.next;
        ListNode p3 = p2.next;
        p1.next = null;
        p2.next = p1;
        while (null != p3){
            p1 = p2;
            p2 = p3;
            p3 = p3.next;
            p2.next = p1;
        }
        return p2;
    }


    private static class ListNode{
        private int val;
        private ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
}
