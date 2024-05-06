package com.bmilk.algorithm.list;

import java.util.List;

public class LC19_RemoveNthFromEnd {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if(null == head || 0>= n){
            return head;
        }
        ListNode quick = head;
        for (int i = 0; i<n-1; i++){
            if(quick.next != null){
                quick = quick.next;
            }else {
                return head;
            }
        }
        ListNode pre = new ListNode();
        ListNode p = pre;
        pre.next = head;
        ListNode slow = head;
        while (quick.next != null){
            pre = pre.next;
            slow = slow.next;
            quick = quick.next;
        }
        pre.next = pre.next.next;
        slow.next = null;
        return p.next;

    }


      static class ListNode {
         int val;
         ListNode next;
          ListNode() {}
          ListNode(int val) { this.val = val; }
          ListNode(int val, ListNode next) { this.val = val; this.next = next; }
      }

}
