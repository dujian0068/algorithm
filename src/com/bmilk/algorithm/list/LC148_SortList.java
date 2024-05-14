package com.bmilk.algorithm.list;

public class LC148_SortList {
    public static void main(String[] args) {
        LC148_SortList o = new LC148_SortList();
        ListNode node3 = new ListNode(0);
        ListNode node1 = new ListNode(4, node3);
        ListNode node2 = new ListNode(3, node1);
        ListNode node4 = new ListNode(5, node2);
        ListNode node5 = new ListNode(-1, node4);
        ListNode listNode = o.sortList2(node5);
    }

    public ListNode sortList2(ListNode head) {
        if(null == head || head.next == null){
            return head;
        }

        ListNode p = head;
        int len = 0;
        while (null != p){
            p = p.next;
            len ++;
        }
        int subLen = 1;
        while (subLen < len){
            ListNode pre = new ListNode();
            ListNode p1 = head;
            p = head;
            head = null;
            while (null != p ){
                ListNode head1 = p;
                pre.next = head1;
                p = pre;
                int subListLen = 0;
                while (null != p && subListLen< subLen){
                    p = p.next;
                    subListLen++;
                }
                ListNode head2 = null;
                if(null != p){
                    subListLen = 0;
                    head2 = p.next;
                    p.next = null;
                    pre.next = head2;
                    p = pre;
                    while (null != p && subListLen< subLen){
                        p = p.next;
                        subListLen++;
                    }
                }
                if(null != p) {
                    pre.next = p.next;
                    p.next = null;
                }else {
                    pre.next = null;
                }
                ListNode listNode = mergeTwoSortList(head1, head2);
                if( null == head){
                    head = listNode;
                    p1 = head;
                }else {
                    p1.next = listNode;
                }
                while (p1.next != null){
                    p1 = p1.next;
                }
                p1.next = pre.next;
                p = pre.next;
            }
            subLen *= 2;
        }
        return head;
    }

    public ListNode sortList(ListNode head) {
        if(null == head || head.next == null){
            return head;
        }
        ListNode slow = head;
        ListNode quick = head;
        while (quick.next != null && quick.next.next != null){
            quick= quick.next.next;
            slow = slow.next;
        }
        ListNode list2 = sortList(slow.next);
        slow.next = null;
        ListNode list1 = sortList(head);
        ListNode listNode = mergeTwoSortList(list1, list2);
        return listNode;
    }

    public ListNode mergeTwoSortList(ListNode head1,  ListNode head2){
        if(null == head1) return head2;
        if(null == head2) return head1;
        ListNode head = new ListNode();
        ListNode p = head;
        while (null != head1 && null != head2){
            if(head1.val <= head2.val){
                p.next = head1;
                head1 = head1.next;
            }else {
                p.next = head2;
                head2 = head2.next;
            }
            p = p.next;
        }
        if(null != head1){
            p.next = head1;
        }else {
            p.next = head2;
        }
        return head.next;
    }


    static class ListNode{

        int val;
        ListNode next;

        ListNode(){}

        public ListNode(int val) {
            this.val = val;
        }

        public ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
}
