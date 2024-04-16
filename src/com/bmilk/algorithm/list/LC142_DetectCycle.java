package com.bmilk.algorithm.list;

public class LC142_DetectCycle {

    public ListNode detectCycle(ListNode head) {
        if(null == head){
            return null;
        }

        ListNode p1 = head;
        ListNode p2 = head;

        while (p1.next!= null && p2.next!= null && p2.next.next!= null){
            p1= p1.next;
            p2 = p2.next.next;
            if(p1 == p2){
                break;
            }
        }
        if(p1.next!= null && p2.next!= null && p2.next.next!= null){
            p2 = head;
            while (true){
                if(p1 == p2){
                    return p1;
                }
                p1 = p1.next;
                p2 = p2.next;
            }
        }
        return null;
    }


    static class ListNode{

        int val;
        ListNode next;

        public ListNode(int val) {
            this.val = val;
            next = null;
        }
    }
}
