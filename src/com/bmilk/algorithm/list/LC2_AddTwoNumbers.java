package com.bmilk.algorithm.list;

public class LC2_AddTwoNumbers {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = new ListNode();
        int tmp = 0;
        ListNode p1 = l1;
        ListNode p2 = l2;
        ListNode p = head;
        while (null != p1 && null != p2) {

            p.next = new ListNode((p1.val + p2.val + tmp) % 10);
            tmp = (p1.val + p2.val + tmp) / 10;
            p1 = p1.next;
            p2 = p2.next;
            p = p.next;
        }
        ListNode node = null == p1 ? p2 : p1;
        while (null != node) {
            p.next = new ListNode((node.val + tmp) % 10);
            tmp = (node.val + tmp) / 10;
            p = p.next;
            node = node.next;
        }
        if( 0 != tmp){
            p.next = new ListNode(tmp);
        }
        return head.next;
    }


    static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
}
