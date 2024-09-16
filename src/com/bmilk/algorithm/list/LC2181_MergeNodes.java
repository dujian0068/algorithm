package com.bmilk.algorithm.list;

import java.util.List;

public class LC2181_MergeNodes {
    public ListNode mergeNodes(ListNode head) {
        ListNode res = new ListNode();
        int num = 0;
        ListNode tmp = res;
        ListNode p = head.next;
        while (p != null){
            num += p.val;
            if(p.val == 0){
                tmp.next = new ListNode(num);
                tmp = tmp.next;
                num = 0;
            }
            p= p.next;
        }
        return res.next;
    }
}
