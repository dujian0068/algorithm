package com.bmilk.algorithm.list;

public class LC148_SortList {

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

    }
}
