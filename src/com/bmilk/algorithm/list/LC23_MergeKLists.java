package com.bmilk.algorithm.list;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class LC23_MergeKLists {


    public ListNode mergeKLists(ListNode[] lists) {

        if(null == lists){
            return null;
        }
        if(lists.length == 1){
            return lists[0];
        }

        PriorityQueue<ListNode> queue = new PriorityQueue<>(new Comparator<ListNode>() {
            @Override
            public int compare(ListNode o1, ListNode o2) {
                return o1.val - o2.val;
            }
        });
        for (ListNode node : lists){
            if( null != node){
                queue.add(node);
            }
        }

        ListNode header = new ListNode();
        ListNode p = header;
        while (!queue.isEmpty()){
            ListNode poll = queue.poll();
            if(null == poll) continue;
            p.next= poll;
            p = p.next;
            if(null != poll.next){
                queue.add(poll.next);
            }
        }
        return header.next;
    }

}

class ListNode{
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}
