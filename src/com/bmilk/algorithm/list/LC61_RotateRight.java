package com.bmilk.algorithm.list;

import java.util.List;

public class LC61_RotateRight {
    public ListNode rotateRight(ListNode head, int k) {

        if(null == head){
            return head;
        }
        int i = 0;
        ListNode p1 = head;
        while (i <k ){
            i++;
            p1 = p1.next;
            if(p1 == null){
                p1 = head;
            }
        }
        ListNode p2 = head;
        while (p1.next != null){
            p1=p1.next;
            p2 = p2.next;
        }
        p1.next = head;
        head = p2.next;
        p2.next = null;
        return head;

    }

    private static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

    }
}
