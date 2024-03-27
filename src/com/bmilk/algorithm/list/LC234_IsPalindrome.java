package com.bmilk.algorithm.list;

public class LC234_IsPalindrome {

    public boolean isPalindrome(ListNode head) {
        ListNode node = new ListNode(head.val);
        ListNode p = head.next;
        while (null != p){
            node = new ListNode(p.val, node);
            p = p.next;
        }
        ListNode p2 = node;
        p = head;
        while (null != p){
            if(p.val != p2.val){
                return false;
            }
            p=p.next;
            p2=p2.next;
        }
        return true;


    }

    private static class ListNode{
        private int val;
        private ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
}
