package com.bmilk.algorithm.list;

public class LC141_HasCycle {

    public static void main(String[] args) {
        ListNode node = new ListNode(1);
        LC141_HasCycle  o= new LC141_HasCycle();
        boolean b = o.hasCycle(node);
        System.out.println(b);
    }


    public boolean hasCycle(ListNode head) {

        if(null == head || null == head.next){
            return false;
        }
        ListNode p1 = head;
        ListNode p2 = head.next;
        while (p1!= null && p2!= null){
            if(p1 == p2){
                return true;
            }
            p1 = p1.next;
            p2 = p2.next;
            if(p2 != null){
                p2= p2.next;
            }
        }
        return false;

    }


    private static class ListNode{
        private int val;
        private ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
}
