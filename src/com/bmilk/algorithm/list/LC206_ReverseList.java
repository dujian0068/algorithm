package com.bmilk.algorithm.list;

public class LC206_ReverseList {

    public static void main(String[] args) {

    }


    public ListNode reverseList(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }
        ListNode pre = null;
        ListNode p = head;
        ListNode next = null;
        while (p != null){
            next = p.next;
            p.next = pre;
            pre = p;
            p = next;
        }
        return pre;
    }
    class ListNode{
        int val;
        ListNode next;
        ListNode(){};
        ListNode(int val) { this.val = val; }
         ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

}
