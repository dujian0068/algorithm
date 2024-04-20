package com.bmilk.algorithm.list;

public class LC143_ReorderList {

    public static void main(String[] args) {
        LC143_ReorderList o = new LC143_ReorderList();

        ListNode node3 = new ListNode(3,null);
        ListNode node2 = new ListNode(2, node3);
        ListNode node1 = new ListNode(1, node2);
        ListNode node = o.reverseList(node1);
        while (null != node){

            System.out.println(node.val);
            node = node.next;
        }
    }

    public void reorderList(ListNode head) {

        if(null == head || null == head.next){
            return;
        }

        ListNode q = head.next;
        ListNode s = head;
        while (q.next!= null && q.next.next!=null){
            q = q.next.next;
            s = s.next;
        }
        ListNode p1 = head;
        ListNode p2 = reverseList(s.next);;
        s.next = null;
        ListNode p = new ListNode();


        while ( null != p1 && null != p2){
            p.next = p1;
            p1 = p1.next;
            p.next.next = p2;
            p2 = p2.next;
            p = p.next.next;
        }
        if( null != p1) {
            p.next = p1;
        }else {
            p.next = p2;
        }

    }

    public ListNode reverseList(ListNode head){
        if ( null == head || null == head.next){
            return head;
        }

        ListNode p1 = null;
        ListNode p2 = head;
        ListNode p3 = head.next;

        while (null != p3){
            p2.next = p1;
            p1 = p2;
            p2 = p3;
            p3 = p3.next;
        }
        p2.next = p1;
        return p2;
    }
}
