package com.bmilk.algorithm.list;

public class LC160_GetIntersectionNode {

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {

        ListNode p1 = headA;
        ListNode p2 = headB;

        boolean c1 = false;
        boolean c2 = false;
        while (p1 != null && p2!= null){
            if(p1 == p2){
                return p1;
            }
            p1 = p1.next;
            p2 = p2.next;
            if(p1 == null && !c1){
                p1=headB;
                c1 = true;
            }
            if(p2 == null && !c2){
                p2= headA;
                c2 = true;
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


